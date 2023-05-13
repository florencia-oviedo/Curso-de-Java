<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
<style>
.cabecera{
	font-size : 1.2em;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #F07EE8;
	
}
.filas{
	text-align: center;
	background-color: #F7C3F4;
}
table{
	float: left;
}

#contenedorBoton{
	margin-left:800px;
}


</style>
</head>

<body>
	<table>
	<tr>
	<td class="cabecera">Código Artículo</td>
	<td class="cabecera">Sección</td>
	<td class="cabecera">Nombre Artículo</td>
	<td class="cabecera">Precio</td>
	<td class="cabecera">Fecha</td>
	<td class="cabecera">Importado</td>
	<td class="cabecera">País de origen</td>
	<td class="cabecera">Acción</td>
	</tr>
	
	<c:forEach var="producto" items="${listaProductos}">
	
	<!-- link para cada producto con su campo clave -->
	<c:url var="linkTemp" value="ControladorProductos">
		<c:param name="instruccion" value="cargar"></c:param>
		<c:param name="CArticulo" value="${producto.codigoArticulo}"></c:param>
	</c:url>
	<!-- link para eliminar el registro con su campo clave -->
	<c:url var="linkTempEliminar" value="ControladorProductos">
		<c:param name="instruccion" value="eliminar"></c:param>
		<c:param name="CArticulo" value="${producto.codigoArticulo}"></c:param>
	</c:url>
	
	<tr>
	<td class="filas">${producto.codigoArticulo}</td>
	<td class="filas">${producto.seccion}</td>
	<td class="filas">${producto.nArticulo}</td>
	<td class="filas">${producto.precio}</td>
	<td class="filas">${producto.fecha}</td>
	<td class="filas">${producto.importado}</td>
	<td class="filas">${producto.paisOrigen}</td>
	<td class="filas"><a href= "${linkTemp}">Actualizar</a>&nbsp;&nbsp;<a href= "${linkTempEliminar}">Eliminar</a></td>
	
	</tr>
	
	</c:forEach>
	</table>
	
	<div id="contenedorBoton">
		<input type="button" value="Insertar registro" onclick="window.location.href='inserta_producto.jsp'"/>
	
	</div>
</body>
</html>