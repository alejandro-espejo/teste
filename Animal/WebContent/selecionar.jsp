<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<p>${message}</p>
		<form action="${pageContext.request.contextPath}/seleciona" method="POST">
			<table>
				<tr>
					<td>Entre com o ID que deseja procurar:</td>
					<td> <input type="text" name="identificacao"> </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit"name="Procurar"> </td>
				</tr>
			</table>
		</form>
	</div>
	<a href="index.jsp"> Clique aqui para voltar para a index</a>
</body>
</html>