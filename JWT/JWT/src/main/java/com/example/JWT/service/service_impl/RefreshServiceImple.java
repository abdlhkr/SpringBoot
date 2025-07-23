package com.example.JWT.service.service_impl;

import com.example.JWT.entity.RefreshToken;
import com.example.JWT.entity.RefreshTokenRequest;
import com.example.JWT.entity.User;
import com.example.JWT.jwt.AuthResponse;
import com.example.JWT.jwt.JwtService;
import com.example.JWT.repository.RefreshTokenRepository;
import com.example.JWT.service.IRefresshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshServiceImple implements IRefresshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;
    @Autowired
    JwtService jwtService;

    public boolean isExpired(Date expiredDate){
        return new Date().before(expiredDate);
    }

    public RefreshToken createRefreshToken(User user) {
        RefreshToken  refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4)); // 4 dakika bi token
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    @Override
    public AuthResponse refresh(RefreshTokenRequest refreshToken) {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findRefreshTokensByRefreshToken(refreshToken.getRefreshToken());
        if (optionalRefreshToken.isPresent()) {
            if (!isExpired(optionalRefreshToken.get().getExpireDate())){
                System.out.println("Refresh token expired babba : " +  refreshToken.getRefreshToken());
            }
            String accessToken =  jwtService.generateToken(optionalRefreshToken.get().getUser());
            RefreshToken refreshTokenV2 = createRefreshToken(optionalRefreshToken.get().getUser());
            RefreshToken savedRefreshToken = refreshTokenRepository.save(refreshTokenV2);
            return new AuthResponse(accessToken,refreshTokenV2.getRefreshToken());
        }else{
            System.out.println("sallama : " + refreshToken.getRefreshToken());
            return null;
        }
    }
}
