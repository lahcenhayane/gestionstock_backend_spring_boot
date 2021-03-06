package com.project.backend.Repositories;

import com.project.backend.Entities.UtilisateursEntity;
import com.project.backend.Utils.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateursEntity, Long> {

    UtilisateursEntity findByEmail(String email);

    UtilisateursEntity findByEmailAndCin(String email, String cin);


    Page<UtilisateursEntity> findBySupprimer(Date date, Pageable pageable);


    Page<UtilisateursEntity> findByEmailContains(String s, Pageable pageable);


    Page<UtilisateursEntity> findByRole(Pageable pageable, Roles role);

    List<UtilisateursEntity> findByRole(Roles role);

    List<UtilisateursEntity> findByRoleAndCinContains(Roles client, String search);

    @Query(
            value = "SELECT * FROM utilisateurs u WHERE u.role = 'Client' ORDER BY date_creation DESC Limit 0, 5"
            ,nativeQuery = true
    )
    List<UtilisateursEntity> getUserGroupByOrder();
}
