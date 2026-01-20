<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, model.Chamado"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/deletaChamado" var="linkServletDeletaChamado"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${chamados}" var="chamado">
			<form method="post">
			 	<input type="hidden" name="id" value="${chamado.id}">
				<li>${chamado.titulo}</li>
				<li>${chamado.descricao}</li>
				<button formaction="${linkServletDeletaChamado}">Excluir</button>
				<button formaction="">Atualizar</button>
				<br />
			</form>
		</c:forEach>

	</ul>


</body>

</html>

