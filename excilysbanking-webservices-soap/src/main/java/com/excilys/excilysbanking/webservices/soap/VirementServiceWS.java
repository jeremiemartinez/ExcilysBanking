
package com.excilys.excilysbanking.webservices.soap;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.excilys.excilysbanking.dto.OperationDTO;

@WebService
public interface VirementServiceWS {
	
	Double getSoldeCompte(@WebParam Integer compteId);
	
	List<OperationDTO> getHistoriqueVirementByCompteId(@WebParam Integer compteId);
	
	void performVirement(@WebParam Integer compteDebit, @WebParam Integer compteCredit, @WebParam String libelle, @WebParam Double montant);
}
