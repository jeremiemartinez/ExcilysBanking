var cartesCurrentPage = 1;
var cartesLastPage = 1;
var showCartes = false;
var cYear;
var cMonth;
var cCompte;

function revealCartes(year, month, compte){
	cYear = year;
	cMonth = month;
	cCompte = compte;
	showCartes = !showCartes;
	if (showCartes) {
		getNumberCartes(cYear, cMonth, cCompte);
	}
}

function refreshCartes(year, month, compte) {
	getAndPrintCartes(year, month, cartesCurrentPage, compte);		
	$('#cartesPageNumber').html(cartesCurrentPage + '/' + cartesLastPage);
	if (cartesCurrentPage == 1)
		$('#cartePagerNext').hide();
	else 
		$('#cartePagerNext').show();
	if (cartesCurrentPage == cartesLastPage)
		$('#cartePagerPrevious').hide();
	else 
		$('#cartePagerPrevious').show();
}

$("#cartesNewer").click(function() {
	cartesCurrentPage--;
	refreshCartes(cYear, cMonth, cCompte);
});

$("#cartesNewest").click(function() {
	cartesCurrentPage = 1;
	refreshCartes(cYear, cMonth, cCompte);
});

$("#cartesOlder").click(function() {
	cartesCurrentPage++;
	refreshCartes(cYear, cMonth, cCompte);
});

$("#cartesOldest").click(function() {
	cartesCurrentPage = cartesLastPage;
	refreshCartes(cYear, cMonth, cCompte);
});

function getAndPrintCartes(year, month, page, compte){
	$.getJSON(
			"/ebank/secured/operations/id/" + compte + "/year/" + year + "/month/" + month + "/cartes/page/" + page,
			function(data) {
				var source = $('#operationTpl').html();
				var template = Handlebars.compile(source);
				var html = template(data);
				$('#operationsCarteArea').html(html);
			});
}

function getNumberCartes(year, month, compte) {
	$.getJSON(
			"/ebank/secured/operations/id/" + compte + "/year/" + year + "/month/" + month + "/cartes/pages",
			function(data) {
				cartesLastPage = parseInt(data / 5);
				if (data % 5 > 0 || cartesLastPage == 0)
					cartesLastPage++;
					
				refreshCartes(year, month, compte);
			});
}
