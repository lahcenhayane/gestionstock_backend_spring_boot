package com.project.backend.Services;

import com.project.backend.Dto.CategorieDTO;
import com.project.backend.Entities.CategoriesEntity;
import com.project.backend.Factory.DtoPage.CategorieDtoPage;

import java.util.List;

public interface ICategoryService {

    List<CategorieDTO> getCategoriesByName(String name);

    long getCountCategory();

    CategorieDTO createNewCategory(CategorieDTO categorieDTO);

    void deleteCategory(long id);

    CategorieDTO editCategory(long id, CategorieDTO categorieDTO);


}
