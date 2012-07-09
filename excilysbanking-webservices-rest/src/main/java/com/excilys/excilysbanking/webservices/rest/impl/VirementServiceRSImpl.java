
package com.excilys.excilysbanking.webservices.rest.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.excilys.excilysbanking.dto.OperationDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.services.OperationService;
import com.excilys.excilysbanking.webservices.rest.VirementServiceRS;

public class VirementServiceRSImpl implements VirementServiceRS {
	
	@Autowired
	private CompteService compteService;
	
	@Autowired
	private OperationService operationService;
	
	@Autowired
	@Qualifier("operationToOperationDTOConverter")
	private Converter<Operation, OperationDTO> converter;
	
	@Override
	public Double getSoldeCompte(Integer compteId) {
		return compteService.getCompteById(compteId).getSolde();
	}
	
	@Override
	public void performVirement(Integer compteDebit, Integer compteCredit, String libelle, Double montant) {
		operationService.createVirementOperations(compteDebit, compteCredit, montant, libelle);
	}
	
	@Override
	public List<OperationDTO> getHistoriqueVirementByCompteId(Integer compteId) {
		return converter.convert(operationService.getOperationsVirementNegatifLast6Months(compteId, 5, 1));
	}
	
}
