<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu de teste</title>
</head>
<body>
	<c:import url="logout.jsp"></c:import>
	<div style="text-align: center;">
		<c:import url="titulo.jsp"></c:import>
		<form action="teste.jsp">
			<input type="submit" value="Gerar teste"> <br> <br>
		</form>
		<form action="relatorio.jsp">
			<input type="submit" value="Gerar relatório">
		</form>
	</div>
</body>
</html>