<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.animal.beans.Animal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Animais</title>
</head>
<body>
	<%
		ArrayList<Animal> listaResultado = (ArrayList<Animal>)request.getAttribute("listaResul");
	%>
	<table border="1">
		<tr bgcolor="#eaeaea">
			<th>ID</th>
			<th>Especie</th>
			<th>Nome</th>
			<th>Peso</th>
		</tr>
	<%
		for(Animal a:listaResultado){
	%>
		<tr>
			<th><%=a.getIdentificacao()%></th>
			<th><%=a.getEspecieAnimal()%></th>
			<th><%=a.getNomeAnimal()%></th>
			<th><%=a.getPeso()%></th>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>