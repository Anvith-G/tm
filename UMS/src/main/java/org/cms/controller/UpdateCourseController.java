package org.cms.controller;



import java.io.IOException;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Course;
import org.cms.Model.Student;
import org.cms.Repository.CourseRepository;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class UpdateCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MySqlDBConnection ds;
	private CourseRepository courseRepo;

    @Override
    public void init() throws ServletException {
    	try {
    	ds=new MySqlDBConnection();
        courseRepo = new CourseRepository(ds);
    	}catch(Exception e) {}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cid = request.getParameter("cid");
        Course course = courseRepo.fetchOneCourse(cid);
        request.setAttribute("course", course);
        request.getRequestDispatcher("update-course.jsp").forward(request, response);
       
    }
}