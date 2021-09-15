package com.project.backend.Services;

import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Requests.UtilisateurRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUtilisateurService extends UserDetailsService {

    UtilisateurDTO createNewUser(UtilisateurDTO utilisateurDTO);


    List<UtilisateurDTO> getAllUser(int page, int size);

    UtilisateurDTO getUser(long id);

    void deleteUser(long id);

    String disabledEnabledUser(long id);

    UtilisateurDTO editUser(long id, UtilisateurDTO utilisateurDTO);

    List<UtilisateurDTO> getUserByEmail(String search, int page);
}
