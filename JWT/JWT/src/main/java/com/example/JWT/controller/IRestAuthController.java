package com.example.JWT.controller;

import com.example.JWT.dto.DtoUser;
import com.example.JWT.entity.RefreshTokenRequest;
import com.example.JWT.jwt.AuthRequest;
import com.example.JWT.jwt.AuthResponse;

public interface IRestAuthController {
    DtoUser register(AuthRequest authRequest);
AuthResponse authenticate(AuthRequest request);
    public AuthResponse refresh(RefreshTokenRequest refreshToken);
}
