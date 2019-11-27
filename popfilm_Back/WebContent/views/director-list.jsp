<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de directores</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "container">
		
		<h1>Director directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/director-form.jsp'">Añadir empleado</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Nombre</th>
				<th>Fecha de nacimiento</th>
				<th>Número de premios</th>
			</tr>
			
			<c:forEach items="${list}" var="director">
			
				<tr>
					<td>${director.nombre}</td>
					<td>${director.fechaNacimiento}</td>
					<td>${director.numPremios}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/DirectorController?action=EDIT&id=${director.id_director}">Editar</a> 
						| 
						<a href = "${pageContext.request.contextPath}/DirectorController?action=DELETE&id=${director.id_director}">Borrar</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>