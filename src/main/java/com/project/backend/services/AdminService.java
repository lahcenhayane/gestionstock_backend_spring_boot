package com.project.backend.services;

import com.project.backend.entities.AdminsEntity;
import com.project.backend.entities.RolesEntity;
import com.project.backend.entities.UtilisateursEntity;
import com.project.backend.repositories.AdminRepository;
import com.project.backend.repositories.RolesRepository;
import com.project.backend.repositories.UtilisateurRepository;
import com.project.backend.services.impl.IAdminServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService implements IAdminServiceImpl {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AdminsEntity createAdmin(AdminsEntity adminsEntity) {
        //Check User using Email and CIN.
        UtilisateursEntity user = utilisateurRepository.findByEmailAndCin(adminsEntity.getUtilisateur().getEmail(), adminsEntity.getUtilisateur().getCin());
        if (user != null) throw new RuntimeException("This User Already Exist.");

        //Switch Password to BCryptPasswordEncoder.
        adminsEntity.getUtilisateur().setPassword(bCryptPasswordEncoder.encode(adminsEntity.getUtilisateur().getPassword()));

        //Add Roles in User.
        Set<RolesEntity> roles = new HashSet<>();
        roles.add(rolesRepository.findByLibelle("Admin"));
        adminsEntity.getUtilisateur().setRoles(roles);

        //Add Admin in User.
        adminsEntity.getUtilisateur().setAdmin(adminsEntity);

        //Save Admin
        return adminRepository.save(adminsEntity);
    }
}
