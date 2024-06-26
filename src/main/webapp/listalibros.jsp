<%@page import="com.arquitecturajava.helpers.DatabaseHelper"%>
<%@page import="com.arquitecturajava.helpers.LibroAR"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<%
	try {
	  ArrayList<String> listaCategorias = LibroAR.buscarTodasLasCategorias();

	  //Mostrar el listado de libros en una tabla
	  out.println("<select name='categoria'>");
	  for(String categoria: listaCategorias){
	    out.println("<option>" + categoria + "</option>");
	  }
	  out.println("</select>");

	} catch (Exception e) {
	  out.println("<p>Error al obtener las categorías</p>");
	  e.printStackTrace();
	}
	%>


	<%
	// Obtener el listado de libros desde la base de datos
	String consulta = "SELECT * FROM libros";

	try {
	  ArrayList<LibroAR> listaLibros = LibroAR.buscarTodos();

	  // Mostrar el listado de libros en una tabla 
	  out.println("<h2>Lista de Libros</h2>");
	  out.println("<table border='1'>");
	  out.println("<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");

	  //Recorrer los resultados y mostrar la tabla
	  for (LibroAR libro : listaLibros) {
	    out.println("<tr><td>" + libro.getIsbn() + "</td><td>" + libro.getTitulo() + "</td><td>"
	        + libro.getCategoria() + "</td></tr>");
	  }
	  out.println("</table>");

	  //Cerrar la conexión y el PreparedStatement
	  //DatabaseHelper.close(connection, statement, resultSet)

	} catch (Exception e) {
	  out.println("<p>Error al obtener el listado de libros.</p>");
	  e.printStackTrace();
	}
	%>
	<a href='formularionuevolibro.jsp'>Nuevo</a>
</body>
</html>