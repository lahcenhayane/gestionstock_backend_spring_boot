package com.project.backend.Services.impl;

import com.project.backend.Repositories.ProductRepository;
import com.project.backend.Services.IProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService implements IProduitService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProductRepository productRepository;




}
