<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<h3>Compte 6464</h3>

	<p>
		Solde du compte : <span id="solde"></span>
	</p>

	<p>Derniers virements effectués :
	<p />

	<table>
		<tr>
			<th>Id</th>
			<th>Date</th>
			<th>Destination</th>
			<th>Libellé</th>
			<th>Montant</th>
		</tr>
		<tbody id="record">

		</tbody>
	</table>
	<form id="virement" onsubmit="javascript: virement();">
		<p>
			Compte à créditer : <input type="text" name="credit" value="2138962500" />
		</p>
		<p>
			Libellé : <input type="text" name="libelle" />
		</p>
		<p>
			Montant : <input type="text" name="montant" />
		</p>
		<p>
			<input type="submit" value="Effectuer le virement"></input>
		</p>
	</form>
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
	<script src="/ebankWS-rest-client/resources/jquery-1.7.2.js"></script>
	<script src="/ebankWS-rest-client/resources/mustache.js"></script>
	<script type="text/javascript">
		refresh();

		function virement() {
			var credit = document.forms["virement"]["credit"].value;
			var libelle = document.forms["virement"]["libelle"].value;
			var montant = document.forms["virement"]["montant"].value;

			$.ajax({
						url : "http://localhost:8080/ebankWS-rest/services/VirementServiceRS/virement/debit/6464/credit/"
								+ credit
								+ "/libelle/"
								+ libelle
								+ "/montant/"
								+ montant,
						type : 'POST',
						dataType : 'json'
					});
			refresh();
		};

		function refresh() {

			$.getJSON(
							"http://localhost:8080/ebankWS-rest/services/VirementServiceRS/record/compte/6464",
							function(data) {
								var template = $('#virementsTpl').html();
								var html = Mustache.to_html(template, data);
								$('#record').html(html);
							});

			$.getJSON(
							"http://localhost:8080/ebankWS-rest/services/VirementServiceRS/solde/compte/6464",
							function(data) {
								$('#solde').html(data);
							});

		}
	</script>



</body>
</html>
