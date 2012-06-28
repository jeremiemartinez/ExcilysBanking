
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationDAO {

	Double findMontantOperationsCarteByCompteIdAndYearMonth(Integer id, Integer year, Integer month);

	List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer id, Integer year, Integer month);

	List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer id, Integer year, Integer month);

}
