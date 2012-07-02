
package com.excilys.excilysbanking.dao;

import java.util.List;
import org.joda.time.YearMonth;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;

public interface OperationDAO {

	Double findMontantOperationsCarte(Integer id, YearMonth ym);

	Long findNumberOperations(Integer id, OperationType type, YearMonth ym);

	/**
	 * Applies paging only if pageNumber > 0 and pageSize > 0, else fetch all operations. First page is page number 1.
	 */
	List<Operation> findOperations(Integer id, OperationType type, YearMonth ym, Integer pageSize, Integer PageNumber);

	void save(Operation operation);

	List<Operation> findOperationsVirementNegatifLast6Months(Integer id, Integer pageSize, Integer pageNumber);

	Long findNumberOperationsVirementNegatifLast6Months(Integer id);

}
