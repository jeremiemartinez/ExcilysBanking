
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationService {
	
	Double getMontantOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
	List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
	List<Operation> getOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
}
