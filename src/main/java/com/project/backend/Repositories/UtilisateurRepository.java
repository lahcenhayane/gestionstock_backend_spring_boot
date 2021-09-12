package com.project.backend.Repositories;

import com.project.backend.Entities.UtilisateursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateursEntity, Long> {

    UtilisateursEntity findByEmail(String email);

    UtilisateursEntity findByEmailAndCin(String email, String cin);
}
