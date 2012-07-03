var cartesCurrentPage = 1;
var cartesLastPage = 1;
var showCartes = false;
var cYear;
var cMonth;

function revealCartes(year, month){
	cYear = year;
	cMonth = month;
	showCartes = !showCartes;
	if (showCartes) {
		getNumberCartes(cYear, cMonth);
	}
}

function refreshCartes(year, month) {
	getAndPrintCartes(year, month, cartesCurrentPage);		
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
	refreshCartes(cYear, cMonth);
});

$("#cartesNewest").click(function() {
	cartesCurrentPage = 1;
	refreshCartes(cYear, cMonth);
});

$("#cartesOlder").click(function() {
	cartesCurrentPage++;
	refreshCartes(cYear, cMonth);
});

$("#cartesOldest").click(function() {
	cartesCurrentPage = cartesLastPage;
	refreshCartes(cYear, cMonth);
});

function getAndPrintCartes(year, month, page){
	$.getJSON(
			"/ebank/secured/operations/id/6464/year/"+year+"/month/"+month+"/cartes/page/" + page,
			function(data) {
				var source = $('#operationTpl').html();
				var template = Handlebars.compile(source);
				var html = template(data);
				$('#operationsCarteArea').html(html);
			});
}

function getNumberCartes(year, month) {
	$.getJSON(
			"/ebank/secured/operations/id/6464/year/"+year+"/month/"+month+"/cartes/pages",
			function(data) {
				cartesLastPage = parseInt(data / 5);
				if (data % 5 > 0)
					cartesLastPage++;
				refreshCartes(year, month);
			});
}
