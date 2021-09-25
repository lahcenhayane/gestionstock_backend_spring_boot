package com.project.backend.Repositories;

import com.project.backend.Entities.ClientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientsEntity, Long> {
}
