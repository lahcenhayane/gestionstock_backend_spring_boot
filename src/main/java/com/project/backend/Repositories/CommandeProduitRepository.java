package com.project.backend.Repositories;


import com.project.backend.Entities.CommandeProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeProduitRepository extends JpaRepository<CommandeProduitEntity, Long> {
}
