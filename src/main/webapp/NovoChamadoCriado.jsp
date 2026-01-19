<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty titulo}">
 		Empresa ${titulo} cadastrada com sucesso!
 	</c:if>
 	<c:if test="${empty titulo}">
 		Nenhum chamado cadastrado.
 	</c:if>
</body>
</html>