<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="controladora" action="post" style="text-align: right;">
		${sessionScope.login} <input type="hidden" name="logica" value="Logout">
		<input type="submit" value="Logout">
	</form> <br>
</body>
</html>