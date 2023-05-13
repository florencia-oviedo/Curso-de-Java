<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primera conexion servlet con JSP</title>
</head>
<body>
	
	<c:forEach var= "producto" items="${lista_productos}">
	
		${producto}<br>
	
	</c:forEach>
	
	
</body>
</html>