package com.university.result_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.result_management.models.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByStudentId(Long studentId);
}