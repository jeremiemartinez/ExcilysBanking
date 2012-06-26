
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.QOperation.operation;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.Operation;

@Repository("operationDAO")
public class OperationDAOImpl extends AbstractDAOQueryDSLHelper implements OperationDAO {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Operation> findOperationsByCompteId(Integer compte_id) {
		log.debug("Calling Method findOperationsByCompteId");
		return query().from(operation).where(operation.compte.compte_id.eq(compte_id)).list(operation);
	}
	
	@Override
	public Operation findOperationById(Integer id) {
		log.debug("Calling Method findOperationById");
		Operation operation = (Operation) sessions.getCurrentSession().get(Operation.class, id);
		Assert.notNull(operation, "Operation does not exist...");
		return operation;
	}
	
	@Override
	public List<Operation> findAllOperations() {
		log.debug("Calling Method findAllOperations");
		return query().from(operation).list(operation);
	}
	
	@Override
	public Double findMontantOperationsCarteByCompteId(Integer compte_id) {
		log.debug("Calling Method findMontantOperationsCarteByCompteId");
		return query().from(operation).where(operation.compte.compte_id.eq(compte_id), operation.type.eq(Operation.OperationType.CARTE))
				.uniqueResult(operation.montant.sum());
	}
	
	@Override
	public List<Operation> findOperationsCarteByCompteId(Integer compte_id) {
		log.debug("Calling Method findOperationsCarteByCompteId");
		return query().from(operation).where(operation.type.eq(Operation.OperationType.CARTE), operation.compte.compte_id.eq(compte_id)).list(operation);
	}
	
	@Override
	public List<Operation> findOperationsVirementByCompteId(Integer compte_id) {
		log.debug("Calling Method findOperationsVirementByCompteId");
		return query().from(operation).where(operation.type.ne(Operation.OperationType.CARTE), operation.compte.compte_id.eq(compte_id)).list(operation);
	}
	
	@Override
	public List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		log.debug("Calling Method findOperationsVirementByCompteIdAndYearMonth");
		return query()
				.from(operation)
				.where(operation.type.ne(Operation.OperationType.CARTE), operation.compte.compte_id.eq(compte_id), operation.date.year().eq(year),
						operation.date.month().eq(month)).orderBy(operation.date.dayOfMonth().asc()).list(operation);
	}
	
	@Override
	public List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		log.debug("Calling Method findOperationsCarteByCompteIdAndYearMonth");
		return query()
				.from(operation)
				.where(operation.type.eq(Operation.OperationType.CARTE), operation.compte.compte_id.eq(compte_id), operation.date.year().eq(year),
						operation.date.month().eq(month)).orderBy(operation.date.dayOfMonth().asc()).list(operation);
	}
}
