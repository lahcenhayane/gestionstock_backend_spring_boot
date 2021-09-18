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


    /**
     * Create New User With(Admin Or Client Or Employee).
     * @param utilisateurDTO
     * @return userDTO
     */
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


    /**
     * Get All Users
     * @param page
     * @param size
     * @return listUserDTO
     */
    @Override
    public List<UtilisateurDTO> getAllUser(int page, int size) {
        if (page > 0) page -= 1;
        Page<UtilisateursEntity> listUsers = utilisateurRepository.findBySupprimer(null, PageRequest.of(page, size));
        List<UtilisateurDTO> listUserDTO = listUsers.stream().map(user -> {
            UtilisateurDTO utilisateurDTO = modelMapper.map(user, UtilisateurDTO.class);
            return utilisateurDTO;
        }).collect(Collectors.toList());
        return listUserDTO;
    }


    /**
     * Get User By ID.
     * @param id
     * @return utilisateurDTO
     */
    @Override
    public UtilisateurDTO getUser(long id) {
        UtilisateursEntity userEntity = utilisateurRepository.findById(id).get();
        if (userEntity == null) throw new UtilisateurException("User Not Found.");
        UtilisateurDTO utilisateurDTO = modelMapper.map(userEntity, UtilisateurDTO.class);
        return utilisateurDTO;
    }


    /**
     * Delete User By ID.
     * @param id
     */
    @Override
    public void deleteUser(long id) {
        UtilisateursEntity user = utilisateurRepository.findById(id).get();
        if (user == null) throw new UtilisateurException("User Not Found.");
        utilisateurRepository.delete(user);
    }


    /**
     * Disabled/Enable User By ID.
     * @param id
     * @return msg
     */
    @Override
    public String disabledEnabledUser(long id) {
        UtilisateursEntity utilisateursEntity = utilisateurRepository.findById(id).get();
        if (utilisateursEntity == null) throw new UtilisateurException("User "+id+" Not Found.");
        String msg;
        if (utilisateursEntity.getSupprimer() == null){
            utilisateursEntity.setSupprimer(new Date());
            msg = "Disabled User";
        }else{
            utilisateursEntity.setSupprimer(null);
            msg = "Enabled User";
        }
        utilisateurRepository.save(utilisateursEntity);
        return msg;
    }


    /**
     * Update User
     * @param id
     * @param utilisateurDTO
     * @return utilisateurDTO
     */
    @Override
    public UtilisateurDTO editUser(long id, UtilisateurDTO utilisateurDTO) {
        UtilisateursEntity utilisateursEntity = utilisateurRepository.findById(id).get();
        if (utilisateursEntity == null) throw new UtilisateurException("User "+id+" Not Found");

        utilisateursEntity.setCin(utilisateurDTO.getCin());
        utilisateursEntity.setNom(utilisateurDTO.getNom());
        utilisateursEntity.setPrenom(utilisateurDTO.getPrenom());
        utilisateursEntity.setEmail(utilisateurDTO.getEmail());
        utilisateursEntity.setPassword(bCryptPasswordEncoder.encode(utilisateurDTO.getPassword()));
        utilisateursEntity.setVille(utilisateurDTO.getVille());
        utilisateursEntity.setTel(utilisateurDTO.getTel());
        utilisateursEntity.setDateNaissance(utilisateurDTO.getDateNaissance());
        utilisateursEntity.setRole(utilisateurDTO.getRole());


        if (utilisateursEntity.getRole() == Roles.Admin){
            utilisateursEntity.getAdmin().setDateModification(new Date());
            utilisateursEntity.getAdmin().setUtilisateur(utilisateursEntity);
        }
        if (utilisateursEntity.getRole() == Roles.Client){
            utilisateursEntity.getClient().setAdresse(utilisateurDTO.getClient().getAdresse());
            utilisateursEntity.getClient().setDateModification(new Date());
            utilisateursEntity.getClient().setUtilisateur(utilisateursEntity);
        }
        if (utilisateursEntity.getRole() == Roles.Employee){
            utilisateursEntity.getEmployee().setSalaire(utilisateurDTO.getEmployee().getSalaire());
            utilisateursEntity.getEmployee().setDateModification(new Date());
            utilisateursEntity.getEmployee().setUtilisateur(utilisateursEntity);
        }
        utilisateursEntity.setDateModification(new Date());
        utilisateursEntity.setPassword(bCryptPasswordEncoder.encode(utilisateurDTO.getPassword()));

        UtilisateursEntity utilisateurs = utilisateurRepository.save(utilisateursEntity);

        UtilisateurDTO userDTO = modelMapper.map(utilisateurs, UtilisateurDTO.class);
        return userDTO;
    }


    /**
     * Get Users By Email
     * @param search
     * @param page
     * @return utilisateursDTO
     */
    @Override
    public List<UtilisateurDTO> getUserByEmail(String search, int page) {
        String s = search.trim();
        if (s == null) throw new UtilisateurException("Input Is Empty.");
        int size = 10;

        Page<UtilisateursEntity> utilisateursEntity = utilisateurRepository.findByEmailContains(s, PageRequest.of(page, size));
        if (utilisateursEntity.getSize() == 0) throw new UtilisateurException("User Not Found.");

        List<UtilisateurDTO> utilisateursDTO = utilisateursEntity.stream().map(user -> {
            UtilisateurDTO dto = modelMapper.map(user, UtilisateurDTO.class);
            return dto;
        }).collect(Collectors.toList());
        return utilisateursDTO;
    }

    @Override
    public UtilisateurDTO getUserEmail(String email) {
        UtilisateursEntity utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) throw new UtilisateurException("User Not Found.");
        return modelMapper.map(utilisateur, UtilisateurDTO.class);
    }
}
