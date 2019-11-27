<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Creación de productoras</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
	
		<div class = "container">
	
		<h1>Productor directory</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/ProductoraController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "nombre" placeholder = "Introduzca nombre" value = "${productora.nombre}"/>
					</div>
				
					<div class = "form-group">
						<input type = "number" class = "form-control" name = "inversion_inicial" placeholder = "Introduzca inversión inicial" value = "${productora.inversionInicial}"/>
					</div>
					
					<div class = "form-group">
						<input type = "number" class = "form-control" name = "ganancias" placeholder = "Introduzca ganancias" value = "${productora.ganancias}"/>
					</div>
					
					<div class = "form-group">
						<input type = "number" class = "form-control" name = "ganancias_totales" placeholder = "Introduzca ganancias totales" value = "${productora.gananciasTotales}"/>
					</div>
					
					
				
					
				
					<input type = "hidden" name = "id_productora" value = "${productora.id_productora}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/ProductoraController?action=LIST">Back to List</a>
	</div>
	
	
	</body>

</html>