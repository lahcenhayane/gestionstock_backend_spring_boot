package com.project.backend.Repositories;

import com.project.backend.Entities.CategoriesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository  extends JpaRepository<CategoriesEntity, Long> {
    Page<CategoriesEntity> findByLabelleContains(String categorie, Pageable pageable);

    CategoriesEntity findByLabelle(String category_three);
}
