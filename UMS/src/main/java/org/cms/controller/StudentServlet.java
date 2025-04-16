package org.cms.controller;

import java.io.IOException;
import java.util.List;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Student;
import org.cms.Repository.StudentRepository;
import org.cms.Services.StudentServiceImpl;

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
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
    		StudentRepository repository=new StudentRepository(ds);
    		StudentServiceImpl service=new StudentServiceImpl(repository);
    	    List<Student> fetched=service.fetchAll();
    	    session.setAttribute("xyz", fetched);
    		}catch(Exception e) {
    			System.out.println(e);
    		}
		RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
		rd.forward(request, response);
	}

}