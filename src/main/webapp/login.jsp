<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div style="text-align: center">
		<c:import url="titulo.jsp"/>
		<form action="controladora" method="post">
			Login: <input type="text" name="login"> <br> <br>
			Senha: <input type="password" name="senha"> <br> <br>
			<input type="hidden" name="logica" value="Login">
			<input type="submit" value="Entrar">
		</form>
	</div>
</body>
</html>