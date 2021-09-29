package com.project.backend.Controllers;

import com.project.backend.Dto.CommandeProduitDTO;
import com.project.backend.Requests.CommandeProduitRequest;
import com.project.backend.Responses.CommandeProduitResponse;
import com.project.backend.Services.ICommandeProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cmd")
public class CommandeProduitController {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ICommandeProduitService commandeProduitService;

    @GetMapping
    public String GetAllCmd(){
        return "Get Get All Cmd";
    }

    @PostMapping
    public ResponseEntity<CommandeProduitResponse> createNewOrder(@RequestBody CommandeProduitRequest request){
        CommandeProduitDTO commandeProduitDTO = modelMapper.map(request, CommandeProduitDTO.class);
        CommandeProduitDTO produitServiceNewOrders = commandeProduitService.createNewOrders(commandeProduitDTO);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
