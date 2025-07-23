package com.example.JWT.jwt;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    // private String token; eski bu sıkıntılı olan
    private String accessToken;
    private String refreshToken;
}
