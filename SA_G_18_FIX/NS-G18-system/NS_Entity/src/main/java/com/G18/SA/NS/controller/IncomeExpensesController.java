package com.G18.SA.NS.controller;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class IncomeExpensesController {
    @Autowired    private IncomeExpensesRepository incomeexpensesrepository;

    @Autowired IncomeExpensesController(IncomeExpensesRepository incomeexpensesrepository){
        this.incomeexpensesrepository = incomeexpensesrepository;
    }
    @GetMapping(path = "/IncomeExpenses",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<IncomeExpenses> IncomeExpenses(){
        return incomeexpensesrepository.findAll().stream().collect(Collectors.toList());
    }

}
