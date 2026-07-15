package com.rushi.e_commerce.authentication;

import com.rushi.e_commerce.authentication.dto.login.LoginRequest;
import com.rushi.e_commerce.authentication.dto.login.LoginResponse;
import com.rushi.e_commerce.authentication.dto.register.RegisterRequest;
import com.rushi.e_commerce.authentication.dto.register.RegisterResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;
    @PostMapping("/register")
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){
        return service.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return service.login(request);
    }
}
