package com.G18.SA.NS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Date;
// import java.util.Optional;
import java.util.stream.Collectors;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceController(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/Province")
    public Collection<ProvinceEntity> getProvinceName(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
}
