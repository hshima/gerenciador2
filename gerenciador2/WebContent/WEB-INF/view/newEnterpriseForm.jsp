<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entry?action=NewCompany" var="linkNewEnterprise" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action=${linkNewEnterprise } method="post">
		<table>
			<tbody>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="company" placeholder="Nome da empresa" /></td>
				</tr>
				<tr>
					<td>Data de Abertura:</td>
					<td><input type="text" name="date" placeholder="Data Abertura" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="submit" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>