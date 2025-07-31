package com.GaleriProject.GaleriProject.jwt;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService  jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token;
        String username;
        if(authHeader == null){
            filterChain.doFilter(request, response);
            return;
            // adamı controller katmanına göndermedik bile
            // direk iznin yok gibi düşün şifreyi boş geçmiş
        }
        token = authHeader.substring(7);
        username = jwtService.getUsernameByToken(token);
        try{
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(userDetails != null && !jwtService.isTokenValid(token)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails,
                                    null, userDetails.getAuthorities());
                    authentication.setDetails(authentication.getDetails());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    filterChain.doFilter(request, response);
                }
            }
        }catch (ExpiredJwtException exception){
            throw new BaseException(new ErrorMessage(MessageType.JWT_TOKEN_EXPIRED,token));
        }catch (Exception exception){
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,exception.getMessage()));
        }
    }
}
