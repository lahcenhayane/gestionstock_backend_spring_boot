package com.project.backend.Repositories;

import com.project.backend.Entities.CategoriesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository  extends JpaRepository<CategoriesEntity, Long> {
    List<CategoriesEntity> findByLabelleContains(String categorie);

    CategoriesEntity getByLabelle(String labelle);
}
