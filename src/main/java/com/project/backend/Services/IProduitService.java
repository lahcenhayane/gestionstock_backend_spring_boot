package com.project.backend.Services;

import com.project.backend.Factory.DtoPage.ProductDtoPage;
import org.springframework.data.domain.Pageable;

public interface IProduitService {

    

    ProductDtoPage getProductByName(String name, int page);

    ProductDtoPage getProductByCategory(String categorie, int page);
}
