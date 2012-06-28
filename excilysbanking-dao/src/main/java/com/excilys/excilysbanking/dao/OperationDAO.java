
package com.excilys.excilysbanking.dao;

import java.util.List;
import org.joda.time.YearMonth;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationDAO {
	
	Double findMontantOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);
	
	Long findNumberOperationsCarteByCompteIdByYearMonth(Integer id, YearMonth ym);
	
	Long findNumberOperationsVirementByCompteIdByYearMonth(Integer id, YearMonth ym);
	
	List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym);
	
	List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);
	
	/**
	 * Applies paging only if pageNumber > 0 and pageSize > 0, else fetch all operations. First page is page number 1.
	 */
	List<Operation> findPagedOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer PageNumber);
	
	/**
	 * Applies paging only if pageNumber > 0 and pageSize > 0, else fetch all operations. First page is page number 1.
	 */
	List<Operation> findPagedOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer PageNumber);
	
}
