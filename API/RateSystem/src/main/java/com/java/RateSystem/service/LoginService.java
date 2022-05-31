package com.java.RateSystem.service;

import com.java.RateSystem.models.User;
import com.java.RateSystem.repository.LoginRepository;
import com.java.RateSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

//    public User registerUser(String name, String password, String email, String role){
//        if(name == null && password == null){
//            return null;
//        }else {
//            User user = new User();
//            user.setName(name);
//            user.setPassword(password);
//            user.setEmail(email);
//            user.setRole(role);
//            return loginRepository.save(user);
//        }
//    }

    public User authenticate(String name, String password){
        return loginRepository.findByLoginAndPassword(name,password).orElse(null);
    }
}
