package com.java.RateSystem.controller;

import com.java.RateSystem.models.User;
import com.java.RateSystem.service.LoginService;
import com.java.RateSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin(origins = "*", allowedHeaders = "")
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new User());
        return "register_page" ;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request: " + user);
        User registerUser = loginService.registerUser(user.getName(), user.getPassword(), user.getEmail(), user.getRole());
        return registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login requset: " + user);
        User authenticated = loginService.authenticate(user.getName(), user.getPassword());
        if (authenticated != null){
            model.addAttribute("userLogin", authenticated.getName());
            return "personal_page";
        }
        else {
            return "error_page";
        }
    }
}
