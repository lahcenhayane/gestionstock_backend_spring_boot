package com.project.backend.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Dto.LoginDto;
import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginDto loginDto = new ObjectMapper().readValue(request.getInputStream(), LoginDto.class);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(), loginDto.getPassword(), new ArrayList<>()
            );
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String email = ((User) authResult.getPrincipal()).getUsername();

        String TOKEN = Jwts.builder()
                            .setSubject(email)
                            .setExpiration(new Date(System.currentTimeMillis() + JwtPropertiesConstant.DATE_EXPIRATION_TOEKN))
                            .signWith(SignatureAlgorithm.HS512, JwtPropertiesConstant.SECRET_TOKEN)
                            .compact();
        response.addHeader(JwtPropertiesConstant.HEADER_TOKEN, JwtPropertiesConstant.PREFIX_TOKEN+TOKEN);
    }
}
