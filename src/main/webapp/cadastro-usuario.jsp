<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao-admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro usuário</title>
</head>
<body>
	<form action="controladora" action="post">
		Nome: <input type="text" name="nome"> <br> <br>
		Senha: <input type="text" name="senha"> <br> <br>
		Perfil: <input type="radio" name="perfil" value="user"> 
				<label>Usuário</label>
				<input type="radio" name="perfil" value="admin"> 
				<label>Admin</label><br> <br>
		<input type="hidden" name="logica" value="CadastrarUsuario">
		<input type="submit" value="Cadastrar Usuario">
	</form>
</body>
</html>