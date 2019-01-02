package com.G18.SA.NS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
// import java.util.Date;
// import java.util.Optional;
import java.util.stream.Collectors;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class AgencyTypeController {
    @Autowired
    private AgencyTypeRepository agencyTypeRepository;

    @Autowired
    public AgencyTypeController(AgencyTypeRepository agencyTypeRepository){
        this.agencyTypeRepository = agencyTypeRepository;
    }

    @GetMapping("/agencyType")
    public Collection<AgencyTypeEntity> getAgencyName(){
        return agencyTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/agencyType/{agencyTypeN}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AgencyTypeEntity getAgencyName(@PathVariable String agencyTypeN){
        AgencyTypeEntity AgencyType = new AgencyTypeEntity();
        AgencyType.setAgencyName(agencyTypeN);
        return agencyTypeRepository.save(AgencyType);
    }
}
