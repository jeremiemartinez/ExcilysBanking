
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationDAO {

	List<Operation> findOperationsByCompteId(Integer compte_id);

	Operation findOperationById(Integer id);

	List<Operation> findAllOperations();

	Double findTotalMontantOperationsCarteByCompteId(Integer compte_id);

	List<Operation> findOperationsNonCarteByCompteId(Integer compte_id);

	List<Operation> findOperationsCarteByCompteId(Integer compte_id);

}
