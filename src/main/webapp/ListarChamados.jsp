<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, model.Chamado"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach items="${chamados}" var="chamado"> 
			<li>${chamado.titulo}</li>
			<li>${chamado.descricao}</li>
			<button onclick="deletar(${chamado.id})">Excluir</button>
			<button onclick="atualizar(${chamado.id})">Atualizar</button>
			<br/>
		</c:forEach>

	</ul>


</body>

<script>
function deletar(id) {
    fetch('chamado?id=' + id, {
        method: 'DELETE'
    }).then(() => {
        location.reload();
    });
}
</script>
</html>

