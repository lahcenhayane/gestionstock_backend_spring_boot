package com.project.backend.Services.impl;

import com.project.backend.Dto.ProduitDTO;
import com.project.backend.Entities.CategoriesEntity;
import com.project.backend.Entities.ProduitsEntity;
import com.project.backend.Factory.DtoPage.ProductDtoPage;
import com.project.backend.Repositories.CategorieRepository;
import com.project.backend.Repositories.ProductRepository;
import com.project.backend.Services.IProduitService;
import com.project.backend.Utils.GlobalVariable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService implements IProduitService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategorieRepository categorieRepository;


    @Override
    public ProductDtoPage getProductByCategory(String categorie, int page) {
        Pageable pageable = PageRequest.of(page, GlobalVariable.SIZE);

        Page<ProduitsEntity> produitsEntities = null;
        if (categorie == ""){
            produitsEntities = productRepository.findAll(pageable);
        }else{
            produitsEntities = productRepository.findAllProductByCategory(categorie, pageable);
        }

        List<ProduitDTO> produitDTOs = produitsEntities.stream()
                                                       .map(row->modelMapper.map(row, ProduitDTO.class))
                                                       .collect(Collectors.toList());

        return new ProductDtoPage(produitDTOs, produitsEntities.getTotalPages(), produitsEntities.getTotalElements());
    }

    @Override
    public ProductDtoPage getProductByName(String name, int page) {
        Pageable pageable = PageRequest.of(page, GlobalVariable.SIZE);

        Page<ProduitsEntity> produitsEntities = null;
        if (name == ""){
            produitsEntities = productRepository.findAll(pageable);
        }else{
            produitsEntities = productRepository.findByNomContains(name, pageable);
        }

        List<ProduitDTO> produitDTOs = produitsEntities.stream()
                .map(row->modelMapper.map(row, ProduitDTO.class))
                .collect(Collectors.toList());

        return new ProductDtoPage(produitDTOs, produitsEntities.getTotalPages(), produitsEntities.getTotalElements());
    }
}
