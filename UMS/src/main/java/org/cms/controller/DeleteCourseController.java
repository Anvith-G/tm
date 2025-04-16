package org.cms.controller;

import java.io.IOException;
import org.cms.DataSource.MySqlDBConnection;
import org.cms.Model.Course;

import org.cms.Repository.CourseRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCourseController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MySqlDBConnection ds;
    private CourseRepository courseRepo;

    @Override
    public void init() throws ServletException {
        try {
            ds = new MySqlDBConnection();
            courseRepo = new CourseRepository(ds);
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
        String id = request.getParameter("cid");
        Course course = courseRepo.fetchOneCourse(id);
        if (course != null) {
            request.setAttribute("course", course);
            // Forward to a JSP that confirms deletion.
            request.getRequestDispatcher("delete-course.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    /**
     * Handles the POST request by performing the deletion.
     * The confirmation form in "delete-course.jsp" should submit a POST request
     * with the student's id (usually via a hidden field).
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the student's id from the form submission.
        String id = request.getParameter("cid");
        int result = courseRepo.deleteCourse(id);

        if (result == 1) {
            // Redirect to a success page or listing page.
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
