<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="entry?action=NewEnterpriseForm" var="cadastrar" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table border=1>
			<thead>
					List of Enterprises
				<tr>
					<td>Name</td>
					<td>Begin of transactioning</td>
					<td>Edit</td>
					<td>Remove</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${companies}" var="company">
					<tr>
						<td>${company.nome }</td>
						<td><fmt:formatDate value="${company.dateOpen}" pattern="dd/MM/yyyy" /></td>
<%-- 						<td><a value="Edit" href="/gerenciador2/entry?action=showEnterprise&id=${company.id}" >Edit</a></td> --%>
<%-- 					 	<td><a value="Remove" href="/gerenciador2/entry?action=removeEnterprise&id=${company.id}" >Remove</a></td> --%>
						<td><a href="entry?id=${company.id}&action=ShowEnterprise">Edit</a></td>
						<td><a href="entry?id=${company.id}&action=DeleteCompany">Delete</a></td>
				 	</tr>
			 	</c:forEach>
			 	<br />
			 	<form action="${cadastrar}" method="post">
				 	<td>Nova Empresa</td>
				 	<td><input type="submit" value="Cadastrar" ></td>
			 	</form>
			</tbody>
		</table>
	</body>
</html>