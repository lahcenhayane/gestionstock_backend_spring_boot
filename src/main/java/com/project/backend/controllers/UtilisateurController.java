package com.project.backend.controllers;

import com.project.backend.services.impl.IUtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UtilisateurController {

    @Autowired
    private IUtilisateurServiceImpl iUtilisateurService;

    @GetMapping
    public String getUsers(){
        return "Hello Get User";
    }

    @PostMapping
    public String createNewUser(){
        return "Hello Post User";
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
