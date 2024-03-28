package com.example.bachelorwork.repository;

import com.example.bachelorwork.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
