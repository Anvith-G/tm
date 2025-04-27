package com.university.result_management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.university.result_management.models.CourseEnrollment;
import com.university.result_management.models.Result;
import com.university.result_management.models.Student;
import com.university.result_management.repositories.CourseEnrollmentRepository;
import com.university.result_management.repositories.ResultRepository;
import com.university.result_management.repositories.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo ;      //initialized to null
    private final CourseEnrollmentRepository enrollmentRepo ;      //initialized to null
    private final ResultRepository resultRepo;      //initialized to null

    public Student getStudentProfile(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    public List<CourseEnrollment> getEnrollments(Long studentId) {
        return enrollmentRepo.findByStudentId(studentId);
    }

    public List<Result> getResults(Long studentId) {
        return resultRepo.findByStudentId(studentId);
    }
    public List<Student> getAllStudents(){
    	return studentRepo.findAll();
    }
}
