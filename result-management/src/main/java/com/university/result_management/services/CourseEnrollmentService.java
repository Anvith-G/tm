package com.university.result_management.services;

import org.springframework.stereotype.Service;

import com.university.result_management.models.Course;
import com.university.result_management.models.CourseEnrollment;
import com.university.result_management.models.Student;
import com.university.result_management.repositories.CourseEnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseEnrollmentService {

    private final CourseEnrollmentRepository enrollmentRepo;

    public CourseEnrollment enrollStudent(Long studentId, Long courseId) {
        CourseEnrollment ce = new CourseEnrollment();
        ce.setStudent(Student.builder().id(studentId).build());
        ce.setCourse(Course.builder().id(courseId).build());
        ce.setStatus("Pending");
        return enrollmentRepo.save(ce);
    }
}
