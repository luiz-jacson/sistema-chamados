<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,dominio.Chamado"%>
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
		<input type="hidden" name="id" value="${chamado.id}">
		Título: <input type="text" name="titulo" value="${chamado.titulo}"/>
		<br/>
		Descricao: <input type="area" name="descricao" value="${chamado.descricao}"/>
		<br/>
		Status: <input type="text" name="status" value ="${chamado.status}"/>
		<br/>
		<input type="submit" value="Criar"> 
	</form>
</body>
</html>