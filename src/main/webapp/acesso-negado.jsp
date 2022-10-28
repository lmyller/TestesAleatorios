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
	<form action="menu-principal.jsp">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>