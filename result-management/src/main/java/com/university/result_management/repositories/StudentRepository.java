package com.university.result_management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.result_management.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNumber(String rollNumber);
}