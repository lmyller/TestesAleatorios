<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Usuário ${requestScope.login} não está cadastrado</h2>
	<form action="login.jsp">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>