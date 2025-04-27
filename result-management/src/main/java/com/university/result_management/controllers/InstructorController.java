package com.university.result_management.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.result_management.models.Course;
import com.university.result_management.models.CourseEnrollment;
import com.university.result_management.services.InstructorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    @GetMapping("/dashboard")
    public String dashboard() {
        return "html/instructor-dashboard"; // Resolves to dashboard.jsp
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCourses(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.getCoursesByInstructor(id));
    }

    @PutMapping("/assign-grade")
    public ResponseEntity<CourseEnrollment> assignGrade(
            @RequestParam Long enrollmentId,
            @RequestParam Double marks,
            @RequestParam String grade) {
        return ResponseEntity.ok(instructorService.assignGrade(enrollmentId, grade, marks));
    }
}
