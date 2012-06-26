
package com.excilys.excilysbanking.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.services.OperationService;

@Service("operationService")
@Transactional
public class OperationServiceImpl implements OperationService {
	
	@Autowired
	private OperationDAO operationDAO;
	
	@Override
	public Double getMontantOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		return operationDAO.findMontantOperationsCarteByCompteIdAndYearMonth(compte_id, year, month);
	}
	
	@Override
	public List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		return operationDAO.findOperationsVirementByCompteIdAndYearMonth(compte_id, year, month);
	}
	
	@Override
	public List<Operation> getOperationsCarteByCompteIdAndYearMonth(Integer compte_id, Integer year, Integer month) {
		return operationDAO.findOperationsCarteByCompteIdAndYearMonth(compte_id, year, month);
	}
	
}
