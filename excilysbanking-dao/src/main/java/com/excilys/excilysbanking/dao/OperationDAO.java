
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationDAO {

	Double findMontantOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);

	List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);

	List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month);

}
