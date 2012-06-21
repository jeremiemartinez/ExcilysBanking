<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administration</title>
</head>
<body>

<h2> Bienvenue ôh grand maître !</h2>

<a href="<c:url value="/j_spring_security_logout" />">Déconnexion</a>


<h3>Liste de tout les utilisateurs</h3>

	<table>
		<c:forEach var="u" items="${usersList}">
			<tr>
				<td>${u.username}</td>
				<td>${u.firstname} ${u.lastname}</td>
				<td><c:forEach var="a" items="${u.authorities}">
					${a.authority} 
				</c:forEach></td>
			</tr>
		</c:forEach>
	</table>

<h3>Liste de tout les comptes</h3>

	<table>
		<c:forEach var="c" items="${comptesList}">
			<tr>
				<td>${c.compte_id}</td>
				<td>${c.type}</td>
				<td>${c.solde}</td>
				<td>${c.user.username}</td>
				<td>${c.user.firstname} ${c.user.lastname}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>