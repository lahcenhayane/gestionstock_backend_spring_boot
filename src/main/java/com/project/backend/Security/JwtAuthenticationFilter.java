package com.project.backend.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Requests.LoginRequest;
import com.project.backend.Services.IUtilisateurService;
import com.project.backend.Utils.Roles;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import io.jsonwebtoken.Jwts;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private IUtilisateurService utilisateurService;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, IUtilisateurService utilisateurService) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginRequest loginDto = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

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
        UtilisateurDTO userDTO = utilisateurService.getUserEmail(email);
        String TOKEN = Jwts.builder()
                            .setSubject(email)
                            .claim("id", userDTO.getId())
                            .claim("role", userDTO.getRole())
                            .setExpiration(new Date(System.currentTimeMillis() + JwtPropertiesConstant.EXPIRATION_DATE_TOKEN))
                            .signWith(SignatureAlgorithm.HS512, JwtPropertiesConstant.SECRET_TOKEN)
                            .compact();


        long id = 0;
        if (userDTO.getRole() == Roles.Admin){
            id = userDTO.getAdmin().getId();
        }
        if (userDTO.getRole() == Roles.Client) {
            id = userDTO.getClient().getId();
        }
        if (userDTO.getRole() == Roles.Employee) {
            id = userDTO.getEmployee().getId();
        }
        
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(new Token_JWT(TOKEN, userDTO.getId(), id, userDTO.getRole()));
        response.getWriter().write(jsonString);
    }
}
