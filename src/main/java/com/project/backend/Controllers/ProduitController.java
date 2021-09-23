package com.project.backend.Controllers;

import com.project.backend.Responses.ProduitResponse;
import com.project.backend.Services.IProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/products")
public class ProduitController {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IProduitService produitService;

    @GetMapping
    public ResponseEntity<ProduitResponse> getAllProduct(){

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
