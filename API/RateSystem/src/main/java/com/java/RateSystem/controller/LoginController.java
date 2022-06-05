package com.java.RateSystem.controller;

import com.java.RateSystem.models.User;
import com.java.RateSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "", exposedHeaders = "*")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("login request: " + user);
        User authenticated = loginService.authenticate(user.getName(), user.getPassword());
        if (authenticated != null){
            return "Ok";
        }
        else {
            return "Error";
        }
    }
}
