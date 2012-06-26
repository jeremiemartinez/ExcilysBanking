
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationService {
	
	List<Operation> getAllOperations();
	
	Double getMontantOperationsCarteByCompteId(Integer compte_id);
	
	List<Operation> getOperationsVirementByCompteId(Integer compte_id);
	
	List<Operation> getOperationsCarteByCompteId(Integer compte_id);
	
	List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
	List<Operation> getOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
}
