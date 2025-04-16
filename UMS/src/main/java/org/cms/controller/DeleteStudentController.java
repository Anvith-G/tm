package org.cms.controller;

import java.io.IOException;
import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Student;
import org.cms.Repository.StudentRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MySqlDBConnection ds;
    private StudentRepository studentRepo;

    @Override
    public void init() throws ServletException {
        try {
            ds = new MySqlDBConnection();
            studentRepo = new StudentRepository(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the GET request by fetching the student's details
     * and forwarding to a confirmation page.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Student student = studentRepo.fetchOneStudent(id);
        if (student != null) {
            request.setAttribute("student", student);
            // Forward to a JSP that confirms deletion.
            request.getRequestDispatcher("delete-student.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    /**
     * Handles the POST request by performing the deletion.
     * The confirmation form in "delete-student.jsp" should submit a POST request
     * with the student's id (usually via a hidden field).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the student's id from the form submission.
        String id = request.getParameter("id");
        int result = studentRepo.deleteStudent(id);

        if (result == 1) {
            // Redirect to a success page or listing page.
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
