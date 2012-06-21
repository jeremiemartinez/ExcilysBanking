<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
</head>
<body>

	<h3>Authentifiez-vous</h3>

	<c:if test="${not empty errorLogin}">Error: The username or password you entered is incorrect.</c:if>
	<c:if test="${not empty errorTooManySessions}">Error: Sorry too many sessions.</c:if>
	<c:if test="${not empty errorSessionTimeOut}">Error: Sorry your session timed out.</c:if>

	<form action="<c:url value='j_spring_security_check' />" method='POST'>

		<table>
			<tr>
				<td>Nom d'utilisateur :</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Accéder aux comptes" /></td>
			</tr>
		</table>
	</form>


</body>
</html>