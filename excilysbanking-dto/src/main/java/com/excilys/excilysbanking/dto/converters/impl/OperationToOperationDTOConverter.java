
package com.excilys.excilysbanking.dto.converters.impl;

import org.springframework.stereotype.Component;
import com.excilys.excilysbanking.dto.OperationDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;

@Component("operationToOperationDTOConverter")
public class OperationToOperationDTOConverter extends Converter<Operation, OperationDTO> {

	@Override
	public OperationDTO convert(Operation source) {
		OperationDTO.Builder op = new OperationDTO.Builder().id(source.getId()).compte(source.getCompte().getId()).type(source.getType())
				.montant(source.getMontant()).libelle(source.getLibelle()).date(source.getDate());
		if (source.getType().equals(OperationType.VIREMENT))
			op.compteDestination(source.getCompteDestination().getId());
		return op.build();

	}
}
