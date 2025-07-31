package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.IRestAuthenticationController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.AuthRequest;
import com.GaleriProject.GaleriProject.dto.AuthResponse;
import com.GaleriProject.GaleriProject.dto.DtoUser;
import com.GaleriProject.GaleriProject.dto.RefreshTokenRequest;
import com.GaleriProject.GaleriProject.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestAuthentiationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;


    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@RequestBody @Valid AuthRequest input) {
        DtoUser dbUser = authenticationService.regsiter(input);
        return RootEntity.ok(dbUser);
    }

    @PostMapping("/login")
    @Override
    public RootEntity<AuthResponse> login(@RequestBody @Valid AuthRequest input) {
        AuthResponse authResponse = authenticationService.authenticate(input);
        return RootEntity.ok(authResponse);
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@RequestBody @Valid RefreshTokenRequest input) {
        return RootEntity.ok(authenticationService.refreshToken(input));
    }
}
