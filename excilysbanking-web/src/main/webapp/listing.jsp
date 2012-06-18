<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listing</title>
</head>
<body>

	<h3>Listing all users for user: ${nameCaller}</h3>

	<table>
		<c:forEach var="u" items="${listAllUsers}">
			<tr>
				<td>${u.login}</td>
				<td>${u.name}</td>
				<td>${u.phone}</td>
				<td>${u.nationality}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>