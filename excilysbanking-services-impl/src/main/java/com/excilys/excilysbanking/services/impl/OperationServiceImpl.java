
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
	public List<Operation> getAllOperations() {
		return operationDAO.findAllOperations();
	}
	
	@Override
	public Double getMontantOperationsCarteByCompteId(Integer compte_id) {
		return operationDAO.findMontantOperationsCarteByCompteId(compte_id);
	}
	
	@Override
	public List<Operation> getOperationsVirementByCompteId(Integer compte_id) {
		return operationDAO.findOperationsVirementByCompteId(compte_id);
	}
	
	@Override
	public List<Operation> getOperationsCarteByCompteId(Integer compte_id) {
		return operationDAO.findOperationsCarteByCompteId(compte_id);
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
