<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de peliculas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "container">
		
		<h1>Movie directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/pelicula-form.jsp'">Añadir película</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Título</th>
				<th>Fecha de estreno</th>
				<th>Reparto</th>
				<th>Sinopsis</th>
				<th>Edad recomendada</th>
				
			</tr>
			
			<c:forEach items="${list}" var="pelicula">
			
				<tr>
					<td>${pelicula.titulo}</td>
					<td>${pelicula.fechaEstreno}</td>
					<td>${pelicula.reparto}</td>
					<td>${pelicula.sinopsis}</td>
					<td>${pelicula.edadRecomendada}</td>

					
					<td> 
						<a href = "${pageContext.request.contextPath}/PeliculaController?action=EDIT&id=${pelicula.id_pelicula}">Editar</a> 
						| 
						<a href = "${pageContext.request.contextPath}/PeliculaController?action=DELETE&id=${pelicula.id_pelicula}">Borrar</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>