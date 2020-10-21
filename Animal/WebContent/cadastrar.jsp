<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar um animal"</title>
</head>
<body>
	<p>${message}</p>
	<form action="${pageContext.request.contextPath}/registra" method="POST">
		<label for="especieAnimal">
				Digite a Especie do Animal:
		</label>
		<input type="text" name="especieAnimal" id="especieAnimal"><br><br>
		
		<label for="nomeAnimal">
				Digite o nome do Animal:
		</label>
		<input type="text" name="nomeAnimal" id="nomeAnimal"><br><br>
		
		<label for="peso">
				Digite o peso do Animal:
		</label>
		<input type="text" name="peso" id="peso"><br><br>
		
		<input type="submit" value="Clique para cadastrar um animal">
	</form>
</body>
</html>