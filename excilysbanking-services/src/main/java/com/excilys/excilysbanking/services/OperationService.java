
package com.excilys.excilysbanking.services;

import java.util.List;
import org.joda.time.YearMonth;
import com.excilys.excilysbanking.entities.Operation;

public interface OperationService {

	Double getMontantOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);

	List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym);

	List<Operation> getOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);

	List<Operation> getPagedOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer pageNumber);

	List<Operation> getPagedOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer pageNumber);

	Long getNumberOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym);

	Long getNumberOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym);

	boolean createVirementOperations(Integer compteDebit, Integer compteCredit, Double montant, String libelle);
}
