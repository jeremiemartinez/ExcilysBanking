<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Excilys-Banking est un service de banque en ligne développé pour et par EBusinessInformation - Groupe Exclys">
<meta name="author" content="Jeremie Martinez">
<meta name="author" content="Luc Ponnau">
<!-- Le styles -->
<link href="/ebank/resources/css/bootstrap.css" rel="stylesheet">
<link href="/ebank/resources/css/flags.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="/ebank/resources/img/favicon.ico">
<title><spring:message code="bank.name" /></title>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- Le fav and touch icons -->

</head>
<body>


	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
			
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="#"><spring:message code="bank.name" /></a>
				
				<div class="btn-group pull-right">
					<a class="btn" href="_change_locale_to_fr"><img class="flag flag-fr" alt="French" /></a>
					<a class="btn" href="_change_locale_to_en"><img class="flag flag-gb" alt="English" /></a>
					<a class="btn" href="#moduleConnection"> <i class="icon-user"></i> <spring:message code="index.connect" /> &nbsp; </a>
				</div>

			</div>
		</div>
	</div>

	<div class="row-fluid">
		<div class="span4"></div>
		<div class="span4">
			<br />
			<div class="well">
				<h3 id="moduleConnetion" class="center">
					<spring:message code="index.title" />
				</h3>
				<hr>
				<form class="form-horizontal"
					action="<c:url value='j_spring_security_check' />" method='POST'>
					<c:if test="${not empty errorLogin}">
						<div class="alert alert-error">
							<strong><spring:message code="index.error" /></strong>
							<spring:message code="index.errorLogin" />
						</div>
					</c:if>
					<c:if test="${not empty errorTooManySessions}">
						<div class="alert alert-error">
							<strong><spring:message code="index.error" /></strong>
							<spring:message code="index.errorTooManySessions" />
							.
						</div>
					</c:if>
					<c:if test="${not empty errorSessionTimeOut}">
						<div class="alert alert-error">
							<strong><spring:message code="index.error" /></strong>
							<spring:message code="index.errorTimedOut" />
						</div>
					</c:if>

					<div class="control-group">
						<label class="control-label" class="span6" for="j_username">
							<spring:message code="index.username" />
						</label>
						<div class="controls">
							<input type="text" class="span8" name='j_username'
								placeholder="Nom d'utilisateur">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" class="span6" for="j_password">
							<spring:message code="index.password" />
						</label>
						<div class="controls">
							<input type="password" class="span8" name='j_password'
								placeholder="Mot de passe">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"> <spring:message
								code="index.rememberMe" />
						</label>
						<div class="controls">
							<input type='checkbox' name='_spring_security_remember_me' />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">
								<spring:message code="index.connect" />
							</button>
						</div>
					</div>


				</form>

			</div>

		</div>
		<div class="span4"></div>
	</div>

	<c:import url="./included/footer.jsp"></c:import>

	<!-- Javascript -->
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>
	<script src="/ebank/resources/js/bootstrap.js"></script>

</body>
</html>