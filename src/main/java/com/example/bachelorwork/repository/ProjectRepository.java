package com.example.bachelorwork.repository;

import com.example.bachelorwork.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
