
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationService {
	
	Double getMontantOperationsCarteByCompteIdAndYearMonth(Integer id, Integer year, Integer month);
	
	List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer id, Integer year, Integer month);
	
	List<Operation> getOperationsCarteByCompteIdAndYearMonth(Integer id, Integer year, Integer month);
	
}
