<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Resultados de su calculo</h1> 
<p><%= LocalDateTime.now() %></p>
<p>
<%= Integer.parseInt(request.getParameter("valor1")) + Integer.parseInt(request.getParameter("valor2")) %>
</p>
</body>
</html>