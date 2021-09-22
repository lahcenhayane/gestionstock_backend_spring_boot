package com.project.backend.Services.impl;


import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Exceptions.UtilisateurException;
import com.project.backend.Factory.DtoPage.UtilisateurDtoPage;
import com.project.backend.Factory.PageFactory;
import com.project.backend.Repositories.AdminRepository;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Services.IAdminService;
import com.project.backend.Utils.GlobalVariable;
import com.project.backend.Utils.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    /**
     * Get All Users By Role
     * @param page
     * @param role
     * @return
     */
    @Override
    public UtilisateurDtoPage getAllUser(int page, Roles role) {
        if (page > 0) page--;
        Page<UtilisateursEntity> utilisateursEntities;
        if (role == null){
            utilisateursEntities = utilisateurRepository.findAll(PageRequest.of(page, GlobalVariable.SIZE));
        }else{
            utilisateursEntities = utilisateurRepository.findByRole(PageRequest.of(page, GlobalVariable.SIZE), role);
        }

        List<UtilisateurDTO> utilisateurDTOList = utilisateursEntities.stream().map(row-> modelMapper.map(row, UtilisateurDTO.class)).collect(Collectors.toList());
        return new UtilisateurDtoPage(utilisateurDTOList, utilisateursEntities.getTotalPages(), utilisateursEntities.getTotalElements());
    }


    /**
     * Find Users By Email.
     * @param email
     * @param page
     * @return
     */
    @Override
    public UtilisateurDtoPage findUsersByEmail(String email, int page) {
        if (page > 0) page--;
        Page<UtilisateursEntity> utilisateursEntity = utilisateurRepository.findByEmailContains(email, PageRequest.of(page, GlobalVariable.SIZE));
        List<UtilisateurDTO> utilisateurDTOList = utilisateursEntity.stream().map(row->modelMapper.map(row, UtilisateurDTO.class)).collect(Collectors.toList());

        return new UtilisateurDtoPage(utilisateurDTOList, utilisateursEntity.getTotalPages(), utilisateursEntity.getTotalElements());
    }


    /**
     * Delete User By Id
     * @param id
     */
    @Override
    public void deleteUserById(long id) {
        UtilisateursEntity utilisateursEntity = utilisateurRepository.findById(id).get();
        if (utilisateursEntity == null) throw new UtilisateurException("User Not Found.");
        utilisateurRepository.delete(utilisateursEntity);
    }

}
