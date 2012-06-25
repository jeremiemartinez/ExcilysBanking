<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<hr>
<footer>
	<div class="row-fluid">
		<div class="span1"></div>
		<div class="span10">
			<img class="pull-left" src="/ebank/img/excilys.jpeg" /> <br /> <img
				class="pull-right" src="/ebank/img/ebi.png" /> <br />
			<p class="shiftToRight">
				&copy;
				<spring:message code="footer.companyName" />
			</p>
			<p class="shiftToRight">
				<i class="icon-wrench"></i> &nbsp;
				<spring:message code="footer.developper" />
				<a href="mailto:jmartinez@excilys.com">Jérémie Martinez</a> &amp; <a
					href="mailto:lponnau@excilys.com">Luc Ponnau</a>
		</div>
		<div class="span1"></div>
	</div>
</footer>