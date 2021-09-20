package com.project.backend.Controllers;

import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Factory.DtoPage.UtilisateurDtoPage;
import com.project.backend.Factory.Page;
import com.project.backend.Factory.PageFactory;
import com.project.backend.Requests.UtilisateurRequest;
import com.project.backend.Responses.UtilisateurResponse;
import com.project.backend.Services.IUtilisateurService;
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
    private IUtilisateurService utilisateurService;

//    @GetMapping
//    public ResponseEntity<Page<UtilisateurDtoPage>> getAllUser(){
//        Page<UtilisateurDtoPage> page = PageFactory.getPage("UtilisateurDtoPage");
//        return new ResponseEntity<>(page, HttpStatus.OK);
//    }

    /**
     * Create New User.
     * @param utilisateurRequest
     * @return utilisateurResponse
     */
    @PostMapping
    public ResponseEntity<UtilisateurResponse> createNewUser(@RequestBody UtilisateurRequest utilisateurRequest){
        UtilisateurDTO utilisateurDTO = modelMapper.map(utilisateurRequest, UtilisateurDTO.class);
        UtilisateurDTO userDTO = utilisateurService.createNewUser(utilisateurDTO);
        UtilisateurResponse utilisateurResponse = modelMapper.map(userDTO, UtilisateurResponse.class);
        return new ResponseEntity<>(utilisateurResponse, HttpStatus.CREATED);
    }
}
