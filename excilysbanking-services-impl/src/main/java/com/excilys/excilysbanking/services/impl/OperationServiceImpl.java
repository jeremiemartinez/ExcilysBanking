
package com.excilys.excilysbanking.services.impl;

import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.excilysbanking.dao.CompteDAO;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.Operation.OperationType;
import com.excilys.excilysbanking.services.OperationService;

@Service("operationService")
@Transactional(readOnly = true)
public class OperationServiceImpl implements OperationService {
	
	@Autowired
	private OperationDAO operationDAO;
	
	@Autowired
	private CompteDAO compteDAO;
	
	@Override
	public List<Operation> getOperationsVirementNegatifLast6Months(Integer id, Integer pageSize, Integer PageNumber) {
		return operationDAO.findOperationsVirementNegatifLast6Months(id, pageSize, PageNumber);
	}
	
	@Override
	public List<Operation> getOperations(Integer id, OperationType type, YearMonth ym, Integer pageSize, Integer pageNumber) {
		return operationDAO.findOperations(id, type, ym, pageSize, pageNumber);
	}
	
	@Override
	public Long getNumberOperations(Integer id, OperationType type, YearMonth ym) {
		return operationDAO.findNumberOperations(id, type, ym);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void createVirementOperations(Integer compteDebit, Integer compteCredit, Double montant, String libelle) {
		
		Compte compteD = compteDAO.findCompteById(compteDebit);
		Compte compteC = compteDAO.findCompteById(compteCredit);
		
		DateTime now = DateTime.now();
		
		Operation operationD = new Operation.Builder().compte(compteD).type(Operation.OperationType.VIREMENT).libelle(libelle).montant(-montant).date(now)
				.compteDestination(compteC).build();
		Operation operationC = new Operation.Builder().compte(compteC).type(Operation.OperationType.VIREMENT).libelle(libelle).montant(montant).date(now)
				.compteDestination(compteD).build();
		
		operationDAO.save(operationD);
		operationDAO.save(operationC);
		
		compteD.setSolde(compteD.getSolde() - montant);
		compteC.setSolde(compteC.getSolde() + montant);
		
		compteDAO.update(compteD);
		compteDAO.update(compteC);
	}
	
	@Override
	public Long getNumberOperationsVirementNegatifLast6Months(Integer id) {
		return operationDAO.findNumberOperationsVirementNegatifLast6Months(id);
	}
	
	@Override
	public Double getMontantOperationsCarte(Integer id, YearMonth ym) {
		return operationDAO.findMontantOperationsCarte(id, ym);
	}
}
