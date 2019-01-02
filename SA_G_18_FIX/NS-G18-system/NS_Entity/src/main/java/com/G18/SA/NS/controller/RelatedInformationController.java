package com.G18.SA.NS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URLDecoder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class RelatedInformationController {
    @Autowired
    private RelatedInformationRepository relatedInformationRepository;
    @Autowired
    private AgencyTypeRepository agencyTypeRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ContactTimeRepository contactTimeRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    public RelatedInformationController(RelatedInformationRepository relatedInformationRepository,AgencyTypeRepository agencyTypeRepository
                                        ,CountryRepository countryRepository,ContactTimeRepository contactTimeRepository
                                        ,ProvinceRepository provinceRepository){
        this.relatedInformationRepository = relatedInformationRepository;
        this.agencyTypeRepository = agencyTypeRepository;
        this.countryRepository = countryRepository;
        this.contactTimeRepository = contactTimeRepository;
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/RelatedInformation")
    public Collection<RelatedInformationEntity> RelatedInformation(){
        return relatedInformationRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/RelatedInformation/{agent}/{provin}/{country}/{Nameoforganization}/{Workingtime}/{Workingday}/{Addressagency}/{Contacttime}/{Inputdataphonenumber}/{Inputdatafacebook}/{Inputdataline}/{Inputdatae_mail}")
    public RelatedInformationEntity related(@PathVariable String agent,
                                                 @PathVariable String provin, @PathVariable String country,
                                                 @PathVariable String Nameoforganization, @PathVariable String Workingtime,
                                                 @PathVariable String Workingday, @PathVariable String Addressagency, @PathVariable String Contacttime, @PathVariable String Inputdataphonenumber,
                                                 @PathVariable String Inputdatafacebook, @PathVariable String Inputdataline, @PathVariable String Inputdatae_mail) {
        RelatedInformationEntity r = new RelatedInformationEntity();
        AgencyTypeEntity a = agencyTypeRepository.findByagencyName(agent);
        System.out.println(agent);
        ContactTimeEntity ct = contactTimeRepository.findBycontactTimeName(Contacttime);
        System.out.println(Contacttime);
        CountryEntity c = countryRepository.findBycountryName(country);
        System.out.println(country);
        ProvinceEntity p = provinceRepository.findByprovinceName(provin);
        System.out.println(provin);
        r.setAgencyTypeEntity(a);
        r.setContactTimeEntity(ct);
        r.setCountryEntity(c);
        r.setRelatedinformationAddress(Addressagency);
        r.setRelatedinformationDay(Workingday);
        r.setRelatedinformationTime(Workingtime);
        r.setRelatedinformationName(Nameoforganization);
        r.setRelatedinformationPhone(Inputdataphonenumber);
        r.setRelatedinformationFacebook(Inputdatafacebook);
        r.setRelatedinformationLine(Inputdataline);
        r.setRelatedinformationEmail(Inputdatae_mail);
        r.setProvinceEntity(p);

        return relatedInformationRepository.save(r);
    }

     @PutMapping("/updateRelatedInformation/{relatedinformationID}/{relatedinformationName}/{relatedinformationDay}/{relatedinformationTime}/{relatedinformationAddress}/{relatedinformationPhone}/{relatedinformationEmail}/{relatedinformationFacebook}/{relatedinformationLine}/{agencyName}/{contactTimeName}/{countryName}/{provinceName}")
     public RelatedInformationEntity editRelatedInformation(@RequestBody RelatedInformationEntity relatedInformation,@PathVariable Long relatedinformationID,@PathVariable String relatedinformationName, @PathVariable String relatedinformationDay, @PathVariable String relatedinformationTime, @PathVariable String relatedinformationAddress, @PathVariable String relatedinformationPhone, @PathVariable String relatedinformationEmail,@PathVariable String relatedinformationFacebook,@PathVariable String relatedinformationLine,@PathVariable String agencyName,@PathVariable String contactTimeName, @PathVariable String countryName,@PathVariable String provinceName){
         AgencyTypeEntity a = agencyTypeRepository.findByagencyName(agencyName);
         ContactTimeEntity ct = contactTimeRepository.findBycontactTimeName(contactTimeName);
         CountryEntity c = countryRepository.findBycountryName(countryName);
         ProvinceEntity p = provinceRepository.findByprovinceName(provinceName);
         return relatedInformationRepository.findById(relatedinformationID).map(roomedit ->{
                     roomedit.setRelatedinformationID(relatedinformationID);
                     roomedit.setRelatedinformationName(relatedinformationName);
                     roomedit.setRelatedinformationAddress(relatedinformationAddress);
                     roomedit.setRelatedinformationTime(relatedinformationTime);
                     roomedit.setRelatedinformationDay(relatedinformationDay);
                     roomedit.setRelatedinformationPhone(relatedinformationPhone);
                     roomedit.setRelatedinformationEmail(relatedinformationEmail);
                     roomedit.setRelatedinformationFacebook(relatedinformationFacebook);
                     roomedit.setRelatedinformationLine(relatedinformationLine);
                     roomedit.setAgencyTypeEntity(a);
                     roomedit.setContactTimeEntity(ct);
                     roomedit.setCountryEntity(c);
                     roomedit.setProvinceEntity(p);
                     return relatedInformationRepository.save(roomedit);
                 }
                 ).orElseGet(() ->{
                     return relatedInformationRepository.save(relatedInformation);
         });
     }
}
