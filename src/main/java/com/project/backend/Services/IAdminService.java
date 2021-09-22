package com.project.backend.Services;


import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Factory.DtoPage.UtilisateurDtoPage;
import com.project.backend.Utils.Roles;

import java.util.List;

public interface IAdminService {


    UtilisateurDtoPage getAllUser(int page, Roles role);

    UtilisateurDtoPage findUsersByEmail(String email, int page);

    void deleteUserById(long id);
}
