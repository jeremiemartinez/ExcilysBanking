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
<title><spring:message code="admin.title" /></title>

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
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="/ebank/index.html"><spring:message
						code="bank.name" /></a>
				<div class="btn-group pull-right">
					<a class="btn" href="/ebank/_change_locale_to_fr"><img
						class="flag flag-fr" alt="French" /></a> <a class="btn"
						href="/ebank/_change_locale_to_en"><img class="flag flag-gb"
						alt="English" /></a> <a class="btn dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-user"></i> ${name} <span
						class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="../../index"><i class="icon-home"></i>&nbsp;
								&nbsp; <spring:message code="admin.return" /></a></li>
						<li class="divider"></li>
						<li><a href="../comptes"><i class="icon-user"></i>&nbsp;
								&nbsp; <spring:message code="admin.userInterface" /></a>
						<li class="divider"></li>
						<li><a href="<c:url value="/j_spring_security_logout"/>"><i
								class="icon-off"></i>&nbsp; &nbsp; <spring:message
									code="admin.disconnect" /></a></li>
					</ul>
				</div>
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab"><spring:message
									code="admin.users" /></a></li>
						<li><a href="#tab2" data-toggle="tab"><spring:message
									code="admin.comptes" /></a></li>
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
						<spring:message code="admin.usersList" />
					</h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="admin.username" /></th>
								<th><spring:message code="admin.firstname" /></th>
								<th><spring:message code="admin.lastname" /></th>
								<th><spring:message code="admin.authorities" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="u" items="${usersList}">
								<tr>
									<td>${u.username}</td>
									<td>${u.firstname}</td>
									<td>${u.lastname}</td>
									<td><c:forEach var="a" items="${u.authorities}">
											${a.authority} 
										</c:forEach></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="tab2">
					<h3>
						<spring:message code="admin.comptesList" />
					</h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="admin.compteId" /></th>
								<th><spring:message code="admin.compteType" /></th>
								<th><spring:message code="admin.compteSolde" /></th>
								<th><spring:message code="admin.username" /></th>
								<th><spring:message code="admin.fullname" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${comptesList}">
								<tr>
									<td>${c.compte_id}</td>
									<td>${c.type}</td>
									<td>${c.solde} $</td>
									<td>${c.user.username}</td>
									<td>${c.user.firstname} ${c.user.lastname}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="span2"></div>
		</div>
	</div>

	<c:import url="../../included/footer.jsp"></c:import>

	<!-- Javascript -->
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>
	<script src="/ebank/resources/js/bootstrap.js"></script>

</body>
</html>