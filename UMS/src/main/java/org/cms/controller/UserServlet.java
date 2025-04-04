package org.cms.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/*") // Handles requests like /user/{userID}
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       

        String pathInfo = request.getPathInfo(); // Get "/{userID}"
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp"); 
            return;
        }

        String userID = pathInfo.substring(1); // Remove "/"
        response.setContentType("text/html");
        response.getWriter().println("<h2>Welcome, " + userID + "!</h2>");
        response.getWriter().println("<a href='" + request.getContextPath() + "/logout'>Logout</a>");
    }
}
