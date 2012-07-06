
package com.excilys.excilysbanking.services;

import java.util.List;
import org.joda.time.YearMonth;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;
import com.excilys.excilysbanking.entities.User;

public interface OperationService {

	Double getMontantOperationsCarte(Integer id, YearMonth ym);

	List<Operation> getOperations(Integer id, OperationType type, YearMonth ym, Integer pageSize, Integer pageNumber);

	Long getNumberOperations(Integer id, OperationType type, YearMonth ym);

	boolean createVirementOperations(User user, Integer compteDebit, Integer compteCredit, Double montant, String libelle);

	List<Operation> getOperationsVirementNegatifLast6Months(Integer id, Integer pageSize, Integer PageNumber);

	Long getNumberOperationsVirementNegatifLast6Months(Integer id);
}
