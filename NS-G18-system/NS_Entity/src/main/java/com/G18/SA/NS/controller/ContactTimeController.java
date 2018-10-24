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
public class ContactTimeController {
    @Autowired
    private ContactTimeRepository contactTimeRepository;

    @Autowired
    public ContactTimeController(ContactTimeRepository contactTimeRepository){
        this.contactTimeRepository = contactTimeRepository;
    }

    @GetMapping("/ContactTime")
    public Collection<ContactTimeEntity> getContactTimeName(){
        return contactTimeRepository.findAll().stream().collect(Collectors.toList());
    }
}
