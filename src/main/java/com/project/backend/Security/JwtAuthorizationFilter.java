package com.project.backend.Security;

import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Repositories.UtilisateurRepository;
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
        UsernamePasswordAuthenticationToken authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthentication(HttpServletRequest request) {
        String TOKEN = request.getHeader(JwtPropertiesConstant.HEADER_TOKEN);
        if (TOKEN != null){
            TOKEN = TOKEN.replace(JwtPropertiesConstant.PREFIX_TOKEN, "");
            String email = Jwts.parser()
                               .setSigningKey(JwtPropertiesConstant.SECRET_TOKEN)
                               .parseClaimsJws(TOKEN)
                               .getBody()
                               .getSubject();
            if (email != null){
                return new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
//    private Collection<? extends GrantedAuthority> getAutorities(UtilisateursEntity user) {
//        String[] roles = user.getRoles().stream().map(role -> role.getLibelle()).toArray(String[]::new);
//        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
//        return authorities;
//    }
}
