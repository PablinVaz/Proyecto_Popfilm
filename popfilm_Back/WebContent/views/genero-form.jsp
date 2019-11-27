<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creación de géneros</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
	
		<div class = "container">
	
		<h1>Genre directory</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/GeneroController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "nombre" placeholder = "Introduzca nombre" value = "${genero.nombre}"/>
					</div>
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "descripcion" placeholder = "Introduzca descripcion" value = "${genero.descripcion}"/>
					</div>
				
					
				
					<input type = "hidden" name = "id_genero" value = "${genero.id_genero}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/GeneroController?action=LIST">Back to List</a>
	</div>
	
	
	</body>

</html>