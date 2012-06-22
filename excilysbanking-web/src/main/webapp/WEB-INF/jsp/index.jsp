<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="./css/bootstrap.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">
<script src="./js/jquery-1.7.2.js"></script>
<script src="./js/bootstrap.js"></script>
<title>Excilys-Banking</title>

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
				</a> <a class="brand" href="#">Excilys-Banking</a>
				<div class="btn-group pull-right">
					<a class="btn"
						href="#moduleConnection"> <i class="icon-user"></i> Se
						connecter &nbsp;
					</a>
				</div>

			</div>
		</div>
	</div>

	<div class="row-fluid">
		<div class="span4"></div>
		<div class="span4">
		<br/>
			<div class="well">
				<h3 id="moduleConnetion" class="center">Connexion</h3>
				<hr>
				<form class="form-horizontal"
					action="<c:url value='j_spring_security_check' />" method='POST'>
					<c:if test="${not empty errorLogin}">
						<div class="alert alert-error">
							<strong>Error</strong>: The username or password you entered is
							incorrect.
						</div>
					</c:if>
					<c:if test="${not empty errorTooManySessions}">
						<div class="alert alert-error">
							<strong>Error</strong>: Sorry too many sessions.
						</div>
					</c:if>
					<c:if test="${not empty errorSessionTimeOut}">
						<div class="alert alert-error">
							<strong>Error</strong>: Sorry your session timed out.
						</div>
					</c:if>

					<div class="control-group">
						<label class="control-label" class="span6" for="j_username">Nom
							d'utilisateur:</label>
						<div class="controls">
							<input type="text" class="span8" name='j_username'
								placeholder="Nom d'utilisateur">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" class="span6" for="j_password">Mot
							de passe:</label>
						<div class="controls">
							<input type="password" class="span8" name='j_password'
								placeholder="Mot de passe">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Rester connecté :</label>
						<div class="controls">
							<input type='checkbox' name='_spring_security_remember_me' />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">Se
								connecter</button>
						</div>
					</div>


				</form>

			</div>

		</div>
		<div class="span4"></div>
	</div>

	<hr>

	<footer>
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<img class="pull-left" src="./img/excilys.jpeg"/>
				<br/>
				<img class="pull-right" src="./img/ebi.png"/>
				<br/>	
				<p class="shiftToRight">&copy; EBusiness Information - Groupe Excilys</p>
				<p class="shiftToRight"><i class="icon-wrench"></i> Développeurs: <a href="mailto:jmartinez@excilys.com">Jérémie Martinez</a> &amp; <a href="mailto:lponnau@excilys.com">Luc "Bizu" Ponnau</a>
				
			</div>
			<div class="span1"></div>
		</div>
	</footer>

</body>
</html>