package org.cms.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Student;

import org.cms.Repository.*;

import org.cms.Services.*;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationController() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward request to register.html
        RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.html");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Debugging: Print received parameters
        System.out.println("Received Parameters:");
        request.getParameterMap().forEach((key, value) -> System.out.println(key + " = " + String.join(",", value)));

        // Handle form inputs safely
        String yearParam = request.getParameter("year");
        int year = 0; // Default value

        if (yearParam != null && !yearParam.trim().isEmpty()) {
            try {
                year = Integer.parseInt(yearParam.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format: " + yearParam);
            }
        }

        Student s = new Student();
        s.setSid(request.getParameter("id"));
        s.setSname(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setAddress(request.getParameter("address"));
        s.setYear(year);

        int r = 0;
        try {
            MySqlDBConnection ds = new MySqlDBConnection();
            StudentRepository repository = new StudentRepository(ds);
            StudentServiceImpl service = new StudentServiceImpl(repository);
            r = service.insertStudent(s);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (r == 1)
            response.sendRedirect("success.jsp");
        else
            response.sendRedirect("error.jsp");
    }
}
