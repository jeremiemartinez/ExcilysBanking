<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Excilys-Banking est un service de banque en ligne développé pour et par EBusinessInformation - Groupe Exclys">
<meta name="author" content="Jeremie Martinez">
<meta name="author" content="Luc Ponnau">

<!-- CSS -->
<link href="/ebank/resources/css/bootstrap.css" rel="stylesheet">
<link href="/ebank/resources/css/flags.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon" href="/ebank/resources/img/favicon.ico">

<title><spring:message code="comptes.title" /></title>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->

</head>
<body>

	<!-- Set locale to format currencies -->
	<fmt:setLocale value="${request.locale}"/>

	<!-- Retrieve a UserDetails object from the session and store it under "user" -->
	<security:authentication property="principal" var="user" scope="page" />

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">

				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
				<a class="brand" href="/ebank/index"><spring:message code="bank.name" /></a>

				<div class="btn-group pull-right">

					<a class="btn" href="/ebank/_change_locale_to_fr"><img class="flag flag-fr" alt="French" /></a> <a class="btn" href="/ebank/_change_locale_to_en"><img class="flag flag-gb" alt="English" /></a>
					<a class="btn dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i>${user.firstname} ${user.lastname}<span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="../index"><i class="icon-home"></i>&nbsp; &nbsp;<spring:message code="comptes.return" /></a></li>

						<li class="divider"></li>

						<security:authorize ifAnyGranted="ROLE_ADMIN">
							<li><a href="/ebank/secured/admin/admin"><i class="icon-wrench"></i>&nbsp; &nbsp; <spring:message code="comptes.adminInterface" /></a></li>
							<li class="divider"></li>
						</security:authorize>

						<li><a href="<c:url value="/j_spring_security_logout"/>"><i class="icon-off"></i>&nbsp; &nbsp;<spring:message code="comptes.disconnect" /></a></li>

					</ul>
				</div>

				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li><a href="/ebank/secured/comptes"> <spring:message  code="comptes.title" /></a></li>
						<li class="active"><a href="#tab2" data-toggle="tab"><spring:message code="virements.title"/></a>
					</ul>
				</div>
			</div>
		</div>
	</div>



	<div class="row-fluid">
		<div class="span4"></div>
		<div class="span4">
			<br />
			<div class="tab-content">
				<div class="tab-pane active" id="tab2">
				
					<h3><spring:message code="virements.title"/></h3>
					<br />
					
					<h3><form:errors class="label label-important" path="virementForm" /></h3>
					<br/>
					
					<form:form class="form-horizontal" commandName="virementForm"
						method='POST'>

						<div class="control-group">
							<label class="control-label span6" for="compteDebit"><spring:message code="virements.compteDebit"/> &nbsp; &nbsp;<form:errors class="label label-important" path="compteDebit" /></label>
							<div class="controls">
								<form:select class="span10" id="compteDebit" path="compteDebit">
									<c:forEach var="c" items="${comptesList}">
										<form:option value="${c.id}"><spring:message code="virements.compte"/> <strong>${c.id}</strong> &nbsp; &nbsp; <spring:message code="virements.solde"/> <strong><fmt:formatNumber value="${c.solde}"/> $</strong></form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label span6"><spring:message code="virements.compteCredit"/> &nbsp; &nbsp;<form:errors class="label label-important" path="compteCredit" /></label>
							<div class="controls">
								<form:select class="span10" id="compteCredit"
									path="compteCredit">
									<c:forEach var="c" items="${comptesList}">
										<form:option value="${c.id}"><spring:message code="virements.compte"/><strong>${c.id}</strong> ;&nbsp; &nbsp; <spring:message code="virements.solde"/> <strong><fmt:formatNumber value="${c.solde}"/> $</strong></form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label span6"><spring:message code="virements.libelle"/> &nbsp; &nbsp;<form:errors class="label label-important" path="libelle" /></label>
							<div class="controls">
								<form:input type='text' class="span10" name='libelle' path="libelle" />

							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label span6"><spring:message code="virements.montant"/> &nbsp; &nbsp;<form:errors class="label label-important" path="montant" /></label>
							<div class="controls">
								<form:input type='text' class="span10" name='montant' path="montant" />
							</div>
						</div>
						

						<div class="control-group">
							<div class="controls">
								<form:button type="submit" class="btn btn-primary"><spring:message code="virements.process"/></form:button>
							</div>
						</div>

					</form:form>

				</div>
			</div>
		</div>
		<div class="span4"></div>
	</div>

	<!-- Footer -->
	<c:import url="../included/footer.jsp"></c:import>

	<!-- Javascript -->
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>
	<script src="/ebank/resources/js/bootstrap.js"></script>

</body>
</html>