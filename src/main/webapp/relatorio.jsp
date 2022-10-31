<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="autenticacao.jsp" %>
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
		
		<jsp:useBean id="testedao" class="myller.tsi.daw.tp1.dao.TesteDAO"/>
		
		<table border="2px">
			<tr>
				<th>Id Teste</th>
				<th>Data</th>
				<th>Número de acertos</th>
			</tr>
			<c:forEach var="teste" items="${testedao.listaTestes()}">
				<tr>
					<td>${teste.idTeste}</td>
					<td>
						<fmt:formatDate value="${teste.dataTeste.time}" pattern="dd/MM/yyyy"/> 
					</td>
					<td>${teste.numeroAcerto}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="menu-teste.jsp">
			<input type="submit" value="Voltar">
		</form>
	</div>
</body>
</html>