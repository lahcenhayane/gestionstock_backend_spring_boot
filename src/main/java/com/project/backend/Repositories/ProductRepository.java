package com.project.backend.Repositories;

import com.project.backend.Entities.ProduitsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProduitsEntity, Long> {

    @Query(value = "SELECT * FROM produits p, categories c WHERE p.categorie_id = c.id AND c.labelle LIKE %:categorie%",
           nativeQuery = true
          )
    Page<ProduitsEntity> findAllProductByCategory(@Param("categorie") String categorie, Pageable pageable);

    Page<ProduitsEntity> findByNomContains(String name, Pageable pageable);

}
