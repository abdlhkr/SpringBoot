package com.example.JWT.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    // bana gerektiğinde key oluşturan gerektiğinde keyden
    // istenilen  bilgileri bana dönen sınıf
    public static final String SECRET_KEY = "AAa57GAIy8Qsgg80e2VXBr7JxCluDuoyXzFUu/Szwus=";

    public String generateToken(UserDetails details){
        Map<String, Object> claims = new HashMap<>();
        claims.put("ROLE", "ROLE_USER");
        return Jwts.builder()
                .setSubject(details.getUsername())
                .claims(claims)
                .setIssuedAt(new Date())
                .setExpiration((new Date(System.currentTimeMillis() + 1000 * 60 * 20))) // 2 dakika geçerli olacak
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getKey(){
            byte[] keyBytes = Decoders.BASE64.decode((SECRET_KEY));
            return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims getClaims(String token){
        Claims claims = Jwts
                .parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token).getBody();
        return  claims;
    }

    public Object getRoleByClaims(String token,String key){
            Claims claims = getClaims(token);
            return  claims.get("ROLE");
    }

    public <T> T exporteToken(String token, Function<Claims,T> claimsTFunction){
            Claims claims = getClaims(token);
            return claimsTFunction.apply(claims);
    }

    public String getUsernameFromToken(String token){
        return exporteToken(token, Claims::getSubject);
        // aslında subject olarak belirlenmiş nesneyi döndürüyoruz
        // burda subject username olduğu için o geliyor
    }

    public boolean isTokenExpired(String token){
        Date experationDate = exporteToken(token,Claims::getExpiration);
        return experationDate.before(new Date());
    }
}
