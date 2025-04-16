
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Add New Course</h2>
    <form action="add-course" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Course ID</label>
            <input type="text" class="form-control" id="cid" name="cid" required>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Course Name</label>
            <input type="text" class="form-control" id="cname" name="cname" required>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Credit</label>
            <input type="text" class="form-control" id="credit" name="credit" required>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Course Type</label>
            <input type="text" class="form-control" id="type" name="type" required>
        </div>
        
        <button type="submit" class="btn btn-success">Add Course</button>
        <a href="Course" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
