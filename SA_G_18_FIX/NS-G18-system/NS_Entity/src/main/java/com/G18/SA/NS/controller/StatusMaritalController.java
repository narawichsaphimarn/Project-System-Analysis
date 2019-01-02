
package com.G18.SA.NS.controller;
import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

import java.util.stream.Collectors;
@CrossOrigin(origins =  "http://localhost:4200")
@RestController
public class StatusMaritalController {
    private StatusMaritalRepository statusMaritalRepository;
    public StatusMaritalController(StatusMaritalRepository statusMaritalRepository){
        this.statusMaritalRepository = statusMaritalRepository;
    }

    @GetMapping("/statusmaritals")
    public Collection<StatusMarital> status_marital(){
        return statusMaritalRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/statusmarital/{status}")
    public StatusMarital add(@PathVariable String status){
        StatusMarital st = new StatusMarital(status);
        return statusMaritalRepository.save(st);
    } 


}

