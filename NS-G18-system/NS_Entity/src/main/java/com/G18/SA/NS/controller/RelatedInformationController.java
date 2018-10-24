package com.G18.SA.NS.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
// import java.util.Date;
// import java.util.Optional;
import java.util.stream.Collectors;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

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
}
