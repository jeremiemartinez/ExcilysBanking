
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.QOperation.operation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.Operation;

@Repository("operationDAO")
public class OperationDAOImpl extends AbstractDAOQueryDSLHelper implements OperationDAO {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Double findMontantOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		log.debug("Calling Method findMontantOperationsCarteByCompteId");
		return query()
				.from(operation)
				.where(operation.compte.compte_id.eq(compte_id), operation.type.eq(Operation.OperationType.CARTE), operation.date.year().eq(year),
						operation.date.month().eq(month)).uniqueResult(operation.montant.sum());
	}

	@Override
	public List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		log.debug("Calling Method findOperationsVirementByCompteIdAndYearMonth");
		return query()
				.from(operation)
				.where(operation.type.ne(Operation.OperationType.CARTE), operation.compte.compte_id.eq(compte_id), operation.date.year().eq(year),
						operation.date.month().eq(month)).groupBy(operation).orderBy(operation.date.dayOfMonth().asc()).list(operation);
	}

	@Override
	public List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		log.debug("Calling Method findOperationsCarteByCompteIdAndYearMonth");
		return query()
				.from(operation)
				.where(operation.type.eq(Operation.OperationType.CARTE), operation.compte.compte_id.eq(compte_id), operation.date.year().eq(year),
						operation.date.month().eq(month)).groupBy(operation).orderBy(operation.date.dayOfMonth().asc()).list(operation);
	}
}
