package com.java.RateSystem.controller;

import com.java.RateSystem.jwt.CustomUserDetails;
import com.java.RateSystem.jwt.JwtTokenProvider;
import com.java.RateSystem.models.LoginRequest;
import com.java.RateSystem.models.LoginResponse;
import com.java.RateSystem.models.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "", exposedHeaders = "*")
@RestController
@RequestMapping("")
public class TestTokenController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    @GetMapping("/admin")
    public ResponseEntity<ResponseObject> randomStuff(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Access by using JWT successfully")
        );
    }
}
