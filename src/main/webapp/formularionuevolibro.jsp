<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.arquitecturajava.helpers.LibroAR" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
List<String> listaCategorias = LibroAR.buscarTodasLasCategorias();
request.setAttribute("listaCategorias", listaCategorias);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulario de libro</title>
</head>
<body>
	<h2>Formulario de libro</h2>
	<form action="/web1/insertarlibro.jsp" method="post">
		<label for="isbn">ISBN:</label>
		<input type="text" name="isbn" required><br>
		
		<label for="titulo">T&iacute;tulo:</label>
		<input type="text" name="titulo" required><br>
		
		<label for="categoria">Categor&iacute;a:</label>
		<select name="categoria">
			<c:forEach var="categoria" items="${listaCategorias}">
				<option value="${categoria}">${categoria}</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="Guardar libro">
	</form>
</body>
</html>