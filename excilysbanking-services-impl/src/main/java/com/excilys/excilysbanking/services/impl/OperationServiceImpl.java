
package com.excilys.excilysbanking.services.impl;

import java.util.List;
import org.joda.time.YearMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.services.OperationService;

@Service("operationService")
@Transactional(readOnly = true)
public class OperationServiceImpl implements OperationService {
	
	@Autowired
	private OperationDAO operationDAO;
	
	@Override
	public Double getMontantOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findMontantOperationsCarteByCompteIdAndYearMonth(id, ym);
	}
	
	@Override
	public List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findOperationsVirementByCompteIdAndYearMonth(id, ym);
	}
	
	@Override
	public List<Operation> getOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findOperationsCarteByCompteIdAndYearMonth(id, ym);
	}
	
	@Override
	public List<Operation> getPagedOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer pageNumber) {
		return operationDAO.findPagedOperationsVirementByCompteIdAndYearMonth(id, ym, pageSize, pageNumber);
	}
	
	@Override
	public List<Operation> getPagedOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym, Integer pageSize, Integer pageNumber) {
		return operationDAO.findPagedOperationsCarteByCompteIdAndYearMonth(id, ym, pageSize, pageNumber);
	}
	
	@Override
	public Long getNumberOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findNumberOperationsVirementByCompteIdByYearMonth(id, ym);
	}
	
	@Override
	public Long getNumberOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findNumberOperationsCarteByCompteIdByYearMonth(id, ym);
	}
	
}
