package com.project.backend.Controllers;


import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Dto.UtilisateurDto;
import com.project.backend.Services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UtilisateurController {

    @Autowired
    private IUtilisateurService utilisateurService;

    @GetMapping
    public String getUsers(){
        return "Hello Get User";
    }

    @PostMapping
    public ResponseEntity<UtilisateurDto> createNewUser(@RequestBody UtilisateurDto utilisateurDto){
        return new ResponseEntity<>(utilisateurService.createNewUser(utilisateurDto), HttpStatus.CREATED);
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
