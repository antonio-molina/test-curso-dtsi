<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Resultados de su calculo</h1> 
<p><%= request.getAttribute("horaActual") %></p>
<p>
<%= request.getAttribute("resultado") %>
</p>
</body>
</html>