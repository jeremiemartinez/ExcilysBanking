<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Excilys-Banking est un service de banque en ligne développé pour et par EBusinessInformation - Groupe Exclys">
<meta name="author" content="Jeremie Martinez">
<meta name="author" content="Luc Ponnau">

<!-- CSS -->
<link href="/ebank/resources/css/bootstrap.css" rel="stylesheet">
<link href="/ebank/resources/css/flags.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon" href="/ebank/resources/img/favicon.ico">

<title><spring:message code="operations.title" /></title>

<spring:message var="pattern" code="operations.dateFormat" />

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->

</head>
<body>

	<!-- Set locale to format currencies -->
	<fmt:setLocale value="${request.locale}" />

	<!-- Retrieve a UserDetails object from the session and store it under "user" -->
	<security:authentication property="principal" var="user" scope="page" />

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></a> <a class="brand" href="/ebank/index"> <spring:message code="bank.name" /></a>

				<div class="btn-group pull-right">
					<a class="btn" href="/ebank/_change_locale_to_fr"><img class="flag flag-fr" alt="French" /></a> <a class="btn" href="/ebank/_change_locale_to_en"><img class="flag flag-gb" alt="English" /></a> <a class="btn dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> ${user.firstname} ${user.lastname} <span class="caret"></span></a>

					<ul class="dropdown-menu">
						<li><a href="../index"><i class="icon-home"></i>&nbsp; &nbsp; <spring:message code="operations.return" /></a></li>
						<li class="divider"></li>
						<li><a href="/ebank/secured/comptes"><i class="icon-book"></i>&nbsp; &nbsp; <spring:message code="operations.comptes" /></a></li>
						<li class="divider"></li>
						<security:authorize url="/ebank/secured/admin/admin">
							<li><a href="/ebank/secured/admin/admin"><i class="icon-wrench"></i>&nbsp; &nbsp; <spring:message code="operations.adminInterface" /></a></li>
							<li class="divider"></li>
						</security:authorize>
						<li><a href="<c:url value="/j_spring_security_logout"/>"><i class="icon-off"></i>&nbsp; &nbsp; <spring:message code="operations.disconnect" /></a></li>
					</ul>
				</div>
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab"><spring:message code="operations.title" /></a></li>
						<li><a href="/ebank/secured/historiqueVirements/id/${id}"><spring:message code="historique.title" /></a></li>
						<li><a href="/ebank/secured/comptes"> <spring:message code="comptes.return" /></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<h3>
		<spring:message code="operations.subtitle" />
		${id}
		<spring:message code="operations.currentDate" />
		<joda:format value="${requestedMonth}" pattern="MMMM yyyy" locale="${request.locale}" />
		${clientLocale }
	</h3>

	<div class="row-fluid">
		<div class="span2"></div>
		<div class="span8">
			<br />

			<div class="row">
				<div class="span3"></div>
				<div class="span8">
					<ul class="nav nav-pills">
						<c:forEach var="m" items="${months}">
							<c:choose>
								<c:when test="${m == requestedMonth}">
									<li class="active"><a href="/ebank/secured/operations/id/${id}/year/${m.year}/month/${m.monthOfYear}"><joda:format value="${m}" pattern="MMMM yyyy" locale="${request.locale}" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/ebank/secured/operations/id/${id}/year/${m.year}/month/${m.monthOfYear}"><joda:format value="${m}" pattern="MMMM yyyy" locale="${request.locale}" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
				<div class="span3"></div>
			</div>
			<div class="tab-content">
				<div class="tab-pane active" id="tab1">
					<table class="table table-striped">
						<thead>
							<tr>
								<th><spring:message code="operations.operationId" /></th>
								<th><spring:message code="operations.date" /></th>
								<th><spring:message code="operations.compteDestination" /></th>
								<th><spring:message code="operations.type" /></th>
								<th><spring:message code="operations.libelle" /></th>
								<th><spring:message code="operations.montant" /></th>
							</tr>
						</thead>
						<tbody>

							<h3>Page ${currentPage}/${lastPage}</h3>

							<tr>
								<td><button class="btn" data-toggle="collapse" data-target="#operationsCarte" onclick="revealCartes(${year},${month });">
										<spring:message code="operations.details" />
									</button></td>
								<td><spring:message code="operations.carteDate" /></td>
								<td><spring:message code="operations.carteDestination" /></td>
								<td><spring:message code="operations.carteType" /></td>
								<td><spring:message code="operations.carteLibelle" /></td>
								<td><fmt:formatNumber value="${carteSum}" /> $</td>
							</tr>

							<tr>
								<td></td>
								<td colspan=4><div id="operationsCarte" class="collapse">

										<h4>
											Page <span id="cartesPageNumber" />
										</h4>

										<table class="table table-condensed">
											<thead>
												<tr>
													<th><spring:message code="operations.operationId" /></th>
													<th><spring:message code="operations.date" /></th>
													<th><spring:message code="operations.type" /></th>
													<th><spring:message code="operations.libelle" /></th>
													<th><spring:message code="operations.montant" /></th>
												</tr>
											</thead>
											<tbody id="operationsCarteArea">
												<!-- Code will be generated by mustache -->
											<tbody>
										</table>

										<!-- Page navigation buttons -->

										<ul class="pager">
											<li id="cartePagerNext" class="next"><a href="#" id="cartesNewest"><spring:message code="paging.newest" />&rarr;</a> <a href="#" id="cartesNewer"><spring:message code="paging.newer" /></a></li>
											<li id="cartePagerPrevious" class="previous"><a href="#" id="cartesOldest">&larr;<spring:message code="paging.oldest" /></a> <a href="#" id="cartesOlder"><spring:message code="paging.older" /></a></li>
										</ul>

									</div></td>
							</tr>

							<c:forEach var="o" items="${operationsList}">
								<tr>
									<td>${o.id}</td>
									<td><joda:format value="${o.date}" pattern="${pattern}" /></td>
									<td>${o.compteDestination.id}</td>
									<td>${o.type}</td>
									<td>${o.libelle }</td>
									<td><fmt:formatNumber value="${o.montant}" /> $</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<!-- Page navigation buttons -->

					<ul class="pager">
						<c:if test="${currentPage != firstPage}">
							<li class="next"><a href="/ebank/secured/operations/id/${id}/year/${year}/month/${month}/page/${firstPage}"><spring:message code="paging.newest" />&rarr;</a> <a href="/ebank/secured/operations/id/${id}/year/${year}/month/${month}/page/${previousPage}"><spring:message code="paging.newer" /></a></li>
						</c:if>
						<c:if test="${currentPage != lastPage}">
							<li class="previous"><a href="/ebank/secured/operations/id/${id}/year/${year}/month/${month}/page/${lastPage}">&larr;<spring:message code="paging.oldest" /></a> <a href="/ebank/secured/operations/id/${id}/year/${year}/month/${month}/page/${nextPage}"><spring:message code="paging.older" /></a></li>
						</c:if>
					</ul>

				</div>
			</div>
		</div>
		<div class="span2"></div>
	</div>

	<c:import url="../included/footer.jsp"></c:import>

	<!-- Javascript -->
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>
	<script src="/ebank/resources/js/bootstrap.js"></script>
	<script src="/ebank/resources/js/handlebars.js"></script>
	<script src="/ebank/resources/js/operationsCarte.js"></script>

	<!-- Template Handlebars/Moustache -->
	<script id="operationTpl" type="text/template">
		{{#.}}
			<tr>
				<td>{{id}}</td>
				<td>{{date}}</td>
				<td>{{type}}</td>
				<td>{{libelle}}</td>
				<td>{{montant}} $</td>
			</tr>
		{{/.}}
	</script>
</body>
</html>