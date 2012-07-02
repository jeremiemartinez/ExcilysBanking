<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title><spring:message code="comptes.title" /></title>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->

</head>
<body>

	<!-- Retrieve a UserDetails object from the session and store it under "user" -->
	<security:authentication property="principal" var="user" scope="page" />

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/ebank/index"><spring:message
						code="bank.name" /></a>

				<div class="btn-group pull-right">

					<a class="btn" href="/ebank/_change_locale_to_fr"><img
						class="flag flag-fr" alt="French" /></a> <a class="btn"
						href="/ebank/_change_locale_to_en"><img class="flag flag-gb"
						alt="English" /></a> <a class="btn dropdown-toggle"
						data-toggle="dropdown"><i class="icon-user"></i>${user.firstname}
						${user.lastname}<span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="../index"><i class="icon-home"></i>&nbsp;
								&nbsp;<spring:message code="comptes.return" /></a></li>

						<li class="divider"></li>

						<c:if test="${not empty isAdmin}">
							<li><a href="/ebank/secured/admin/admin"><i
									class="icon-wrench"></i>&nbsp; &nbsp; <spring:message
										code="comptes.adminInterface" /></a></li>
							<li class="divider"></li>
						</c:if>

						<li><a href="<c:url value="/j_spring_security_logout"/>"><i
								class="icon-off"></i>&nbsp; &nbsp;<spring:message
									code="comptes.disconnect" /></a></li>

					</ul>
				</div>

				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab"> <spring:message
									code="comptes.title" />
						</a></li>
						<li><a href="/ebank/secured/virement"> Virements </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>



	<div class="row-fluid">
		<div class="span2"></div>
		<div class="span8">
			<br />
			<div class="tab-content">
				<div class="tab-pane active" id="tab1">
					<h3>
						<spring:message code="comptes.title" />
					</h3>
					<c:if test="${not empty param.virementSucceed}">
						<div class="row">
							<div class="span4"></div>
							<div class="span4">

								<div class="alert alert-success">
									<strong><spring:message code="comptes.successTitle" /></strong>
									<spring:message code="comptes.success" />
								</div>

							</div>
							<div class="span4"></div>
						</div>
					</c:if>
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="comptes.compteId" /></th>
								<th><spring:message code="comptes.compteType" /></th>
								<th><spring:message code="comptes.compteSolde" /></th>
								<th><spring:message code="comptes.details" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${comptesList}">
								<tr>
									<td>${c.id}</td>
									<td>${c.type}</td>
									<td>${c.solde} $</td>
									<td><a
										href="./operations/id/${c.id}/year/${year}/month/${month}">
											<spring:message code="comptes.operations" />
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<div class="span2"></div>
	</div>

	<c:import url="../included/footer.jsp"></c:import>

	<!-- Javascript -->
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>
	<script src="/ebank/resources/js/bootstrap.js"></script>

</body>
</html>