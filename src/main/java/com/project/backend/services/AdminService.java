package com.project.backend.services;

import com.project.backend.entities.AdminsEntity;
import com.project.backend.repositories.AdminRepository;
import com.project.backend.services.impl.IAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminServiceImpl {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public AdminsEntity createAdmin(AdminsEntity adminsEntity) {
        return null;
    }
}
