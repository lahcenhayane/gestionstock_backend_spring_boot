package com.project.backend.repositories;

import com.project.backend.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {

    RolesEntity findByLibelle(String admin);
}
