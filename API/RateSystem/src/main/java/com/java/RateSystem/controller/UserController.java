package com.java.RateSystem.controller;

import com.java.RateSystem.models.ResponseObject;
import com.java.RateSystem.models.User;
import com.java.RateSystem.repository.UserRepository;
import com.java.RateSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = {})
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    //Call API
    @Autowired
    private UserService userService;
    @GetMapping("")
    List<User> getAllUserName(){return userService.findAll();}

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject>findByUserId(@PathVariable Integer id){
        Optional<User> foundUser = userService.findById(id);
        return foundUser.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry product successfully", foundUser)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("False","Cannot find", foundUser)
                );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertUser(@RequestBody User newUser){
        Optional<User> foundUser = userService.findByEmail(newUser.getEmail().trim());
        return foundUser.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Email already taken", "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Register User Name successfully",userService.save(newUser))
                );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateUser (@RequestBody User newUser, @PathVariable Integer id){
        User updateUser =  userService.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setRole(newUser.getRole());
                    return userService.save(user);
                }).orElseGet(()->{
                    newUser.setId(id);
                    return userService.save(newUser);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update User successfully",userService.save(newUser))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteUser (@PathVariable Integer id){
        boolean exists = userService.existsById(id);
        if(exists)
        {
            userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete User successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find User to delete ", "")
        );
    }
}
