<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entry?action=EditCompany" var="edit" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alter Company Form</title>
</head>
<body>
	<form action="${edit}" method="post">
		<table border=1>
			<thead>Form of company changes</thead>
			<tbody>
				<tr>
					<td>Company</td>
					<td><input type="text" name="nome" value="${company.nome}" /></td>
				</tr>
				<tr>
					<td>Begining of operation</td>
					<td><input type="text" name="date" value="<fmt:formatDate value="${company.dateOpen }" pattern="dd/MM/yyyy" />" /></td>
				</tr>
				<tr>
					<td>id</td>
					<td><input type="hidden" value=${company.id} name="id" /></td>
				</tr> 
				<tr>
					<td><input type="submit" value="enviar" / ></td>
				</tr>
					
			</tbody>
		</table>
	</form>
</body>
</html>