package com.example.JWT.service;

import com.example.JWT.dto.DtoUser;
import com.example.JWT.jwt.AuthRequest;
import com.example.JWT.jwt.AuthResponse;

public interface IAuthService {
    DtoUser register(AuthRequest authRequest);
    AuthResponse authenticate(AuthRequest request);
}
