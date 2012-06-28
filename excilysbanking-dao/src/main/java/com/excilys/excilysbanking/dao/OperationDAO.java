
package com.excilys.excilysbanking.dao;

import java.util.List;
import org.joda.time.YearMonth;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationDAO {

	Double findMontantOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);

	List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym);

	List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);

}
