<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.arquitecturajava.helpers.LibroAR"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Borrar Libro</title>
<!-- Responsabilidad: Control -->
</head>
<body>
	<%
	String isbn = request.getParameter("isbn");
	LibroAR libroAR = new LibroAR(isbn);
	libroAR.borrar();
	/* Resp. de control */
	response.sendRedirect("?accion=listar");
	%>
</body>
</html>