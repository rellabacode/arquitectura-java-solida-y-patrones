<%@page import="com.arquitecturajava.helpers.LibroAR"%>
<%@ page import="java.sql.*"%>
<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guardar Libro</title>
<!-- Responsabilidad: Persistencia -->
</head>
<body>

	<%
// Obtener parámetros del formulario
String isbn = request.getParameter("isbn");
String titulo = request.getParameter("titulo");
String categoria = request.getParameter("categoria");

//realizo la consulta usando el DBHelper y el codigo queda simplificado
LibroAR libro = new LibroAR(isbn, titulo, categoria);
libro.insertar();
/* Resp. de control */
response.sendRedirect("listalibros.jsp");
%>
</body>
</html>