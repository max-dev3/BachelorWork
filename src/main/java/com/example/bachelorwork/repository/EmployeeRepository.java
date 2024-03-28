package com.example.bachelorwork.repository;

import com.example.bachelorwork.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
