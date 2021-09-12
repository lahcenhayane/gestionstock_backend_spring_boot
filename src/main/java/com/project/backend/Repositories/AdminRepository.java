package com.project.backend.Repositories;

import com.project.backend.Entities.AdminsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminsEntity, Long> {


}
