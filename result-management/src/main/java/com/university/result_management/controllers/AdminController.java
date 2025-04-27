package com.university.result_management.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.university.result_management.models.Course;
import com.university.result_management.models.Department;
import com.university.result_management.models.Instructor;
import com.university.result_management.models.Student;
import com.university.result_management.services.AdminService;
import com.university.result_management.services.CourseService;
import com.university.result_management.services.DepartmentService;
import com.university.result_management.services.InstructorService;
import com.university.result_management.services.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	private final DepartmentService departmentService;
	private final StudentService studentService;
    private final AdminService adminService;
    private final CourseService courseService;
    private final InstructorService instructorService;

    // GET Mappings for Pages
    @GetMapping("/dashboard")
    public String dashboard() {
        return "html/admin-dashboard"; // Resolves to dashboard.jsp
    }

    @GetMapping("/create-student")
    public String showCreateStudentPage(Model model) {
    	 List<Department> departments = departmentService.getAllDepartment(); // however you fetch them
 	    model.addAttribute("departments", departments);
        model.addAttribute("student", new Student());
     
        return "html/create-student"; // Resolves to create-student.jsp
    }
    @PostMapping("/create-student")
    public String createStudent(@ModelAttribute Student student, 
            @RequestParam("departmentId") Long departmentId) {
		Department department = departmentService.getDepartmentById(departmentId);
		student.setDepartment(department);
		adminService.createStudent(student);
		System.out.println("-----------------Student saved successfully!");
		return "redirect:/admin/students"; // after creating, go back to students list
    }
    @GetMapping("/delete-student/{id}")
    public String showDeleteStudentConfirmation(@PathVariable Long id, Model model) {
        model.addAttribute("id", id); // Add ID to the model
        return "html/delete-student"; // Confirmation page for deletion
    }

    // DELETE Student - Perform deletion
    @PostMapping("/delete-student")
    public String deleteStudent(@RequestParam Long id) {
        adminService.deleteStudent(id);
        return "redirect:/admin/students"; // Redirect to students list
    }

    @GetMapping("/create-instructor")
    public String showCreateInstructorPage(Model model) {
    	 List<Department> departments = departmentService.getAllDepartment(); // however you fetch them
  	    model.addAttribute("departments", departments);
        model.addAttribute("instructor", new Instructor());
        return "html/create-instructor"; // Resolves to create-instructor.jsp
    }

    @PostMapping("/create-instructor")
    public String createInstructor(@ModelAttribute Instructor instructor,
    		@RequestParam("departmentId") Long departmentId) {
    	Department department = departmentService.getDepartmentById(departmentId);
		instructor.setDepartment(department);
		adminService.createInstructor(instructor);
		System.out.println("-----------------instructor saved successfully!");
        return "redirect:/admin/instructors"; // after creating, go back to instructor list
    }
  

    @GetMapping("/create-department")
    public String showCreateDepartmentPage(Model model) {
        model.addAttribute("department", new Department());
        return "html/create-department"; // Resolves to create-department.jsp
    }
    @PostMapping("/create-department")
    public ResponseEntity<Department> createDepartment(@ModelAttribute Department department) {
        return ResponseEntity.ok(adminService.createDepartment(department));
    }
    @GetMapping("/create-course")
    public String createCourse(Model model) {
    	 List<Department> departments = departmentService.getAllDepartment(); // however you fetch them
  	    model.addAttribute("departments", departments);
  	  List<Instructor> instructors = instructorService.getAllInstructor(); // however you fetch them
	    model.addAttribute("instructorss", instructors);
    	model.addAttribute("course",new Course());
    	return "html/create-course";
    }
    @PostMapping("/create-course")
    public String createCourse(@ModelAttribute Course course,
    		@RequestParam("departmentId") Long departmentId,
    		@RequestParam("instructorId") Long instructorId){
    	Department departmentID = departmentService.getDepartmentById(departmentId);
		course.setDepartment(departmentID);
		Instructor instructorID = instructorService.getInstructorById(instructorId);
		course.setInstructor(instructorID);
		adminService.createCourse(course);
    	return "redirect:/admin/courses";
    }

    @GetMapping("/students")
    public String showStudents(Model model) {    	
    	  List<Student> students = studentService.getAllStudents(); // Ensure this list is populated
    	  System.out.println(students);
    	    model.addAttribute("allstudents", students);     
    	    return "html/list-students"; // Resolves to list-students.jsp
    }

    @GetMapping("/instructors")
    public String showInstructors(Model model) {
        model.addAttribute("allinstructors", adminService.getAllInstructors());
        return "html/list-instructors"; // Resolves to list-instructors.jsp
    }
    @GetMapping("/departments")
    public String showDepartments(Model model) {
    	model.addAttribute("alldepartments",departmentService.getAllDepartment());
    	return "htmml/list-departments";
    }
    @GetMapping("/courses")
    public String showCourses(Model model) {
        model.addAttribute("allcourses", courseService.getAllCourse());
        return "html/list-courses"; // Resolves to list-instructors.jsp
    }
    @GetMapping("/instructors/department/{departmentId}")
    @ResponseBody 
    public List<Instructor> getInstructorsByDepartment(@PathVariable Long departmentId) {
        return instructorService.getInstructorByDepartment(departmentId);
    }

  


   


   
}
