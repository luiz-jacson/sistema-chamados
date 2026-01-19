<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, model.Chamado"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/atualizaChamado" var="linkServletAtualizaChamado"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletAtualizaChamado}" method="POST">
		Título: <input type="text" name="titulo"/>
		<br/>
		Descricao: <input type="area" name="descricao"/>
		<br/>
		Status: <input type="text" name="status"/>
		<br/>
		<input type="submit" value="Criar"> 
	</form>
</body>
</html>