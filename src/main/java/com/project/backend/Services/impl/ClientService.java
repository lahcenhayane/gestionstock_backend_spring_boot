package com.project.backend.Services.impl;

import com.project.backend.Dto.ClientDTO;
import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Entities.ClientsEntity;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Repositories.ClientRepository;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Responses.UtilisateurResponse;
import com.project.backend.Services.IClientService;
import com.project.backend.Utils.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<UtilisateurDTO> getAllClients(String search) {
        List<UtilisateursEntity> utilisateursEntity = utilisateurRepository.findByRoleAndCinContains(Roles.Client, search);
        List<UtilisateurDTO> list = utilisateursEntity.stream().map(row->modelMapper.map(row, UtilisateurDTO.class)).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<UtilisateurDTO> getUserGroupByOrder() {
        List<UtilisateursEntity> list = utilisateurRepository.getUserGroupByOrder();
        return list.stream().map(row->modelMapper.map(row, UtilisateurDTO.class)).collect(Collectors.toList());

    }

    @Override
    public long getCountCmdByClient(long id) {
        long countClient = clientRepository.findById(id).get().getCommandes().stream().count();
        return countClient;
    }
}
