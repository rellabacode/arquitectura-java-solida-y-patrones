<%@page import="com.rellabacode.helpers.DatabaseHelper"%>
<%@page import="com.rellabacode.helpers.Libro"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Libros</title>
<!-- Responsabilidad: PRESENTACIÓN -->
<script type="text/javascript">
	function redirectToURL(){
		var categoria = document.getElementsByName("categoria")[0].value;
		if (categoria != undefined){
			window.location.href = window.location.origin + window.location.pathname + "?accion=filtrocategorialibro&categoria="+categoria;
		}
	}

</script>

</head>
<body>
<!-- Impresión de datos  -->
	<select name='categoria' onchange="redirectToURL()">
		<c:forEach var="categoria" items="${listaCategorias}">
			<c:choose>
				<c:when test="${filtroCategoria != null && filtroCategoria.equals(categoria)}">
					<option value="${categoria}" selected>${categoria}</option>	
				</c:when>
				<c:otherwise>
					<option value="${categoria}">${categoria}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	
	<h2>Listado de Libros</h2>

	<table border='1'>
		<tr>
			<th>ISBN</th>
			<th>Título</th>
			<th>Categoría</th>
		</tr>

		<c:forEach var="libro" items="${listaLibros}">
			<tr>
				<td>${libro.isbn}</td>
				<td>${libro.titulo}</td>
				<td>${libro.categoria}</td>
				<!-- Resp. de control -->
				<td><a href="?accion=borrarlibro&isbn=${libro.isbn}">borrar</a></td>
			</tr>
		</c:forEach>
	</table>

<!-- Resp. de control -->
	<a href='?accion=formularionuevolibro'>Nuevo</a>
</body>
</html>