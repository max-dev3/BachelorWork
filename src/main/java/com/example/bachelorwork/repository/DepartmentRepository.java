package com.example.bachelorwork.repository;

import com.example.bachelorwork.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
