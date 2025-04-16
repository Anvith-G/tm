package org.cms.controller;

import java.io.IOException;
import java.util.List;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Course;

import org.cms.Repository.CourseRepository;

import org.cms.Services.CourseServiceImpl;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class StudentServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 
    	HttpSession session = request.getSession();
		try {
    		MySqlDBConnection ds=new MySqlDBConnection();
    		CourseRepository repository=new CourseRepository(ds);
    		CourseServiceImpl service=new CourseServiceImpl(repository);
    	    List<Course> fetched=service.fetchAllCourse();
    	    session.setAttribute("xyz", fetched);
    		}catch(Exception e) {
    			System.out.println(e);
    		}
		RequestDispatcher rd = request.getRequestDispatcher("course-list.jsp");
		rd.forward(request, response);
	}

}