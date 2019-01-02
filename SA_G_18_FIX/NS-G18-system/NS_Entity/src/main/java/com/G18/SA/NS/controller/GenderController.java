
package com.G18.SA.NS.controller;
import java.util.Collection;

import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GenderController {
    private GenderRepository genderRepository;
    public GenderController(GenderRepository genderRepository){
        this.genderRepository = genderRepository;
    }

    @GetMapping("/genders")
    public Collection<Gender> gender(){
        return genderRepository.findAll().stream()
                .collect(Collectors.toList());
    }
   
   
    

    @GetMapping("/gender/{gender}")
    public Gender add(@PathVariable String gender){
        Gender gd = new Gender(gender);
        return genderRepository.save(gd);
    } 


}