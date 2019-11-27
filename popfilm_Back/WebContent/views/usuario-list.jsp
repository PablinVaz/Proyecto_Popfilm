<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de usuarios</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "container">
		
		<h1>User directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/usuario-form.jsp'">Añadir usuario</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>NickName</th>
				<th>Password</th>
				
				
			</tr>
			
			<c:forEach items="${list}" var="usuario">
			
				<tr>
					<td>${usuario.nombre}</td>
					<td>${usuario.apellido}</td>
					<td>${usuario.email}</td>
					<td>${usuario.nickName}</td>
					<td>${usuario.password}</td>
					

					
					<td> 
						<a href = "${pageContext.request.contextPath}/UsuarioController?action=EDIT&id=${usuario.id_usuario}">Editar</a> 
						| 
						<a href = "${pageContext.request.contextPath}/UsuarioController?action=DELETE&id=${usuario.id_usuario}">Borrar</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>