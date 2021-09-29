package com.project.backend.Services;

import com.project.backend.Dto.UtilisateurDTO;

import java.util.List;

public interface IClientService {
    List<UtilisateurDTO> getAllClients(String search);

    List<UtilisateurDTO> getUserGroupByOrder();
}
