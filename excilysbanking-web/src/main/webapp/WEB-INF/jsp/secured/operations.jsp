<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
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
<title><spring:message code="operations.title" /></title>
<spring:message var="pattern" code="operations.dateFormat" />


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
				</a> <a class="brand" href="../index"><spring:message
						code="bank.name" /></a>
				<div class="btn-group pull-right">
					<a class="btn" href="/ebank/_change_locale_to_fr"><img
						class="flag flag-fr" alt="French" /></a> <a class="btn"
						href="/ebank/_change_locale_to_en"><img class="flag flag-gb"
						alt="English" /></a> <a class="btn dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-user"></i> ${firstname} ${lastname} <span
						class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="../index"><i class="icon-home"></i>&nbsp;
								&nbsp; <spring:message code="operations.return" /></a></li>
						<li class="divider"></li>
						<li><a href="/ebank/secured/comptes"><i class="icon-book"></i>&nbsp;
								&nbsp; <spring:message code="operations.comptes" /></a></li>
						<li class="divider"></li>
						<c:if test="${not empty isAdmin}">
							<li><a href="/ebank/secured/admin/admin"><i class="icon-wrench"></i>&nbsp;
									&nbsp; <spring:message code="operations.adminInterface" /></a></li>
							<li class="divider"></li>
						</c:if>
						<li><a href="<c:url value="/j_spring_security_logout"/>"><i
								class="icon-off"></i>&nbsp; &nbsp; <spring:message
									code="operations.disconnect" /></a></li>
					</ul>
				</div>
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab"><spring:message
									code="operations.title" /></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<h3>
		<spring:message code="operations.subtitle" />
		${id}
	</h3>
	<div class="row-fluid">
		<div class="span1"></div>
		<div class="span1">
			<a class="btn btn-primary"
				href="/ebank/secured/operations/${id}/${previousDate}/"><spring:message
					code="operations.previousMonth" /></a>

		</div>
		<div class="span8">
			<br />
			<div class="tab-content">
				<div class="tab-pane active" id="tab1">
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="operations.operationId" /></th>
								<th><spring:message code="operations.date" /></th>
								<th><spring:message code="operations.type" /></th>
								<th><spring:message code="operations.libelle" /></th>
								<th><spring:message code="operations.montant" /></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td><button class="btn" data-toggle="collapse"
										data-target="#operationsCarte"><spring:message code="operations.details"/></button></td>
								<td><spring:message code="operations.carteDate" /></td>
								<td><spring:message code="operations.carteType" /></td>
								<td><spring:message code="operations.carteLibelle" /></td>
								<td>${carteSum} $</td>
							</tr>



							<tr>
								<td></td>
								<td colspan=4><div id="operationsCarte" class="collapse">
										<table class="table  table-condensed">
											<thead>
												<tr>
													<th><spring:message code="operations.operationId" /></th>
													<th><spring:message code="operations.date" /></th>
													<th><spring:message code="operations.type" /></th>
													<th><spring:message code="operations.libelle" /></th>
													<th><spring:message code="operations.montant" /></th>
												</tr>
											</thead>
											<c:forEach var="oc" items="${operationsCarteList}">
												<tr>
													<td>${oc.operation_id}</td>
													<td><joda:format value="${oc.date}"
															pattern="${pattern}" /></td>
													<td>${oc.type}</td>
													<td>${oc.libelle }</td>
													<td>${oc.montant} $</td>
												</tr>
											</c:forEach>
										</table>

									</div></td>
							</tr>

							<c:forEach var="o" items="${operationsList}">
								<tr>
									<td>${o.operation_id}</td>
									<td><joda:format value="${o.date}" pattern="${pattern}" /></td>
									<td>${o.type}</td>
									<td>${o.libelle }</td>
									<td>${o.montant} $</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="span1">
			<c:if test="${not empty laterDate }">
				<a class="btn btn-primary"
					href="/ebank/secured/operations/${id}/${laterDate}/"><spring:message
						code="operations.laterMonth" /></a>
			</c:if>
		</div>
		<div class="span1"></div>
	</div>

	<c:import url="../included/footer.jsp"></c:import>

	<!-- Javascript -->
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>
	<script src="/ebank/resources/js/bootstrap.js"></script>

</body>
</html>