package com.university.result_management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.result_management.models.CourseEnrollment;
import com.university.result_management.models.Result;
import com.university.result_management.models.Student;
import com.university.result_management.repositories.StudentRepository;
import com.university.result_management.services.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepo;
    @GetMapping("/dashboard")
    public String dashboard() {
        return "html/student-dashboard"; // Resolves to dashboard.jsp
    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<Student> getStudentProfile(@PathVariable Long id) {
        Optional<Student> studentOpt = studentRepo.findById(id);
        if (studentOpt.isPresent()) {
            return ResponseEntity.ok(studentOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/enrollments")
    public ResponseEntity<List<CourseEnrollment>> getEnrollments(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getEnrollments(id));
    }

    @GetMapping("/{id}/results")
    public ResponseEntity<List<Result>> getResults(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getResults(id));
    }
}
