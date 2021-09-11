package com.project.backend.controllers;

import com.project.backend.entities.AdminsEntity;
import com.project.backend.requests.AdminRequest;
import com.project.backend.requests.LoginRequest;
import com.project.backend.responses.AdminResponse;
import com.project.backend.services.impl.IAdminServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IAdminServiceImpl adminService;

    @PostMapping
    public ResponseEntity<AdminResponse> createNewAdmin(@RequestBody AdminRequest adminRequest){
        //Copy Data From AdminResquest to AdminsEntity.
        AdminsEntity adminsEntity = modelMapper.map(adminRequest, AdminsEntity.class);

        AdminsEntity admins = adminService.createAdmin(adminsEntity);

        //Copy Data From @admins to AdminResponse.
        AdminResponse adminResponse = modelMapper.map(admins, AdminResponse.class);
        return new ResponseEntity<AdminResponse>(adminResponse, HttpStatus.CREATED);
    }

}
