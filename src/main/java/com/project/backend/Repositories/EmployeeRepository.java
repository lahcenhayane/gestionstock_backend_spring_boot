package com.project.backend.Repositories;

import com.project.backend.Entities.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Long> {
}
