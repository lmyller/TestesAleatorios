<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao-admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu de cadastro</title>
</head>
<body>
	<c:import url="logout.jsp"/>
	<div style="text-align: center;">
		<c:import url="titulo.jsp"></c:import>
		<form action="cadastro-usuario.jsp">
			<input type="submit" value="Cadastrar usuário"> <br> <br>
		</form>
		<form action="cadastro-disciplina.jsp">
			<input type="submit" value="Cadastrar disciplina"> <br> <br>
		</form>
		<form action="cadastro-materia.jsp">
			<input type="submit" value="Cadastrar matéria"> <br> <br>
		</form>
		<form action="cadastro-questao.jsp">
			<input type="submit" value="Cadastrar questão"> <br> <br>
		</form>
	</div>
</body>
</html>