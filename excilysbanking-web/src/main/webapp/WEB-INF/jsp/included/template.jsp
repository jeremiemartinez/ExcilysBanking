<script id="operationTpl" type="text/template">
<joda:parseDateTime var="parsed" pattern="yy/M/d" value="05/11/19" />
{{#.}}<tr><td>{{id}}</td><td><joda:format value="${parsed}" style="L-" /></td><td>{{type}}</td><td>{{libelle}}</td><td> {{montant}}</td></tr>{{/.}}
</script>