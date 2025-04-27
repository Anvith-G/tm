package com.university.result_management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.result_management.models.CourseEnrollment;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, Long> {
    List<CourseEnrollment> findByStudentId(Long studentId);
    List<CourseEnrollment> findByCourseId(Long courseId);
}