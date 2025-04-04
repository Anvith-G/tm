package org.cms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("user"))) {
            response.sendRedirect("login.jsp"); // Redirect to login if not admin
            return;
        }

        response.setContentType("text/html");
        response.getWriter().println("<h2>Welcome, Admin!</h2>");
        response.getWriter().println("<a href='logout'>Logout</a>");
    }
}
