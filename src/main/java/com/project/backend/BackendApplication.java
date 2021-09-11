package com.project.backend;

import com.project.backend.entities.RolesEntity;
import com.project.backend.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private RolesRepository rolesRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        //Add Roles
        RolesEntity adminRole = rolesRepository.findByLibelle("Admin");
        RolesEntity clientRole = rolesRepository.findByLibelle("Client");
        RolesEntity employeRole = rolesRepository.findByLibelle("Employe");
        if (adminRole == null){ rolesRepository.save(new RolesEntity("Admin")); }
        if (clientRole == null){ rolesRepository.save(new RolesEntity("Client")); }
        if (employeRole == null){ rolesRepository.save(new RolesEntity("Employe")); }



    }
}
