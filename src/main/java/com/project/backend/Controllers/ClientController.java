package com.project.backend.Controllers;

import com.project.backend.Dto.ClientDTO;
import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Responses.UtilisateurResponse;
import com.project.backend.Services.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<UtilisateurResponse>> getAllClient(@RequestParam(value = "search", defaultValue = "") String search){
        List<UtilisateurDTO> utilisateurDTOs = clientService.getAllClients(search);
        List<UtilisateurResponse> list = utilisateurDTOs.stream().map(row->modelMapper.map(row, UtilisateurResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<UtilisateurResponse>> getUserGroupByOrder(){
        List<UtilisateurDTO> utilisateurDTOList = clientService.getUserGroupByOrder();
        List<UtilisateurResponse> list = utilisateurDTOList.stream().map(row->modelMapper.map(row, UtilisateurResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
