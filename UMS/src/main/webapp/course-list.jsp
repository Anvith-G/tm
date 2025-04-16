<!-- student-list.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import = "org.cms.Model.Course" %>
<%
HttpSession oldsession=request.getSession(false);
    List<Course> courses = (List<Course>) oldsession.getAttribute("xyz");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Course List</h2>
    <a href="add-course.jsp" class="btn btn-success mb-3">Add New Course</a>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>CourseID</th>
            <th>Course Name</th>
            <th>Credit</th>
            
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% if (courses != null) {
            for (Course c : courses) {
        %>
        <tr>
            <td><%= c.getCid() %></td>
            <td><%= c.getCname() %></td>
            <td><%= c.getCredit()%></td>
            
            <td>
                <a href="edit-course?id=<%= c.getCid() %>" class="btn btn-sm btn-primary">Edit</a>
                <a href="delete-course?cid=<%= c.getCid() %>" class="btn btn-sm btn-danger">Delete</a>
            </td>
        </tr>
        <%  }
        } else {
        %>
        <tr><td colspan="5" class="text-center">No Course found</td></tr>
        <% } %>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>