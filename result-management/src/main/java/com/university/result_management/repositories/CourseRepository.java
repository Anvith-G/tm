package com.university.result_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.result_management.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {}
