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
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class AccountRecordController {
    @Autowired    private AccountRecordRepository accountrecordrepository;
    @Autowired    private DepartmentsRepository departmentsrepository;
    @Autowired    private GiveToRepository givetorepository;
    @Autowired    private IncomeExpensesRepository incomeexpensesrepository;


    @Autowired AccountRecordController(AccountRecordRepository accountrecordrepository){
        this.accountrecordrepository = accountrecordrepository;
    }
    @GetMapping(path="/AccountRecord",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AccountRecord> AccountRecord(){
        return accountrecordrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/AccountRecord/{Time}/{Title}/{Inout}/{Department}/{Type}/{Amount}",produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountRecord accountrecord(AccountRecord a, @PathVariable Date Time,
                                       @PathVariable String Title, @PathVariable String Inout,
                                       @PathVariable String Department, @PathVariable String Type,
                                       @PathVariable String Amount){

        Departments d = departmentsrepository.findByNameDepartment(Department);
        System.out.println(Department);
        GiveTo  gt = givetorepository.findByGiveTo(Type);
        System.out.println(Type);
        IncomeExpenses inout = incomeexpensesrepository.findByIncomeExpenses(Inout);
        System.out.println(Inout);
        a.setSavedate(Time);
        a.setTitle(Title);
        a.setIncomeExpenses(inout);
        a.setIncomeexpense(Inout);
        a.setDepartments(d);
        a.setGiveTo(gt);
        a.setGiveto(Type);
        a.setAmount(Amount);

        return accountrecordrepository.save(a);


    }
}
