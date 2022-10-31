<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao-admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Disciplina</title>
</head>
<body>
	<c:import url="logout.jsp"/>
	<div style="text-align: center;">
		<c:import url="titulo.jsp"/>
		<form action="controladora" method="post">
			Nome da disciplina: <input type="text" name="nome">
			<input type="hidden" name="logica" value="CadastrarDisciplina">
			<input type="submit" value="Cadastrar disciplina">
		</form>
	</div>
</body>
</html>