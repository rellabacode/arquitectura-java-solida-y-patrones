<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.rellabacode.helpers.Libro" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulario de libro</title>
</head>
<body>
	<h2>Formulario de libro</h2>
	<form action="?accion=insertarlibro" method="post">
		<label for="isbn">ISBN:</label>
		<input type="text" name="isbn" required><br>
		
		<label for="titulo">T&iacute;tulo:</label>
		<input type="text" name="titulo" required><br>
		
		<label for="categoria">Categor&iacute;a:</label>
		<select name="categoria">
			<c:forEach var="categoria" items="${listaCategorias}">
				<option value="${categoria}">${categoria}</option>
			</c:forEach>
			<c:out value="paco" default=""></c:out>
		</select><br>
		<input type="submit" value="Guardar libro">
	</form>
</body>
</html>