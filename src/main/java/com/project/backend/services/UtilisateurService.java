package com.project.backend.services;

import com.project.backend.entities.RolesEntity;
import com.project.backend.entities.UtilisateursEntity;
import com.project.backend.repositories.RolesRepository;
import com.project.backend.repositories.UtilisateurRepository;
import com.project.backend.services.impl.IUtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UtilisateurService implements IUtilisateurServiceImpl {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateursEntity user = utilisateurRepository.findByEmail(email);
        return new User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(UtilisateursEntity user) {
        String[] roles = user.getRoles().stream().map(role -> role.getLibelle()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
        return authorities;
    }

    @Override
    public UtilisateursEntity createNewUser(UtilisateursEntity utilisateursEntity) {
        //Check User if exist or not.
        UtilisateursEntity user = utilisateurRepository.findByEmailAndCin(utilisateursEntity.getEmail(), utilisateursEntity.getCin());
        if (user != null) throw new RuntimeException("This Email Or Cin Already Exist.");

        //Switch Password to BCryptPasswordEncoder.
        utilisateursEntity.setPassword(bCryptPasswordEncoder.encode(utilisateursEntity.getPassword()));

        //Add Roles To User
        RolesEntity role = rolesRepository.findByLibelle("Admin");
//        Set<RolesEntity> roles = new HashSet<>();
//        roles.add(role);
        utilisateursEntity.getRoles().add(role);

        //Add User to Admin.
//        utilisateursEntity.setAdmin(utilisateursEntity.getAdmin());
        return utilisateurRepository.save(utilisateursEntity);
    }
}
