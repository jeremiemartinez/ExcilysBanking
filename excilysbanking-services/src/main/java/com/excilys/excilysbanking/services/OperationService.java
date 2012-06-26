
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationService {

	List<Operation> getAllOperations();

	Double getTotalMontantOperationsCarteByCompteId(Integer compte_id);

	List<Operation> getOperationsNonCarteByCompteId(Integer compte_id);

}
