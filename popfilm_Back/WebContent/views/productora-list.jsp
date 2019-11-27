<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de productoras</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "container">
		
		<h1>Productora directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/productora-form.jsp'">Añadir productora</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Nombre</th>
				<th>Inversión inicial</th>
				<th>Ganancias</th>
				<th>Ganancias totales</th>
				
				
			</tr>
			
			<c:forEach items="${list}" var="productora">
			
				<tr>
					<td>${productora.nombre}</td>
					<td>${productora.inversionInicial}</td>
					<td>${productora.ganancias}</td>
					<td>${productora.gananciasTotales}</td>
					

					
					<td> 
						<a href = "${pageContext.request.contextPath}/ProductoraController?action=EDIT&id=${productora.id_productora}">Editar</a> 
						| 
						<a href = "${pageContext.request.contextPath}/ProductoraController?action=DELETE&id=${productora.id_productora}">Borrar</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>