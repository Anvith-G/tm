package org.cms.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginController extends HttpServlet {
    
    private String adminEmail;
    private String adminPassword;

    @Override
    public void init(ServletConfig config) throws ServletException {
        // Fetch admin credentials from web.xml
        ServletContext context = config.getServletContext();
        adminEmail = context.getInitParameter("adminEmail");
        adminPassword = context.getInitParameter("adminPassword");
    }

    // ✅ Fix: Forwarding to login.jsp instead of redirecting to prevent loop
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // ✅ Check if email & password are provided
        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Email and Password are required!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // ✅ If admin logs in, create a session and store role
        if (email.equalsIgnoreCase(adminEmail) && password.equals(adminPassword)) {
            HttpSession session = request.getSession(true);  // 🔥 Create session
            session.setAttribute("user", "admin");          // 🔥 Store user role
            response.sendRedirect(request.getContextPath() + "/admin");  // Redirect to /admin
        } else {
            // ✅ If normal user logs in, create a session for user
            HttpSession session = request.getSession(true);
            session.setAttribute("user", "user");          // 🔥 Store user role
            response.sendRedirect(request.getContextPath() + "/user");  // Redirect to /user
        }
    }



}
