
package com.excilys.excilysbanking.webservices.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.excilys.excilysbanking.dto.OperationDTO;

@Path("/services/VirementServiceRS")
@Produces("application/json")
public interface VirementServiceRS {

	@GET
	@Path("/solde/compte/{compteId}")
	Double getSoldeCompte(@PathParam("compteId") Integer compteId);

	@GET
	@Path("/record/compte/{compteId}")
	List<OperationDTO> getHistoriqueVirementByCompteId(@PathParam("compteId") Integer compteId);

	@POST
	@Consumes("application/json")
	@Path("/virement/debit/{debit}/credit/{credit}/libelle/{libelle}/montant/{montant}")
	void performVirement(@PathParam("debit") Integer compteDebit, @PathParam("credit") Integer compteCredit, @PathParam("libelle") String libelle,
			@PathParam("montant") Double montant);
}
