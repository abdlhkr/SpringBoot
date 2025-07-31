package com.GaleriProject.GaleriProject.jwt;

import com.GaleriProject.GaleriProject.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    String SECRET_KEY = "Op5vp6Wks4hgP0hwkSHjxPwCk+9tZvA7Ac2PfXWne6E=";



    public String generateToken(UserDetails userDetails) {
        User user = (User) userDetails;
        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLE", "ROLE_USER");
        Duration duration = Duration.ofDays(360);
        long yearMillis = duration.toMillis();
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claims(claims)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + yearMillis))
                .signWith(getKey())
                .compact();
    }

    public <T> T extractToken(String token , Function<Claims, T> claimsFun) {
        Claims claims = getClaims(token);
        return claimsFun.apply(claims);
    }

    public String getUsernameByToken(String token) {
        return extractToken(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token){
        Date expireDate = extractToken(token, Claims::getExpiration);
        return expireDate.before(new Date());
    }

    public String getRoleByToken(String token) {
        return getClaims(token).get("role",String.class);
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



    public Key getKey(){

        byte[] bytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }
}
