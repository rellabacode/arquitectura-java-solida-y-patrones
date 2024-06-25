<%@ page import="jakarta.servlet.http.HttpServlet"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
		<input type="text" name="categoria" required><br>
		
		<input type="submit" value="Guardar libro">
	</form>
</body>
</html>