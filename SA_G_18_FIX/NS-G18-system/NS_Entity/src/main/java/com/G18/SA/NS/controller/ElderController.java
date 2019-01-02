
package com.G18.SA.NS.controller;
import java.util.Collection;
import java.util.Date;
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
public class ElderController {
    @Autowired
    private StatusMaritalRepository statusMaritalRepository;

    @Autowired
    private GenderRepository genderRepository;

    
    private ElderRepository elderRepository;
    public ElderController(ElderRepository elderRepository){ //ชื่อrepo+controller
        this.elderRepository = elderRepository;
    }
    @GetMapping("/elders")
    public Collection<Elder> elder(){//ชื่อrEntity+ปรับเป็นตัวเล็ก
        return elderRepository.findAll().stream()
        .collect(Collectors.toList());
    }
    @GetMapping("/elder/{name}/{gender}/{statusmarital}")
    public Elder newElder(@PathVariable String name,@PathVariable String gender,@PathVariable String statusmarital){
        Gender gr = genderRepository.findByGender(gender);
        StatusMarital st = statusMaritalRepository.findByStatus("statusmarital");
        Elder el = new Elder(name, "test",gr,1301500263993L,new Date(),"cencer",st);
        return elderRepository.save(el);
    }
    @GetMapping("/elder/{name}/{lastname}/{gender}/{personal}/{birthdate}/{statusmarital}/{congenital}")
    public Boolean newElderFull(@PathVariable String name,@PathVariable String lastname,@PathVariable String gender,@PathVariable Long personal,@PathVariable Date birthdate,@PathVariable String statusmarital,@PathVariable String congenital){
        Long elderId= elderRepository.findAllByPersonal(personal);
        if (elderId != null)
            return false;
        else{
            StatusMarital st = statusMaritalRepository.findByStatus(statusmarital);
        Gender gr = genderRepository.findByGender(gender);
        Elder el = new Elder(name,lastname,gr,personal,birthdate,congenital,st);
        elderRepository.save(el);
        return true;
        }
        
    }
}

