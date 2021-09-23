package com.project.backend.Repositories;

import com.project.backend.Entities.ProduitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProduitsEntity, Long> {
}
