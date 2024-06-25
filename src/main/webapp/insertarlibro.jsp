<%@ page import="com.arquitecturajava.helpers.DatabaseHelper" %>
<%@ page import="java.sql.*"%>
<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guardar Libro</title>
</head>
<body>

	<%
// Obtener parámetros del formulario
String isbn = request.getParameter("isbn");
String titulo = request.getParameter("titulo");
String categoria = request.getParameter("categoria");

String consulta = "INSERT INTO libros (isbn, titulo, categoria) VALUES(?, ?, ?)";
DatabaseHelper.executeUpdate(consulta, isbn, titulo, categoria);
response.sendRedirect("listalibros.jsp");

%>

</body>
</html>