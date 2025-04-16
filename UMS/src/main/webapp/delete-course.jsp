<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "org.cms.Model.Course" %>
<%
    Course course = (Course) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Delete Course</h2>
    <p>Are you sure you want to delete the following student?</p>
    <ul>
        <li><strong>Course Name:</strong> <%= course.getCname() %></li>
        <li><strong>Credit</strong> <%= course.getCredit() %></li>
    </ul>
    <form action="delete-course" method="post">
        <input type="hidden" name="id" value="<%= course.getCid() %>">
        <button type="submit" class="btn btn-danger">Confirm Delete</button>
        <a href="student-list" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>