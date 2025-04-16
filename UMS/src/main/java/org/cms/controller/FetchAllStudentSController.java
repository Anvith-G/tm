package org.cms.controller;



import java.io.IOException;
import java.util.List;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Student;
import org.cms.Repository.StudentRepository;
import org.cms.Services.StudentServiceImpl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class FetchAllStudentSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private ServletConfig config;   
   
    public FetchAllStudentSController() {
        super();
    }
    public void init(ServletConfig config) {
		this.config=config;
		this.context=getServletContext();
		System.out.println("Servlet Loaded");	
	}
    public ServletConfig getServletConfig() {
		return config;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
    	//config for receiving the details
    	// of the user for authentication and authorization
    	// BASIC , JWT 
    	
    	// conext represents app
    	// 17 modules - 1 context
    	// performance 
    	
    	// Session 
    	HttpSession session = request.getSession();
    	
    	// Request and Response 
    	response.getWriter().println("<h2>"+request.getRequestURL()+"</h2>");
    	
    	// getting all student from db
    	try {
    		MySqlDBConnection ds=new MySqlDBConnection();
    		StudentRepository repository=new StudentRepository(ds);
    		StudentServiceImpl service=new StudentServiceImpl(repository);
    	    List<Student> fetched=service.fetchAll();
    	    session.setAttribute("xyz", fetched);
    		}catch(Exception e) {
    			System.out.println(e);
    		}
    	
    	// jsp for projecting fetched student
    	request.getRequestDispatcher("show.jsp").forward(request, response); 
    }
}