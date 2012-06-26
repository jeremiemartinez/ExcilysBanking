
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationDAO {
	
	Operation findOperationById(Integer id);
	
	List<Operation> findAllOperations();
	
	List<Operation> findOperationsByCompteId(Integer compte_id);
	
	Double findMontantOperationsCarteByCompteId(Integer compte_id);
	
	List<Operation> findOperationsCarteByCompteId(Integer compte_id);
	
	List<Operation> findOperationsVirementByCompteId(Integer compte_id);
	
	List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
	List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);
	
}
