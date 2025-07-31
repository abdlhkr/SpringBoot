package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.AuthRequest;
import com.GaleriProject.GaleriProject.dto.AuthResponse;
import com.GaleriProject.GaleriProject.dto.DtoUser;
import com.GaleriProject.GaleriProject.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {
    public RootEntity<DtoUser> register(AuthRequest input);
    public RootEntity<AuthResponse>  login(AuthRequest input);
    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
