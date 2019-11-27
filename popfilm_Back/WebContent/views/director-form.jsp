<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creación de directores</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
	
		<div class = "container">
	
		<h1>Director directory</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/DirectorController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "nombre" placeholder = "Introduzca nombre" value = "${director.nombre}"/>
					</div>
				
					<div class = "form-group">
						<input type = "date" class = "form-control" name = "fecha_de_nacimiento" placeholder = "Introduzca fecha" value = "${director.fechaNacimiento}"/>
					</div>
				
					<div class="form-group">
					  	<input type = "number" class = "form-control" name = "numPremios" placeholder = "Introduzca número de premios" value = "${director.numPremios}"/>
					</div>
				
					<input type = "hidden" name = "id_director" value = "${director.id_director}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/DirectorController?action=LIST">Back to List</a>
	</div>
	
	
	</body>
</html>