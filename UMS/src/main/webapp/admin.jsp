<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <h2><%= request.getAttribute("message") %></h2>
    <p>This is the Admin Dashboard.</p>
</body>
</html>