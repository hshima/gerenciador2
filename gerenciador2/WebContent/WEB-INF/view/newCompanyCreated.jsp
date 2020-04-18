<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${not empty company}">	Empresa ${company} criada com sucesso!	</c:if>
		<c:if test="${empty company}">		Nenhuma empresa cadastrada!				</c:if>
	</body>
</html>