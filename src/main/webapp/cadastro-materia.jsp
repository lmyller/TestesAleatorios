<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao-admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Matrícula</title>
</head>
<body>
	<c:import url="logout.jsp"/>
	<div style="text-align: center;">
		<c:import url="titulo.jsp"/>
		<form action="controladora" method="post">
			Nome da matéria: <input type="text" name="nome"> <br> <br>
			Série: <input type="number" name="serie"> <br> <br>
			
			<jsp:useBean id="dao" class="myller.tsi.daw.tp1.dao.DisciplinaDAO"/>
			
			<c:forEach var="disciplina" items="${dao.listaDisciplinas()}">
				<input type="radio" name="iddisciplina" value="${disciplina.idDisciplina}"> 
				<label>${disciplina.nomeDisciplina}</label>
			</c:forEach>
			<br> <br>
			<input type="hidden" name="logica" value="CadastrarMateria">
			<input type="submit" value="Cadastrar matéria">
		</form>
	</div>
</body>
</html>