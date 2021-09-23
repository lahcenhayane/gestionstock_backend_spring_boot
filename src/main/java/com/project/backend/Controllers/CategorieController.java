package com.project.backend.Controllers;

import com.project.backend.Dto.CategorieDTO;
import com.project.backend.Requests.CategorieRequest;
import com.project.backend.Responses.CategorieResponse;
import com.project.backend.Services.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/categories")
public class CategorieController {

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ICategoryService categorieService;



}
