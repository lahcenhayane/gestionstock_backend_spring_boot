package com.project.backend.repositories;

import com.project.backend.entities.UtilisateursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateursEntity, Long> {

    UtilisateursEntity findByEmail(String email);
}
