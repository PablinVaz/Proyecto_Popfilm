<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creación de películas</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
	
		<div class = "container">
	
		<h1>Movie directory</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/PeliculaController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "titulo" placeholder = "Introduzca titulo" value = "${pelicula.titulo}"/>
					</div>
				
					<div class = "form-group">
						<input type = "date" class = "form-control" name = "fecha_de_estreno" placeholder = "Introduzca fecha de estreno" value = "${pelicula.fechaEstreno}"/>
					</div>
					
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "reparto" placeholder = "Introduzca reparto" value = "${pelicula.reparto}"/>
					</div>
					
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "sinopsis" placeholder = "Introduzca sinopsis" value = "${pelicula.sinopsis}"/>
					</div>
					
					<div class = "form-group">
						<input type = "number" class = "form-control" name = "edad_recomendada" placeholder = "Introduzca edad recomendada" value = "${pelicula.edadRecomendada}"/>
					</div>
				
					
				
					<input type = "hidden" name = "id_pelicula" value = "${pelicula.id_pelicula}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/PeliculaController?action=LIST">Back to List</a>
	</div>
	
	
	</body>

</html>