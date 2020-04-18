<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entry" var="linkEntry" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action=${linkEntry} method="post">
		<table>
			<tbody>
				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" placeholder="login" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" placeholder="password" /></td>
				</tr>
				<tr>
					<td />
					<td><input type="hidden" name="action" value="Login"></td>
					<td><input type="submit" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>