<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="controladora" method="post">
		Login: <input type="text" name="login"> <br> <br>
		Senha: <input type="text" name="senha"> <br> <br>
		<input type="hidden" name="logica" value="Login">
		<input type="submit" value="Entrar">
	</form>
</body>
</html>