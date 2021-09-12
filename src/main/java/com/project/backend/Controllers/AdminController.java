package com.project.backend.Controllers;

import com.project.backend.Services.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IAdminService adminService;


}
