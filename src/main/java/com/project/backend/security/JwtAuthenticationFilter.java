package com.project.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.entities.UtilisateursEntity;
import com.project.backend.repositories.UtilisateurRepository;
import com.project.backend.requests.LoginRequest;
import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
    private UtilisateurRepository utilisateurRepository;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, UtilisateurRepository utilisateurRepository) {
        this.authenticationManager = authenticationManager;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequest loginRequest = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(), loginRequest.getPassword(), getAutorities(loginRequest)
            );
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Collection<? extends GrantedAuthority> getAutorities(LoginRequest loginRequest) {
        UtilisateursEntity user = utilisateurRepository.findByEmail(loginRequest.getEmail());
        String[] roles = user.getRoles().stream().map(role -> role.getLibelle()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
        return authorities;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();

        String TOKEN = Jwts.builder()
                            .setSubject(userPrincipal.getName())
                            .setExpiration(new Date(System.currentTimeMillis() + JwtPropertiesConstant.DATE_EXPIRATION_TOEKN))
                            .signWith(SignatureAlgorithm.HS512, JwtPropertiesConstant.SECRET_TOKEN)
                            .compact();
        response.addHeader(JwtPropertiesConstant.HEADER_TOKEN, JwtPropertiesConstant.PREFIX_TOKEN+TOKEN);
    }
}
