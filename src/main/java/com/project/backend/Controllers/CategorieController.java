package com.project.backend.Controllers;

import com.project.backend.Dto.CategorieDTO;
import com.project.backend.Entities.CategoriesEntity;
import com.project.backend.Factory.Page;
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


    @GetMapping
    public ResponseEntity<List<CategorieResponse>> getCategoryByName(@RequestParam(value = "name", defaultValue = "") String name){
        List<CategorieDTO> categorieDTOs = categorieService.getCategoriesByName(name);
        List<CategorieResponse> categorieResponseList =
                categorieDTOs.stream()
                             .map(row->modelMapper.map(row, CategorieResponse.class))
                             .collect(Collectors.toList());
        return new ResponseEntity<>(categorieResponseList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CategorieResponse> createNewCategory(@RequestBody CategorieRequest request){
        CategorieDTO categorieDTO = modelMapper.map(request, CategorieDTO.class);
        CategorieDTO category = categorieService.createNewCategory(categorieDTO);
        CategorieResponse response = modelMapper.map(category, CategorieResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id){
        categorieService.deleteCategory(id);
        return new ResponseEntity<>("Delete Category", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategorieResponse> editCategory(@PathVariable long id, @RequestBody CategorieRequest request){
        CategorieDTO categorieDTO = modelMapper.map(request, CategorieDTO.class);
        CategorieDTO editCategory = categorieService.editCategory(id, categorieDTO);
        CategorieResponse response = modelMapper.map(editCategory, CategorieResponse.class);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }



    @GetMapping("/count")
    public long getCountCategory(){
        return categorieService.getCountCategory();
    }


}
