package com.project.backend.Repositories;

import com.project.backend.Entities.MessagesEntity;
import com.project.backend.Entities.UtilisateursEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessagesEntity, Long> {
    Page<MessagesEntity> findByUtilisateur(UtilisateursEntity user, Pageable of);

    Page<MessagesEntity> findByEmail(String email, Pageable pageable);
}
