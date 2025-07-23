package com.example.JWT.service.service_impl;

import com.example.JWT.dto.DtoUser;
import com.example.JWT.entity.RefreshToken;
import com.example.JWT.entity.User;
import com.example.JWT.jwt.AuthRequest;
import com.example.JWT.jwt.AuthResponse;
import com.example.JWT.jwt.JwtService;
import com.example.JWT.repository.RefreshTokenRepository;
import com.example.JWT.repository.UserRepository;
import com.example.JWT.service.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;


    private RefreshToken createRefreshToken(User user) {
        RefreshToken  refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4)); // 4 dakika bi token
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(auth);
            Optional<User> user = userRepository.findByUsername(request.getUsername());
            String accessToken = jwtService.generateToken(user.get());
            RefreshToken refreshToken = createRefreshToken(user.get());
            RefreshToken dbRefreshToken = refreshTokenRepository.save(refreshToken);
            return new AuthResponse(accessToken,dbRefreshToken.getRefreshToken());
        }catch (Exception e){
            System.out.println("kullanıcı adı veya şifre hatalı "+e.getMessage());
        }
        return null;
    }

    @Override
    public DtoUser register(AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
        // veri tabanına şifreli at kullanıcı kontrol yaparken yine
        // şifrele ben yani database sahibi şifreyi hiç göremeyim
        User savedUser = userRepository.save(user);
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }


}
