<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Acesso não autorizado ao usuário ${sessionScope.login}</h2>
	<c:choose >
		<c:when test="${sessionScope.perfil == admin}">
			<form action="menu-cadastro.jsp">
				<input type="submit" value="Voltar">
			</form>
		</c:when>
		<c:otherwise>
			<form action="menu-teste.jsp">
				<input type="submit" value="Voltar">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>