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
public class AllergicElderManyToManyController {

    @Autowired
    private ElderRepository elderRepository;

    @Autowired
    private AllergicRepository allergicRepository;

    private AllergicElderManyToManyRepository allergicElderManyToManyRepository;
    public AllergicElderManyToManyController(AllergicElderManyToManyRepository allergicElderManyToManyRepository){ //ชื่อrepo+controller
        this.allergicElderManyToManyRepository = allergicElderManyToManyRepository;
    }
    @GetMapping("/allergicelders")
    public Collection<AllergicElderManyToMany> allergic(){//ชื่อrEntity+ปรับเป็นตัวเล็ก
        return allergicElderManyToManyRepository.findAll().stream()
        .collect(Collectors.toList());
    }

    @GetMapping("/allergicelder/{elder}/{allergic}")
    public AllergicElderManyToMany newAllergic(@PathVariable String elder, @PathVariable String allergic){
        AllergicElderManyToMany alel = new AllergicElderManyToMany();
        Elder el  = elderRepository.findByElder(elder);
        Allergic al = allergicRepository.findByAllergic(allergic);
        alel.setAllergic(al);
        alel.setElder(el);
        return allergicElderManyToManyRepository.save(alel);
    }
}

