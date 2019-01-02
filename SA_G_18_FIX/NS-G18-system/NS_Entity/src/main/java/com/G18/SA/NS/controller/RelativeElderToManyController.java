package com.G18.SA.NS.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins =  "http://localhost:4200")
@RestController
public class RelativeElderToManyController {

    @Autowired
    private ElderRepository elderRepository;

    @Autowired
    private RelativeRepository relativeRepository;

    private RelativeElderToManyRepository relativeElderToManyRepository;
    public RelativeElderToManyController(RelativeElderToManyRepository relativeElderToManyRepository){ //ชื่อrepo+controller
        this.relativeElderToManyRepository = relativeElderToManyRepository;
    }
    @GetMapping("/relativeelders")
    public Collection<RelativeElderToMany> relative(){//ชื่อrEntity+ปรับเป็นตัวเล็ก
        return relativeElderToManyRepository.findAll().stream()
        .collect(Collectors.toList());
    }

    @GetMapping("/relativeelder/{elder}/{relative}")
    public RelativeElderToMany newRelative(@PathVariable String elder, @PathVariable String relative){
        RelativeElderToMany reel = new RelativeElderToMany();
        Elder el  = elderRepository.findByElder(elder);
        Relative re = relativeRepository.findByRelative(relative);
        reel.setRelative(re);
        reel.setElder(el);
        return relativeElderToManyRepository.save(reel);
    }
}

