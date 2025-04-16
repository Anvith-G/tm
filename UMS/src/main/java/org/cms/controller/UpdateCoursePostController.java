package org.cms.controller;

import java.io.IOException;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Course;

import org.cms.Repository.CourseRepository;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateStudentPostController
 */
public class UpdateCoursePostController extends HttpServlet {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String credit = request.getParameter("credit");
        String ctype = request.getParameter("type");
       
        Course course = new Course(cid, cname, credit,ctype);
System.out.println(course);
       int r= courseRepo.updateCourse(course, cid);
        if(r==1)
        	response.sendRedirect("Course");
        else
        	response.sendRedirect("error.jsp");
	}

}