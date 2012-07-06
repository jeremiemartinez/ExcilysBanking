<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<h3>Compte 6464</h3>

	<p>Solde du compte :
	<span id="solde"></span>
	</p>
	
	<p>Derniers virements effectués :
	<p/>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Date</th>
			<th>Destination</th>
			<th>Libellé</th>
			<th>Montant</th>
		</tr>
		<tr id="record"></tr>
	</table>
		
	<p>Compte à créditer : <input type="text" name="credit" value="2138962500"/></p>
	<p>Libellé : <input type="text" name="libelle" /></p>
	<p>Montant : <input type="text" name="montant" /></p>
	<p><button type="button" onclick="virement();">Effectuer le virement</button></p>
	
	<script src="/ebank/resources/js/jquery-1.7.2.js"></script>

	<script type="text/javascript">
		refresh();
		
		function virement() {
			var credit = $('#credit').val();
			var libelle = $('#libelle').val();
			var montant = $('#montant').val();

			$.ajax({
				  url: "http://localhost:8080/ebankWS-rest/services/VirementServiceRS/virement/debit/6464/credit/"
						+ credit
						+ "/libelle/"
						+ libelle
						+ "/montant/"
						+ montant,
				  type: 'POST',
				  dataType: 'json'
				});

			refresh();
		};

		function refresh() {
			$.getJSON(
						"http://localhost:8080/ebankWS-rest/services/VirementServiceRS/solde/compte/6464",
						function(data) {
							$('#solde').html(data);
						});
			$.getJSON(
						"http://localhost:8080/ebankWS-rest/services/VirementServiceRS/record/compte/6464",
						function(data) {
							var template = $('#virementsTpl').html();
							var html = Mustache.to_html(template, data);
							$('#record').html(html);
						});
		}
	</script>

	<script id="virementsTpl" type="text/template">
		{{#.}}
			<tr>
				<td>{{id}}</td>
				<td>{{date}}</td>
				<td>{{compteDestination}}</td>
				<td>{{libelle}}</td>
				<td>{{montant}} $</td>
			</tr>
		{{/.}}
	</script>

</body>
</html>
