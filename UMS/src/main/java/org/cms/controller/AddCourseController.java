package org.cms.controller;

import java.io.IOException;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Course;
import org.cms.Repository.CourseRepository;

import org.cms.Services.CourseServiceImpl;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class RegistrationController
 */
public class AddCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config;
    private ServletContext context;
    public AddCourseController() {
    }

	public void init(ServletConfig config) throws ServletException {
		//Logger
		this.config=config;
		this.context=getServletContext();
		super.init(config);
		System.out.println("servlet loaded");
		}

	public ServletConfig getServletConfig() {
		return config;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//Create ServletContext
		
		String email=context.getInitParameter("admin");
		//Create ServletConfig
		config=getServletConfig();
		String drivername=config.getInitParameter("driver");
		String un=config.getInitParameter("username");
		String pwd=config.getInitParameter("password");
		response.getWriter().print("<h2>"+"Driver:"+drivername+"</h2>");
		response.getWriter().print("<h2>"+"User"+un+"</h2>");
		response.getWriter().print("<h2>"+"Password"+pwd+"</h2>");
		response.getWriter().print("<h2>"+"mailto:"+email+"</h2>");
		//Create Session 
		HttpSession session=request.getSession();
		//HttpSession session=request.getSession(false);
		//Receive from Request
		Course s=new Course();
		s.setCid(request.getParameter("cid"));
		s.setCname(request.getParameter("cname"));
		s.setCredit(request.getParameter("credit"));
		s.setCtype(request.getParameter("type"));
		
		// perform database operation
		int r=0;
		try {
		MySqlDBConnection ds=new MySqlDBConnection();
		CourseRepository repository=new CourseRepository(ds);
		CourseServiceImpl service=new CourseServiceImpl(repository);
	     r=service.insertCourse(s);
		}catch(Exception e) {
			System.out.println(e);
		}
		if(r==1)
			 response.sendRedirect("course-list.jsp");	
		//request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
		else
		response.sendRedirect("error.jsp");	
	}

}