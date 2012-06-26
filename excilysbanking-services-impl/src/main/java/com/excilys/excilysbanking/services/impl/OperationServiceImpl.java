
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
	public Double getTotalMontantOperationsCarteByCompteId(Integer compte_id) {
		return operationDAO.findTotalMontantOperationsCarteByCompteId(compte_id);
	}

	@Override
	public List<Operation> getOperationsNonCarteByCompteId(Integer compte_id) {
		return operationDAO.findOperationsNonCarteByCompteId(compte_id);
	}

}
