
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
public class RelativeController {

    @Autowired
    private ProvinceRepository provinceRepository;

    private RelativeRepository relativeRepository;
    public RelativeController(RelativeRepository relativeRepository){ //ชื่อrepo+controller
        this.relativeRepository = relativeRepository;
    }
    @GetMapping("/relatives")
    public Collection<Relative> relative(){//ชื่อrEntity+ปรับเป็นตัวเล็ก
        return relativeRepository.findAll().stream()
        .collect(Collectors.toList());
    }
     @GetMapping("/relative/{name}/{lastname}/{status}/{personal}/{houseno}/{road}/{subdis}/{dis}/{province}/{postalcode}")
     /*(String relativeName, String relativeLastName, String relativeStatus, 
     Long relativePersonalId,String houseNo,String roadLane, String subDistrict, 
     String district, String province, int postalCode)*/
    public Relative newRelative( @PathVariable String name,@PathVariable String lastname,@PathVariable String status,@PathVariable Long personal,@PathVariable String houseno,@PathVariable String road,@PathVariable String subdis,@PathVariable String dis,@PathVariable String province,@PathVariable Integer postalcode){
        ProvinceEntity pv = provinceRepository.findByprovinceName(province);
        Relative re = new Relative(name, lastname, status, personal, houseno, road, subdis, dis, pv, postalcode);
        return relativeRepository.save(re);
    }
}
