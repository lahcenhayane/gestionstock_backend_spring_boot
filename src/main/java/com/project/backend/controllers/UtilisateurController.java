package com.project.backend.controllers;

import com.project.backend.entities.UtilisateursEntity;
import com.project.backend.repositories.UtilisateurRepository;
import com.project.backend.requests.UtilisateurRequest;
import com.project.backend.responses.UtilisateurResponse;
import com.project.backend.services.impl.IUtilisateurServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UtilisateurController {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IUtilisateurServiceImpl utilisateurService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public String getUsers(){
        return "Hello Get User";
    }

    @PostMapping
    public ResponseEntity<UtilisateurRequest> createNewUser(@RequestBody UtilisateurRequest utilisateurRequest){
        //Switch @utilisateurRequest to UtilisateursEntity.
//        UtilisateursEntity utilisateursEntity = modelMapper.map(utilisateurRequest, UtilisateursEntity.class);
//
//        //Pass Parameter @utilisateursEntity to function @createNewUser and return object utilisateur.
//        UtilisateursEntity utilisateur = utilisateurService.createNewUser(utilisateursEntity);
//
//        //Switch @utilisateur to UtilisateurResponse.
//        UtilisateurResponse utilisateurResponse = modelMapper.map(utilisateur, UtilisateurResponse.class);
        return new ResponseEntity<>(utilisateurRequest ,HttpStatus.CREATED);
    }

    @PutMapping
    public String editUser(){
        return "Hello Put User";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Hello Delete User";
    }

}
