
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.Operation.OperationType.CARTE;
import static com.excilys.excilysbanking.entities.Operation.OperationType.VIREMENT;
import static com.excilys.excilysbanking.entities.QOperation.operation;
import java.util.List;
import org.joda.time.YearMonth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;
import com.mysema.query.hql.hibernate.HibernateQuery;

@Repository("operationDAO")
public class OperationDAOImpl extends AbstractDAOQueryDSLHelper implements OperationDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OperationDAOImpl.class);
	
	/**
	 * Prepared, but incomplete, query: SELECT o FROM operation WHERE o.id = ... AND o.type = ... AND o.date = ...
	 */
	private HibernateQuery queryOperations(Integer id, OperationType type, YearMonth ym) {
		return query().from(operation).where(operation.compte.id.eq(id), operation.type.eq(type), operation.date.year().eq(ym.getYear()),
				operation.date.month().eq(ym.getMonthOfYear()));
	}
	
	@Override
	public Double findMontantOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		LOGGER.debug("Calling Method findMontantOperationsCarteByCompteIdAndYearMonth");
		Double d = queryOperations(id, CARTE, ym).uniqueResult(operation.montant.sum());
		if (d == null)
			return 0.0;
		else
			return d;
	}
	
	@Override
	public List<Operation> findOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		LOGGER.debug("Calling Method findOperationsVirementByCompteIdAndYearMonth");
		return findOperations(id, VIREMENT, ym, 0, 0);
	}
	
	@Override
	public List<Operation> findOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		LOGGER.debug("Calling Method findOperationsCarteByCompteIdAndYearMonth");
		return findOperations(id, CARTE, ym, 0, 0);
	}
	
	@Override
	/**
	 * Applies paging only if pageNumber > 0 and pageSize > 0, else fetch all operations.
	 * First page is page number 1.
	 */
	public List<Operation> findPagedOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer PageNumber) {
		LOGGER.debug("Calling Method findPagedOperationsVirementByCompteIdAndYearMonth");
		return findOperations(id, VIREMENT, ym, pageSize, PageNumber);
	}
	
	@Override
	public List<Operation> findPagedOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer PageNumber) {
		LOGGER.debug("Calling Method findPagedOperationsCarteByCompteIdAndYearMonth");
		return findOperations(id, CARTE, ym, pageSize, PageNumber);
	}
	
	private List<Operation> findOperations(Integer id, OperationType type, YearMonth ym, Integer pageSize, Integer pageNumber) {
		return page(queryOperations(id, type, ym).groupBy(operation).orderBy(operation.date.dayOfMonth().asc()), pageSize, pageNumber).list(operation);
	}
	
	@Override
	public Long findNumberOperationsCarteByCompteIdByYearMonth(Integer id, YearMonth ym) {
		LOGGER.debug("Calling Method findNumberOperationsCarteByYearMonth");
		return findNumberOperations(id, CARTE, ym);
	}
	
	@Override
	public Long findNumberOperationsVirementByCompteIdByYearMonth(Integer id, YearMonth ym) {
		LOGGER.debug("Calling Method findNumberOperationsVirementByYearMonth");
		return findNumberOperations(id, VIREMENT, ym);
	}
	
	private Long findNumberOperations(Integer id, OperationType type, YearMonth ym) {
		return queryOperations(id, type, ym).uniqueResult(operation.count());
	}
}
