package com.project.backend.Controllers;


import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Exceptions.UtilisateurException;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Requests.UtilisateurRequest;
import com.project.backend.Responses.UtilisateurResponse;
import com.project.backend.Services.IUtilisateurService;
import org.hibernate.collection.internal.PersistentList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
public class UtilisateurController {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IUtilisateurService utilisateurService;


    @GetMapping(path = "/{search}")
    public ResponseEntity<List<UtilisateurResponse>> getUserByCinOrEmail(@PathVariable String search, @RequestParam(value = "page") int page){
        List<UtilisateurDTO> utilisateurDTO = utilisateurService.getUserByCinOrEmail(search, page);

        List<UtilisateurResponse> listUsers =utilisateurDTO
                .stream()
                .map(user -> modelMapper.map(user, UtilisateurResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }


    /**
     * Get User By ID.
     * @param id
     * @return utilisateurResponse
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<UtilisateurResponse> getUser(@PathVariable long id){
        UtilisateurDTO utilisateurDTO = utilisateurService.getUser(id);
        UtilisateurResponse utilisateurResponse = modelMapper.map(utilisateurDTO, UtilisateurResponse.class);
        return new ResponseEntity<>(utilisateurResponse, HttpStatus.OK);
    }


    /**
     * Get All Users.
     * @param size
     * @param page
     * @return listUtilisateurResponse
     */
    @GetMapping
    public ResponseEntity<List<UtilisateurResponse>> getUsers(@RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "page", defaultValue = "0") int page){
        List<UtilisateurDTO> listUsersDTO = utilisateurService.getAllUser(page, size);
        List<UtilisateurResponse> listUtilisateurResponse = listUsersDTO.stream().map(user -> {
            UtilisateurResponse utilisateurResponse = modelMapper.map(user, UtilisateurResponse.class);
            return  utilisateurResponse;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(listUtilisateurResponse, HttpStatus.OK);
    }


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


    /**
     * Disabled User By ID.
     * @param id
     * @return
     */
    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> disabledUser(@PathVariable long id){
        String msg = utilisateurService.disabledEnabledUser(id);
        return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
    }


    /**
     * Delete User By ID.
     * @param id
     * @return
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        utilisateurService.deleteUser(id);
        return new ResponseEntity<>("Delete User", HttpStatus.NO_CONTENT);
    }


    /**
     * Edit User By ID.
     * @param id
     * @param utilisateurRequest
     * @return
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<UtilisateursEntity> editUser(@PathVariable long id, @RequestBody UtilisateurRequest utilisateurRequest){
        UtilisateurDTO utilisateurDTO = utilisateurService.editUser(id, utilisateurRequest);
        UtilisateursEntity utilisateursEntity = modelMapper.map(utilisateurDTO, UtilisateursEntity.class);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

}
