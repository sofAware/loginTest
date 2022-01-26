package com.example.logintest.repo;

import com.example.logintest.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Optional<Professor> findById(String id);
}
