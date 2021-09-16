package com.project.backend.Services.impl;

import com.project.backend.Dto.CategorieDTO;
import com.project.backend.Entities.CategoriesEntity;
import com.project.backend.Exceptions.CategorieException;
import com.project.backend.Repositories.CategorieRepository;
import com.project.backend.Services.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CategorieRepository categorieRepository;


    /**
     * Get All Categories
     * @param page
     * @return categorieDTOList
     */
    @Override
    public List<CategorieDTO> getAllCategories(int page) {
        if (page > 0) page--;
        int size = 10;
        Page<CategoriesEntity> categories = categorieRepository.findAll(PageRequest.of(page, size));
        List<CategorieDTO> categorieDTOList = categories.stream().map(cat -> modelMapper.map(cat, CategorieDTO.class)).collect(Collectors.toList());
        return categorieDTOList;
    }


    /**
     * Create New Category.
     * @param categorieDTO
     * @return dto
     */
    @Override
    public CategorieDTO createNewCategory(CategorieDTO categorieDTO) {
        CategoriesEntity categoriesEntity = categorieRepository.getByLabelle(categorieDTO.getLabelle());
        if (categoriesEntity != null) throw new CategorieException("Category "+categorieDTO.getLabelle()+" Already Exist.");

        CategoriesEntity category = modelMapper.map(categorieDTO, CategoriesEntity.class);

        CategoriesEntity saveCategory = categorieRepository.save(category);

        CategorieDTO dto = modelMapper.map(saveCategory, CategorieDTO.class);
        return dto;
    }


    /**
     * Get Category By ID.
     * @param id
     * @return dto
     */
    @Override
    public CategorieDTO getCategoryById(long id) {
        CategoriesEntity categoriesEntity = findCategoryById(id);
        CategorieDTO dto = modelMapper.map(categoriesEntity, CategorieDTO.class);
        return dto;
    }


    /**
     * Edit Category
     * @param id
     * @param categorieDTO
     * @return dto
     */
    @Override
    public CategorieDTO editCategory(long id, CategorieDTO categorieDTO) {
        CategoriesEntity categoriesEntity = findCategoryById(id);

        categoriesEntity.setLabelle(categorieDTO.getLabelle());
        categoriesEntity.setDateModification(new Date());

        CategoriesEntity editCategory = categorieRepository.save(categoriesEntity);

        CategorieDTO dto = modelMapper.map(editCategory, CategorieDTO.class);
        return dto;
    }


    /**
     * Delete Category;
     * @param id
     */
    @Override
    public void deleteCategory(long id) {
        CategoriesEntity categoriesEntity = findCategoryById(id);
        categorieRepository.delete(categoriesEntity);
    }

    /**
     * Find Categories By Lebille
     * @param search
     * @param page
     * @return categorieDtoList
     */
    @Override
    public List<CategorieDTO> findCategoryByLebille(String search, int page) {
        if (page > 0) page--;
        int size = 10;
        Page<CategoriesEntity> categoriesList = categorieRepository.findByLabelleContains(search, PageRequest.of(page, size));
        List<CategorieDTO> categorieDtoList = categoriesList
                .stream()
                .map(row -> modelMapper.map(row, CategorieDTO.class))
                .collect(Collectors.toList());
        return categorieDtoList;
    }


    /**
     * Find Category By ID.
     * @param id
     * @return categoriesEntity
     */
    private CategoriesEntity findCategoryById(long id){
        CategoriesEntity categoriesEntity = categorieRepository.getById(id);
        if (categoriesEntity == null)throw new CategorieException("Category Not Found");
        return categoriesEntity;
    }
}
