<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "org.cms.Model.Course" %>
<%
    Course course = (Course) request.getAttribute("course");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Edit Course</h2>
    <form action="update-course" method="get">
        <input type="hidden" name="cid" value="<%= course.getCid() %>">
        <div class="mb-3">
            <label for="name" class="form-label">Course Name</label>
            <input type="text" class="form-control" id="cname" name="cname" value="<%= course.getCname() %>" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Credit</label>
            <input type="text" class="form-control" id="credit" name="credt" value="<%= course.getCredit()%>" required>
        </div>
          <div class="mb-3">
            <label for="email" class="form-label">Type</label>
            <input type="text" class="form-control" id="ctype" name="ctype" value="<%= course.getCtype()%>" required>
        </div>
        
        <button type="submit" class="btn btn-primary">Update Course</button>
        <a href="course-list" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>