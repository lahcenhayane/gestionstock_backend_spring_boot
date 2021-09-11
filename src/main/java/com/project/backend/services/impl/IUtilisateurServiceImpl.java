package com.project.backend.services.impl;

import com.project.backend.entities.UtilisateursEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUtilisateurServiceImpl extends UserDetailsService {
    UtilisateursEntity createNewUser(UtilisateursEntity utilisateursEntity);
}
