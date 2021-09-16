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


    /**
     * Get All Gategories.
     * @param page
     * @return response
     */
    @GetMapping
    public ResponseEntity<List<CategorieResponse>> getAllCategories(@RequestParam(value = "page", defaultValue = "0") int page){
        List<CategorieDTO> listCategories = categorieService.getAllCategories(page);
        List<CategorieResponse> response = listCategories
                                                     .stream()
                                                     .map(categorie -> modelMapper.map(categorie, CategorieResponse.class))
                                                     .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Find Categories By Lebille.
     * @param search
     * @return categorieResponseList
     */
    @GetMapping(value = "/search")
    public ResponseEntity<List<CategorieResponse>> findCategoryByLebille(@RequestParam(value = "search") String search,
                                                                         @RequestParam(value = "page", defaultValue = "0") int page){
        List<CategorieDTO> categorieDTOList = categorieService.findCategoryByLebille(search, page);
        List<CategorieResponse> categorieResponseList = categorieDTOList
                                                        .stream()
                                                        .map(row -> modelMapper.map(row, CategorieResponse.class))
                                                        .collect(Collectors.toList());
        return new ResponseEntity<>(categorieResponseList, HttpStatus.OK);
    }

    /**
     * Get Category By ID.
     * @param id
     * @return response
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategorieResponse> getCategoryById(@PathVariable long id){
        CategorieDTO categorieDTO = categorieService.getCategoryById(id);
        CategorieResponse response = modelMapper.map(categorieDTO, CategorieResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Create New Category.
     * @param request
     * @return response
     */
    @PostMapping
    public ResponseEntity<CategorieResponse> createNewCategory(@RequestBody CategorieRequest request){
        CategorieDTO categorieDTO = modelMapper.map(request, CategorieDTO.class);
        CategorieDTO dto = categorieService.createNewCategory(categorieDTO);
        CategorieResponse response = modelMapper.map(dto, CategorieResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Edit Category
     * @param id
     * @param request
     * @return response
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<CategorieResponse> editCategory(@PathVariable long id, @RequestBody CategorieRequest request){
        CategorieDTO categorieDTO = modelMapper.map(request, CategorieDTO.class);
        CategorieDTO dto = categorieService.editCategory(id, categorieDTO);
        CategorieResponse response = modelMapper.map(dto, CategorieResponse.class);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Delete Category.
     * @param id
     * @return Delete
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id){
        categorieService.deleteCategory(id);
        return new ResponseEntity<>("Delete.", HttpStatus.NO_CONTENT);
    }
}
