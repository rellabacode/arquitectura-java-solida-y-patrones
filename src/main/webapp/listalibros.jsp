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
try{
	
	//Configuración de la conexión JDBC
	String jdbcURL = "jdbc:mysql://127.0.0.1:3306/biblioteca";
	String usuario = "root";
	String contraseña = "";
	
	//Utilizando try-with-resources para garantizar el cierre de recursos
	try(Connection connection = DriverManager.getConnection(jdbcURL, usuario, contraseña);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM libros")){

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
	    out.println("<a href='formularionuevolibro.jsp'>Nuevo</a>");
	} 	catch (SQLException e) {
        out.println("<p>Error al obtener la lista de libros.</p>");
        e.printStackTrace();
    }
} catch (Exception e) {
    out.println("<p>Error al procesar la solicitud.</p>"); 
    e.printStackTrace();
}



%>


</body>
</html>