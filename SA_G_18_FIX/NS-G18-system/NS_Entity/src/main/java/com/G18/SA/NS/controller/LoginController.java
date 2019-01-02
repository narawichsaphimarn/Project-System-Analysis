package com.G18.SA.NS.controller;
import com.G18.SA.NS.entity.*;
import com.G18.SA.NS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    @GetMapping("/logins")
    public Collection<Login> login() {
        return loginRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/login/{username}/{password}")
    public Boolean isLogin(@PathVariable String username,@PathVariable Long password){
        Long m = loginRepository.isLogin(username,password);
        if(m!=null)
            return true;
        return false;
    }
}
