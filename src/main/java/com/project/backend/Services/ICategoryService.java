package com.project.backend.Services;

import com.project.backend.Dto.CategorieDTO;
import com.project.backend.Entities.CategoriesEntity;

import java.util.List;

public interface ICategoryService {
    List<CategorieDTO> getAllCategories(int page);

    CategorieDTO createNewCategory(CategorieDTO categorieDTO);

    CategorieDTO getCategoryById(long id);

    CategorieDTO editCategory(long id, CategorieDTO categorieDTO);

    void deleteCategory(long id);

    List<CategorieDTO> findCategoryByLebille(String search, int page);
}
