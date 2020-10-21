<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir animal</title>
</head>
<body>
	<p>${message}</p>
	<form action="${pageContext.request.contextPath}/deleta" method="POST">
		<fieldset>
			<label for="Id">
				Digite a identificação do Animal para deletar:
			</label>
			<input type="number" name="identificacao" id="Id">
		</fieldset>
		<br>
		<br>
		<input type="submit" value="Clique para deletar um animal">
	</form>
</body>
</html>