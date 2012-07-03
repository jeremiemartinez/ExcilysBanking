
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.Operation.OperationType.CARTE;
import static com.excilys.excilysbanking.entities.Operation.OperationType.VIREMENT;
import static com.excilys.excilysbanking.entities.QOperation.operation;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;

@Repository("operationDAO")
public class OperationDAOImpl extends AbstractDAOQueryDSLHelper implements OperationDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperationDAOImpl.class);

	@Override
	public Double findMontantOperationsCarte(Integer id, YearMonth ym) {
		LOGGER.debug("Calling Method findMontantOperationsCarte");
		Double d = query()
				.from(operation)
				.where(operation.compte.id.eq(id), operation.type.eq(CARTE), operation.date.year().eq(ym.getYear()),
						operation.date.month().eq(ym.getMonthOfYear())).uniqueResult(operation.montant.sum());
		if (d == null)
			return 0.0;
		else
			return d;
	}

	@Override
	public List<Operation> findOperations(Integer id, OperationType type, YearMonth ym, Integer pageSize, Integer pageNumber) {
		LOGGER.debug("Calling Method findOperations");
		return page(
				query().from(operation)
						.where(operation.compte.id.eq(id), operation.type.eq(type), operation.date.year().eq(ym.getYear()),
								operation.date.month().eq(ym.getMonthOfYear())).groupBy(operation).orderBy(operation.date.dayOfMonth().desc()), pageSize,
				pageNumber).list(operation);
	}

	@Override
	public Long findNumberOperations(Integer id, OperationType type, YearMonth ym) {
		LOGGER.debug("Calling Method findNumberOperations");
		return query()
				.from(operation)
				.where(operation.compte.id.eq(id), operation.type.eq(type), operation.date.year().eq(ym.getYear()),
						operation.date.month().eq(ym.getMonthOfYear())).uniqueResult(operation.count());
	}

	@Override
	public void save(Operation operation) {
		LOGGER.debug("Calling Method save operation");
		sessions.getCurrentSession().persist(operation);
	}

	@Override
	public List<Operation> findOperationsVirementNegatifLast6Months(Integer id, Integer pageSize, Integer pageNumber) {
		LOGGER.debug("Calling Method findOperationsVirementNegatifLast6Months");
		DateTime last6Months = DateTime.now().minusMonths(6);
		return page(
				query().from(operation).where(operation.compte.id.eq(id), operation.type.eq(VIREMENT), operation.montant.loe(0),
						operation.date.after(last6Months)), pageSize, pageNumber).groupBy(operation).orderBy(operation.date.desc()).list(operation);

	}

	@Override
	public Long findNumberOperationsVirementNegatifLast6Months(Integer id) {
		LOGGER.debug("Calling Method findNumberOperationsVirementNegatifLast6Months");
		DateTime last6Months = DateTime.now().minusMonths(6);
		return query().from(operation)
				.where(operation.compte.id.eq(id), operation.type.eq(VIREMENT), operation.montant.loe(0), operation.date.after(last6Months))
				.uniqueResult(operation.count());
	}

}
