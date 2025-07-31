package com.GaleriProject.GaleriProject.service.serviceIMPL;

import com.GaleriProject.GaleriProject.dto.AuthRequest;
import com.GaleriProject.GaleriProject.dto.AuthResponse;
import com.GaleriProject.GaleriProject.dto.DtoUser;
import com.GaleriProject.GaleriProject.dto.RefreshTokenRequest;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import com.GaleriProject.GaleriProject.jwt.JwtService;
import com.GaleriProject.GaleriProject.model.RefreshToken;
import com.GaleriProject.GaleriProject.model.User;
import com.GaleriProject.GaleriProject.repository.RefreshTokenRepository;
import com.GaleriProject.GaleriProject.repository.UserRepository;
import com.GaleriProject.GaleriProject.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthebticationServiceImpl implements IAuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationProvider  authenticationProvider;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    // burda password şifreleneceği için beanutils le kopyalamadım
    private User createUser(AuthRequest authRequest) {
        User user = new User();
        user.setCreateDate(new Date());
        user.setUsername(authRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public DtoUser regsiter(AuthRequest authRequest) {
        User user = createUser(authRequest);
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(user,dtoUser);
        return dtoUser;
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        Duration duration = Duration.ofDays(480);
        long yearMillis = duration.toMillis();
        refreshToken.setCreateDate(new Date());
        refreshToken.setUser(user);
        refreshToken.setExpirationDate(new Date(System.currentTimeMillis() + yearMillis));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
             authenticationProvider.authenticate(authenticationToken);
            Optional<User> dbUser = userRepository.findByUsername(authRequest.getUsername());
            if (dbUser.isPresent()) {
                String accessToken = jwtService.generateToken(dbUser.get());
                RefreshToken refreshToken = createRefreshToken(dbUser.get());
                refreshTokenRepository.save(refreshToken);
                return new AuthResponse(accessToken, refreshToken.getRefreshToken());
            }else{
                throw new BaseException(new ErrorMessage(MessageType.USER_NAME_OR_PASSWORD_INVALID, ""));
            }
        }catch (Exception e){
            throw new BaseException(new ErrorMessage(MessageType.USER_NAME_OR_PASSWORD_INVALID, e.getMessage()));
        }
    }


    public boolean isInvalidRefreshToken(Date expirationDate) {
        return new Date().before(expirationDate);

    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest authRequest) {
        Optional<RefreshToken> optRefreshToken = refreshTokenRepository.findByRefreshToken(authRequest.getRefreshToken());
        if (optRefreshToken.isPresent()) {
            if(isInvalidRefreshToken(optRefreshToken.get().getExpirationDate())) {
                User user = optRefreshToken.get().getUser();
                RefreshToken refreshToken = createRefreshToken(user);
                String accessToken = jwtService.generateToken(user);
                RefreshToken dbRefreshToken = refreshTokenRepository.save(refreshToken);

                return new AuthResponse(accessToken, dbRefreshToken.getRefreshToken());
            }else{
                throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED,optRefreshToken.get().getRefreshToken() + " is expired"));
            }
        }else {
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_DOESNT_EXIST,""));
        }
    }


}
