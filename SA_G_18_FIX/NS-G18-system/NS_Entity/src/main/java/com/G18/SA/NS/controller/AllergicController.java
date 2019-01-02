
package com.G18.SA.NS.controller;

import java.util.Collection;
import java.util.stream.Collectors;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins =  "http://localhost:4200")
@RestController
public class AllergicController {

    @Autowired
    private ElderRepository elderRepository;

    private AllergicRepository allergicRepository;
    public AllergicController(AllergicRepository allergicRepository){ //ชื่อrepo+controller
        this.allergicRepository = allergicRepository;
    }
    @GetMapping("/allergics")
    public Collection<Allergic> allergic(){//ชื่อrEntity+ปรับเป็นตัวเล็ก
        return allergicRepository.findAll().stream()
        .collect(Collectors.toList());
    }
    @GetMapping("/allergic/{drag}")
    public Allergic newAllergic( @PathVariable String drag){
        Allergic al = new Allergic(drag);
        return allergicRepository.save(al);
    }
}

