package com.project.backend.Services.impl;

import com.project.backend.Dto.UtilisateurDto;
import com.project.backend.Entities.*;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Services.IUtilisateurService;
import com.project.backend.Utils.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UtilisateurService implements IUtilisateurService {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateursEntity user = utilisateurRepository.findByEmail(email);
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }


    /**
     * Create New User(Admin or Client or Employe).
     * @param utilisateurDto
     * @return dto
     */
    @Override
    public UtilisateurDto createNewUser(UtilisateurDto utilisateurDto) {
        //Check if User Exist or not.
        UtilisateursEntity user = utilisateurRepository.findByEmailAndCin(utilisateurDto.getEmail(), utilisateurDto.getCin());
        if (user != null) throw new RuntimeException("This Email or CIN Already Exist.");

        //Map UtilisateurDto (utilisateurDto) to UtilisateursEntity (user).
        UtilisateursEntity utilisateursEntity = modelMapper.map(utilisateurDto, UtilisateursEntity.class);
        //Bcrypt Password.
        utilisateursEntity.setPassword(bCryptPasswordEncoder.encode(utilisateurDto.getPassword()));
        //Add Admin to User if role equals Admin.
        if (utilisateursEntity.getRole() == Roles.Admin){
            AdminsEntity adminsEntity = new AdminsEntity();
            adminsEntity.setUtilisateur(utilisateursEntity);
            utilisateursEntity.setAdmin(adminsEntity);
        }
        //Add Client to User if role equals Client.
        if (utilisateursEntity.getRole() == Roles.Client){
            ClientsEntity clientsEntity = new ClientsEntity();
            clientsEntity.setAdresse(utilisateurDto.getClient().getAdresse());
            clientsEntity.setUtilisateur(utilisateursEntity);
            utilisateursEntity.setClient(clientsEntity);
        }
        //Add Employe to User if role equals Employe.
        if (utilisateursEntity.getRole() == Roles.Employee){
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setSalaire(utilisateurDto.getEmployee().getSalaire());
            employeesEntity.setUtilisateur(utilisateursEntity);
            utilisateursEntity.setEmployee(employeesEntity);
        }

        //Save User in database.
        UtilisateursEntity saveUser = utilisateurRepository.save(utilisateursEntity);

        //Map UtilisateursEntity (saveUser) to UtilisateurDto (dto).
        UtilisateurDto dto = modelMapper.map(saveUser, UtilisateurDto.class);
        //Empty password
        dto.setPassword("");
        return dto;
    }

}
