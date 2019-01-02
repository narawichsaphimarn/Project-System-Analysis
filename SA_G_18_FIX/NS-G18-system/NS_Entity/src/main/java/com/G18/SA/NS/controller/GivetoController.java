package com.G18.SA.NS.controller;
import com.G18.SA.NS.entity.GiveTo;
import com.G18.SA.NS.repository.GiveToRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class GivetoController {
    @Autowired    private GiveToRepository givetorepository;

    @Autowired GivetoController(GiveToRepository givetorepository){
        this.givetorepository = givetorepository;
    }
    @GetMapping("/GiveTo")
    public Collection<GiveTo> getGiveTo(){
        return givetorepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/GiveTo/{id_GiveTo}")
    public GiveTo getOneGiveTo(@PathVariable Long id_GiveTo){
        return givetorepository.findById(id_GiveTo).get();
    }
}
