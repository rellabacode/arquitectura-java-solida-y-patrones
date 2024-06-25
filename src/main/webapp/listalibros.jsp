<%@page import="com.arquitecturajava.helpers.DatabaseHelper"%>
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
    // Obtener el listado de libros desde la base de datos
    String consulta = "SELECT * FROM libros";

    try {
    	ResultSet resultSet = DatabaseHelper.executeQuery(consulta);

        // Mostrar el listado de libros en una tabla 
        out.println("<h2>Lista de Libros</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ISBN</th><th>Título</th><th>Categoría</th></tr>");	
        
    	//Recorrer los resultados y mostrar la tabla    
	    while(resultSet.next()){
	    	String isbn =  resultSet.getString("isbn");
	    	String titulo =  resultSet.getString("titulo");
	    	String categoria =  resultSet.getString("categoria");
            out.println("<tr><td>" + isbn + "</td><td>" + titulo + "</td><td>" + categoria +
"</td></tr>");
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