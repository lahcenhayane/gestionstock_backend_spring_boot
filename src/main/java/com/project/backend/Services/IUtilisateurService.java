package com.project.backend.Services;

import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Requests.UtilisateurRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUtilisateurService extends UserDetailsService {

    UtilisateurDTO getUserEmail(String email);

    UtilisateurDTO createNewUser(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO editUserById(long id, UtilisateurRequest request);
}
