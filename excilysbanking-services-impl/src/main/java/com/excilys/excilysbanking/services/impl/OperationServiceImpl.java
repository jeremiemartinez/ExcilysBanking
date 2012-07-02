
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
import com.excilys.excilysbanking.services.OperationService;

@Service("operationService")
@Transactional(readOnly = true)
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationDAO operationDAO;

	@Autowired
	private CompteDAO compteDAO;

	@Override
	public Double getMontantOperationsCarteByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findMontantOperationsCarteByCompteIdAndYearMonth(id, ym);
	}

	@Override
	public List<Operation> getOperationsVirementByCompteIdAndYearMonth(Integer id, YearMonth ym) {
		return operationDAO.findOperationsVirementByCompteIdAndYearMonth(id, ym);
	}

	@Override
	public List<Operation> getPagedOperationsVirementNegatifByCompteIdAndLast6Months(Integer id, Integer pageSize, Integer PageNumber) {
		return operationDAO.findPagedOperationsVirementNegatifByCompteIdAndLast6Months(id, pageSize, PageNumber);
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

	@Override
	@Transactional(readOnly = false)
	public boolean createVirementOperations(Integer compteDebit, Integer compteCredit, Double montant, String libelle) {
		Compte compteD = compteDAO.findCompteById(compteDebit);
		Compte compteC = compteDAO.findCompteById(compteCredit);

		Operation operationD = new Operation.Builder().compte(compteD).type(Operation.OperationType.VIREMENT).libelle(libelle).montant(-montant)
				.date(DateTime.now()).compteDestination(compteC).build();
		Operation operationC = new Operation.Builder().compte(compteC).type(Operation.OperationType.VIREMENT).libelle(libelle).montant(montant)
				.date(DateTime.now()).compteDestination(compteD).build();

		operationDAO.save(operationD);
		operationDAO.save(operationC);

		compteD.setSolde(compteD.getSolde() - montant);
		compteC.setSolde(compteC.getSolde() + montant);

		compteDAO.update(compteD);
		compteDAO.update(compteC);

		return true;
	}

	@Override
	public Long getNumberOperationsVirementNegatifByCompteIdAndLast6Months(Integer id) {
		return operationDAO.findNumberOperationsCarteByCompteIdAndLast6Months(id);
	}
}
