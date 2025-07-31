package com.GaleriProject.GaleriProject.service;


import com.GaleriProject.GaleriProject.dto.AuthRequest;
import com.GaleriProject.GaleriProject.dto.AuthResponse;
import com.GaleriProject.GaleriProject.dto.DtoUser;
import com.GaleriProject.GaleriProject.dto.RefreshTokenRequest;
import com.GaleriProject.GaleriProject.model.RefreshToken;

import java.util.Optional;

// regester authentication refresh token
public interface IAuthenticationService {
    public DtoUser regsiter(AuthRequest authRequest);
    public AuthResponse authenticate(AuthRequest authRequest);
    public AuthResponse refreshToken(RefreshTokenRequest authRequest);
}
