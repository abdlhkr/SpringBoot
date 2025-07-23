package com.example.JWT.service;

import com.example.JWT.entity.RefreshTokenRequest;
import com.example.JWT.jwt.AuthResponse;

public interface IRefresshTokenService {
    public AuthResponse refresh(RefreshTokenRequest refreshToken);
}
