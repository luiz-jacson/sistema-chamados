<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,dominio.Chamado"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/deletaChamado" var="linkServletDeletaChamado"/>
<c:url value = "/atualizaChamado" var="linkServletAtualizaChamado"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${chamados}" var="chamado">
			<form method="get">
			 	<input type="hidden" name="id" value="${chamado.id}">
			 	<input type="hidden" name="titulo" value="${chamado.titulo}">
			 	<input type="hidden" name="descricao" value="${chamado.descricao}">
			 	<input type="hidden" name="status" value="${chamado.status}">
				<li>${chamado.titulo}</li>
				<li>${chamado.descricao}</li>
				<button formaction="${linkServletDeletaChamado}">Excluir</button>
				<button formaction="${linkServletAtualizaChamado}">Atualizar</button>
				<br />
			</form>
		</c:forEach>

	</ul>


</body>

</html>

