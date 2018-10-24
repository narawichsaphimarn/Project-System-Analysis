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
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @GetMapping("/Country")
    public Collection<CountryEntity> getCountryName(){
        return countryRepository.findAll().stream().collect(Collectors.toList());
    }
}
