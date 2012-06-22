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
<link href="../../css/bootstrap.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="../../img/favicon.ico">
<script src="../../js/jquery-1.7.2.js"></script>
<script src="../../js/bootstrap.js"></script>
<title><spring:message code="admin.title"/></title>

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
				</a> <a class="brand" href="/ebank/index.html"><spring:message code="bank.name"/></a>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i> ${name} <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="../../index.html"><i class="icon-home"></i>&nbsp;
								&nbsp; <spring:message code="admin.return"/></a></li>
						<li class="divider"></li>
						<li><a href="../comptes.html"><i class="icon-user"></i>&nbsp;
								&nbsp; <spring:message code="admin.userInterface"/></a>
						<li class="divider"></li>
						<li><a href="<c:url value="/j_spring_security_logout"/>"><i
								class="icon-off"></i>&nbsp; &nbsp; <spring:message code="admin.disconnect"/></a></li>
					</ul>
				</div>
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab"><spring:message code="admin.users"/></a></li>
						<li><a href="#tab2" data-toggle="tab"><spring:message code="admin.comptes"/></a></li>
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
					<h3><spring:message code="admin.usersList"/></h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="admin.username"/></th>
								<th><spring:message code="admin.firstname"/></th>
								<th><spring:message code="admin.lastname"/></th>
								<th><spring:message code="admin.authorities"/></th>
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
					<h3><spring:message code="admin.comptesList"/></h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="admin.compteId"/></th>
								<th><spring:message code="admin.compteType"/></th>
								<th><spring:message code="admin.compteSolde"/></th>
								<th><spring:message code="admin.username"/></th>
								<th><spring:message code="admin.fullname"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${comptesList}">
								<tr>
									<td>${c.compte_id}</td>
									<td>${c.type}</td>
									<td>${c.solde}</td>
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
	<hr>

	<footer>
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<img class="pull-left" src="../../img/excilys.jpeg" /> <br /> <img
					class="pull-right" src="../../img/ebi.png" /> <br />
				<p class="shiftToRight">&copy; <spring:message code="footer.companyName"/></p>
				<p class="shiftToRight">
					<i class="icon-wrench"></i><spring:message code="footer.developper"/><a
						href="mailto:jmartinez@excilys.com">Jérémie Martinez</a> &amp; <a
						href="mailto:lponnau@excilys.com">Luc "Bizu" Ponnau</a>
			</div>
			<div class="span1"></div>
		</div>
	</footer>
</body>
</html>