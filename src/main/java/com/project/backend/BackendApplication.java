package com.project.backend;

import com.project.backend.Entities.AdminsEntity;
import com.project.backend.Entities.CategoriesEntity;
import com.project.backend.Entities.ProduitsEntity;
import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Exceptions.UtilisateurException;
import com.project.backend.Repositories.CategorieRepository;
import com.project.backend.Repositories.ProductRepository;
import com.project.backend.Repositories.UtilisateurRepository;
import com.project.backend.Utils.Gendre;
import com.project.backend.Utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.DateFormat;
import java.util.Date;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

        if (utilisateurRepository.count() <= 0){
            UtilisateursEntity utilisateursEntity = new UtilisateursEntity();
            utilisateursEntity.setCin("X986754");
            utilisateursEntity.setNom("Lahcen");
            utilisateursEntity.setPrenom("HAYANE");
            utilisateursEntity.setEmail("lahcenhayane@gmail.com");
            utilisateursEntity.setPassword(bCryptPasswordEncoder().encode("lahcenhayane123"));
            utilisateursEntity.setVille("Rabat");
            utilisateursEntity.setTel("0676453409");
            utilisateursEntity.setGendre(Gendre.Homme);
            utilisateursEntity.setRole(Roles.Admin);
            utilisateursEntity.setDateNaissance(new Date());
            AdminsEntity admins = new AdminsEntity();
            admins.setUtilisateur(utilisateursEntity);
            utilisateursEntity.setAdmin(admins);
            utilisateurRepository.save(utilisateursEntity);
        }


        if (categorieRepository.count() <= 0){
            CategoriesEntity categoriesEntity1 = new CategoriesEntity();
            CategoriesEntity categoriesEntity2 = new CategoriesEntity();
            CategoriesEntity categoriesEntity3 = new CategoriesEntity();
            CategoriesEntity categoriesEntity4 = new CategoriesEntity();

            categoriesEntity1.setLabelle("Category One");
            categorieRepository.save(categoriesEntity1);

            categoriesEntity2.setLabelle("Category Two");
            categorieRepository.save(categoriesEntity2);

            categoriesEntity3.setLabelle("Category Three");
            categorieRepository.save(categoriesEntity3);

            categoriesEntity4.setLabelle("Category Four");
            categorieRepository.save(categoriesEntity4);
        }


        
    }
}
