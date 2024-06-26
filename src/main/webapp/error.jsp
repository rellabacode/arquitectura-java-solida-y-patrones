<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<!-- Principio DRY - jsps delegan -->
</head>
<body>
Ha ocurrido un error en la aplicación: <%=exception.getMessage()%>
Error Interno:<%=exception.getCause().getMessage()%>
</body>
</html>