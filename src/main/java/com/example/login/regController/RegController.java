package com.example.login.regController;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.login.domain.Login;
import com.example.login.regService.RegService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegController {
    @Autowired
    private RegService service;

    @GetMapping("/registration")
    public String api() {
        return "registration";
    }

    @PostMapping("/reg")
    public String login(@ModelAttribute("user") Login user) {
 
        Login oauthUser = service.saveUser(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/dispReg";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/dispReg")
    public String display() {
        return "dispReg";
    }
    

}
