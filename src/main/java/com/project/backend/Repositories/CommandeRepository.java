package com.project.backend.Repositories;

import com.project.backend.Entities.CommandesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<CommandesEntity, Long> {

    @Query(value = "SELECT * FROM commandes cmd, clients cl, utilisateurs u WHERE  cmd.clients_id = cl.id AND cl.utilisateurs_id = u.id AND u.prenom LIKE %:search% OR u.nom LIKE %:search%",
           nativeQuery = true)
    Page<CommandesEntity> findByClient(Pageable pageable, @Param("search") String search);
}
