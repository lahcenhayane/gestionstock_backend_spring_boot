package com.project.backend.repositories;

import com.project.backend.entities.AdminsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminsEntity, Long> {


}
