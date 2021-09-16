package com.project.backend.Repositories;

import com.project.backend.Entities.MessagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessagesEntity, Long> {
}
