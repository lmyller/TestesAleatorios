<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao-admin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout.jsp"/>
	<div style="text-align: center;">
		<c:import url="titulo.jsp"/>
		<form action="controladora" method="post">
			Questão: <input type="text" name="questao"> <br> <br>
			resposta: <input type="text" name="resposta"> <br> <br>
			
			<jsp:useBean id="daodisciplina" class="myller.tsi.daw.tp1.dao.DisciplinaDAO"/>
			
			<c:forEach var="disciplina" items="${daodisciplina.listaDisciplinas()}">
				<input type="radio" name="iddisciplina" value="${disciplina.idDisciplina}"> 
				<label>${disciplina.nomeDisciplina}</label>
			</c:forEach>
			<br> <br>
			
			<jsp:useBean id="daomateria" class="myller.tsi.daw.tp1.dao.MateriaDAO"/>
			
			<c:forEach var="materia" items="${dao.listaMaterias()}">
				<input type="radio" name="idmateria" value="${materia.idMateria}"> 
				<label>${materia.nomeMateria}</label>
			</c:forEach>
			<br> <br>
			<input type="hidden" name="logica" value="CadastrarQuestao">
			<input type="submit" value="Cadastrar questao">
		</form>
	</div>
</body>
</html>