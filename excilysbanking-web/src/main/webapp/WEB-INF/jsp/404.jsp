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
<link href="/ebank/css/bootstrap.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon" href="/ebank/img/favicon.ico">
<script src="/ebank/js/jquery-1.7.2.js"></script>
<script src="/ebank/js/bootstrap.js"></script>
<title><spring:message code="error.title404"/></title>

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
				</a> <a class="brand" href="index.html"><spring:message code="bank.name"/></a>
				<div class="btn-group pull-right">
					<a class="btn" href="/ebank/index.html"> <i class="icon-home"></i>
						Index &nbsp;
					</a>
				</div>

			</div>
		</div>
	</div>

	<div class="row-fluid">
		<div class="span4"></div>
		<div class="span4">
			<br />
			<div class="hero-unit">
				<h1><spring:message code="error.name404"/></h1>
				<br />
				<p>
					<i class="icon-info-sign"></i> <spring:message code="error.description404"/>
				</p>
				<br />
				<p><a class="btn btn-primary btn-large" href="/ebank/index.html"><spring:message code="error.return"/> &raquo;</a></p>
			</div>
		</div>
		<div class="span4"></div>
	</div>

	<hr>

	<footer>
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<img class="pull-left" src="/ebank/img/excilys.jpeg" /> <br /> <img
					class="pull-right" src="/ebank/img/ebi.png" /> <br />
				<p class="shiftToRight">&copy; <spring:message code="footer.companyName"/></p>
				<p class="shiftToRight">
					<i class="icon-wrench"></i> &nbsp;<spring:message code="footer.developper"/> <a
						href="mailto:jmartinez@excilys.com">Jérémie Martinez</a> &amp; <a
						href="mailto:lponnau@excilys.com">Luc Ponnau</a>
			</div>
			<div class="span1"></div>
		</div>
	</footer>

</body>
</html>