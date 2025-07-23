package com.example.JWT.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
// OncePerRequest bunun bi filter sınıfı olduğunu ve
// controllera gelmeden önce bu sınıftan geçmesi gerektiğini belirtir
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header;
        String token;
        String username;
        header =  request.getHeader("Authorization");
        // bearer token authorization kısmına verilir
        // aslında şu an o değeri çekmeye çalışıyoruz
        if(header == null){
            filterChain.doFilter(request, response);
            return;
            // adamı controller katmanına göndermedik bile
            // direk iznin yok gibi düşün şifreyi boş geçmiş
        }

        token = header.substring(7);
        // Bearer token şeklinde ondan 7 den başladık

        try {
            username = jwtService.getUsernameFromToken(token);
            // işte böyle
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // şimdi tokeni çözdük username alanı var amaaa
                // böyle biri database de var mı ? bunuda
                // userDetailsService in loadUserByUsername metodu
                // ile kontrol ediyoruz
                // kullanıcı ile ilgili bilgiler userDetailse gidiyor
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (userDetails != null && !jwtService.isTokenExpired(token)) {
                    // burda artık kişiyi security contexte koyabiliriz demek
                    // controller katmanına girdi yani artık
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken
                                    (username, null,
                                            userDetails.getAuthorities());
                    authentication.setDetails(userDetails);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }catch (ExpiredJwtException e){
            System.out.println("JWT token expired");
        }catch (Exception e){
            System.out.println("genel bi hata oluştu : " + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
