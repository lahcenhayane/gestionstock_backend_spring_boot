package com.project.backend.Services;

import com.project.backend.Dto.ProduitDTO;
import com.project.backend.Factory.DtoPage.ProductDtoPage;
import org.springframework.data.domain.Pageable;

public interface IProduitService {

    

    ProductDtoPage getProductByName(String name, int page);

    ProductDtoPage getProductByCategory(String categorie, int page);

    ProduitDTO createNewProduct(ProduitDTO produitDTO);

    void deleteProduct(long id);


    ProduitDTO editProduct(long id, ProduitDTO produitDTO);

    long getCountProducts();
}
