package com.example.bachelorwork.repository;

import com.example.bachelorwork.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
