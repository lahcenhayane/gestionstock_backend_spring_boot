package com.project.backend.Services.impl;

import com.project.backend.Dto.AdminDTO;
import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Email.Email;
import com.project.backend.Email.Services.ISendEmailService;
import com.project.backend.Email.Services.Impl.SendEmailServiceImpl;
import com.project.backend.Entities.*;
import com.project.backend.Exceptions.UtilisateurException;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Requests.UtilisateurRequest;
import com.project.backend.Services.IUtilisateurService;
import com.project.backend.Utils.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements IUtilisateurService {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ISendEmailService sendEmailService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateursEntity user = utilisateurRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("This User Not Found.");

        Boolean enableUser = true;
        if (user.getSupprimer() != null) enableUser = false;

        return new User(user.getEmail(), user.getPassword(),enableUser ,true, true ,true, new ArrayList<>());
    }


    @Override
    public UtilisateurDTO getUserEmail(String email) {
        UtilisateursEntity utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) throw new UtilisateurException("User Not Found.");
        return modelMapper.map(utilisateur, UtilisateurDTO.class);
    }


    /**
     * Create New User With(Admin Or Client Or Employee).
     * @param utilisateurDTO
     * @return userDTO
     */
    @Transactional
    @Override
    public UtilisateurDTO createNewUser(UtilisateurDTO utilisateurDTO) {
        UtilisateursEntity utilisateursEntity = utilisateurRepository.findByEmailAndCin(utilisateurDTO.getEmail(), utilisateurDTO.getCin());//Check User is exist or not.
        if (utilisateursEntity != null) throw new UtilisateurException("User Already Exist.");//Exception User "User Already exist".

        if (utilisateurDTO.getRole() == Roles.Employee)//Check If Role Equals Employee.
            utilisateurDTO.getEmployee().setUtilisateur(utilisateurDTO);//Add ID User To Employee.
        if (utilisateurDTO.getRole() == Roles.Client)//Check If Role Equals Client.
            utilisateurDTO.getClient().setUtilisateur(utilisateurDTO);//Add ID User To Client.
        if (utilisateurDTO.getRole() == Roles.Admin){//Check If Role Equals Admin.
            AdminDTO adminDTO = new AdminDTO();
            utilisateurDTO.setAdmin(adminDTO);//Add ID Admin to User.
            adminDTO.setUtilisateur(utilisateurDTO);//Add ID User to Admin.
        }

        UtilisateursEntity userEntity = modelMapper.map(utilisateurDTO, UtilisateursEntity.class);//Map UserDTO To UserEntity.
        userEntity.setPassword(bCryptPasswordEncoder.encode(utilisateurDTO.getPassword()));//BCrypt Password.

        UtilisateursEntity saveUser = utilisateurRepository.save(userEntity);//Save User In Data Base.

        UtilisateurDTO userDTO = modelMapper.map(saveUser, UtilisateurDTO.class);//Map UserEntity To UserDTO.

        // TODO: Send Username and Password.
        if (saveUser != null){
            String SubjectMail = "Your Account Username And Password.";
            String TextMail = "Username : "+saveUser.getEmail()+", Paasword :"+utilisateurDTO.getPassword();
            Email email = new Email(saveUser.getEmail(), SubjectMail,TextMail);

            sendEmailService.SendMailUsernamePassword(email);
        }
        return userDTO;//Return UserDTO.
    }
}
