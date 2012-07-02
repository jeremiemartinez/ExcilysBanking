
package com.excilys.excilysbanking.services;

import java.util.List;
import org.joda.time.YearMonth;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;

public interface OperationService {

	Double getMontantOperationsCarte(Integer id, YearMonth ym);

	List<Operation> getOperations(Integer id, OperationType type, YearMonth ym, Integer pageSize, Integer pageNumber);

	Long getNumberOperations(Integer id, OperationType type, YearMonth ym);

	void createVirementOperations(Integer compteDebit, Integer compteCredit, Double montant, String libelle);

	List<Operation> getOperationsVirementNegatifLast6Months(Integer id, Integer pageSize, Integer PageNumber);

	Long getNumberOperationsVirementNegatifLast6Months(Integer id);
}
