package com.project.backend.Controllers;

import com.project.backend.Dto.ProduitDTO;
import com.project.backend.Factory.DtoPage.CategorieDtoPage;
import com.project.backend.Factory.DtoPage.ProductDtoPage;
import com.project.backend.Factory.Page;
import com.project.backend.Factory.PageFactory;
import com.project.backend.Factory.PageStateEnum;
import com.project.backend.Factory.ResponsePage.CategorieResponsePage;
import com.project.backend.Factory.ResponsePage.ProductResponsePage;
import com.project.backend.Responses.CategorieResponse;
import com.project.backend.Responses.ProduitResponse;
import com.project.backend.Services.ICategoryService;
import com.project.backend.Services.IProduitService;
import com.project.backend.Utils.GlobalVariable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/products")
public class ProduitController {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IProduitService produitService;
    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<Page> getAllProductByCategory(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "categorie", defaultValue = "") String categorie,
                                                        @RequestParam(value = "name", defaultValue = "") String name){

        ProductDtoPage productDtoPage = produitService.getProductByCategory(categorie, page);
        ProductResponsePage productResponsePage =
                new ProductResponsePage(MapDtoToResponse(productDtoPage.getList()), productDtoPage.getTotalPage(), productDtoPage.getTotalRow());

        return new ResponseEntity<>(PageFactory.getPage(PageStateEnum.ProductResponsePage, productResponsePage), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page> getAllProductByName(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "name", defaultValue = "") String name){
        ProductDtoPage productDtoPage = produitService.getProductByName(name, page);
        ProductResponsePage productResponsePage =
                new ProductResponsePage(MapDtoToResponse(productDtoPage.getList()), productDtoPage.getTotalPage(), productDtoPage.getTotalRow());
        return new ResponseEntity<>(PageFactory.getPage(PageStateEnum.ProductResponsePage, productResponsePage), HttpStatus.OK);
    }

    List<ProduitResponse> MapDtoToResponse(List<ProduitDTO> list){
        return list.stream().map(row->modelMapper.map(row, ProduitResponse.class)).collect(Collectors.toList());
    }

}
