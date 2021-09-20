package com.project.backend.Controllers;

import com.project.backend.Dto.UtilisateurDTO;
import com.project.backend.Factory.PageStateEnum;
import com.project.backend.Factory.DtoPage.UtilisateurDtoPage;
import com.project.backend.Factory.Page;
import com.project.backend.Factory.PageFactory;
import com.project.backend.Factory.ResponsePage.UtilisateurResponsePage;
import com.project.backend.Responses.UtilisateurResponse;
import com.project.backend.Services.IAdminService;
import com.project.backend.Utils.Roles;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/admins")
public class AdminController {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IAdminService adminService;


    /**
     * Get Users By Role
     * @param page
     * @param role
     * @return pages
     */
    @GetMapping
    public ResponseEntity<Page> getAllUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "role", defaultValue = "") Roles role){

        UtilisateurDtoPage utilisateurDtoPage = adminService.getAllUser(page, role);

        UtilisateurResponsePage utilisateurResponsePage =
                new UtilisateurResponsePage(mapDtoToResponse(utilisateurDtoPage.getList()), utilisateurDtoPage.getTotalPage(), utilisateurDtoPage.getTotalRow());

        Page pages = PageFactory.getPage(PageStateEnum.UtilisateurResponsePage, utilisateurResponsePage);

        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page> findUserByEmail(@RequestParam(value = "email") String email,
                                                @RequestParam(value = "page", defaultValue = "0") int page){
        UtilisateurDtoPage utilisateurDtoPage = adminService.findUsersByEmail(email, page);
        UtilisateurResponsePage utilisateurResponsePage =
                new UtilisateurResponsePage(mapDtoToResponse(utilisateurDtoPage.getList()), utilisateurDtoPage.getTotalPage(), utilisateurDtoPage.getTotalRow());
        Page pages = PageFactory.getPage(PageStateEnum.UtilisateurResponsePage, utilisateurResponsePage);
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }


    private List<UtilisateurResponse> mapDtoToResponse(List<UtilisateurDTO> list){
        return list
               .stream()
               .map(row->modelMapper.map(row, UtilisateurResponse.class))
               .collect(Collectors.toList());
    }

}
