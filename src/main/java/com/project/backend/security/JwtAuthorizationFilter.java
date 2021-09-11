package com.project.backend.security;

import com.project.backend.entities.UtilisateursEntity;
import com.project.backend.repositories.UtilisateurRepository;
import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String TOKEN = request.getHeader(JwtPropertiesConstant.HEADER_TOKEN);
        if (TOKEN == null || !TOKEN.startsWith(JwtPropertiesConstant.PREFIX_TOKEN)){
            chain.doFilter(request, response);
            return;
        }
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String TOKEN = request.getHeader(JwtPropertiesConstant.HEADER_TOKEN);
        if (TOKEN != null){
            TOKEN = TOKEN.replace(JwtPropertiesConstant.PREFIX_TOKEN, "");
            String email = Jwts.parser()
                               .setSigningKey(JwtPropertiesConstant.SECRET_TOKEN)
                               .parseClaimsJwt(TOKEN)
                               .getBody()
                               .getSubject();
            if (email != null){
                UtilisateursEntity user = utilisateurRepository.findByEmail(email);
                return new UsernamePasswordAuthenticationToken(user.getEmail(), null, getAutorities(user));
            }
            return null;
        }
        return null;
    }
    private Collection<? extends GrantedAuthority> getAutorities(UtilisateursEntity user) {
        String[] roles = user.getRoles().stream().map(role -> role.getLibelle()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
        return authorities;
    }
}
