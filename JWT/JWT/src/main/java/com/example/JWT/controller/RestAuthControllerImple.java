package com.example.JWT.controller;

import com.example.JWT.dto.DtoUser;
import com.example.JWT.entity.RefreshTokenRequest;
import com.example.JWT.jwt.AuthRequest;
import com.example.JWT.jwt.AuthResponse;
import com.example.JWT.service.IAuthService;
import com.example.JWT.service.service_impl.RefreshServiceImple;
import jakarta.security.auth.message.AuthStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class RestAuthControllerImple implements IRestAuthController{

    @Autowired
    private IAuthService authService;
    @Autowired
    private RefreshServiceImple refreshService;


    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest authRequest) {
        return authService.register(authRequest);
    }

    @PostMapping("/authentication")
    @Override
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }

    @PostMapping("/refresh")
    @Override
    public AuthResponse refresh(@RequestBody RefreshTokenRequest refreshToken) {
        return refreshService.refresh(refreshToken);
    }
}
