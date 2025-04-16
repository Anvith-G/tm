package org.cms.controller;



import java.io.IOException;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Student;
import org.cms.Repository.StudentRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditStudentController
 */
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MySqlDBConnection ds;
	private StudentRepository studentRepo;

    @Override
    public void init() throws ServletException {
    	try {
    	ds=new MySqlDBConnection();
        studentRepo = new StudentRepository(ds);
    	}catch(Exception e) {}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid = request.getParameter("id");
        Student student = studentRepo.fetchOneStudent(sid);
        request.setAttribute("student", student);
        request.getRequestDispatcher("update-student.jsp").forward(request, response);
       
    }
}