package com.project.backend.Services;

import com.project.backend.Dto.UtilisateurDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUtilisateurService extends UserDetailsService {

    UtilisateurDto createNewUser(UtilisateurDto utilisateurDto);
}
