
package com.excilys.excilysbanking.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import com.excilys.excilysbanking.dao.OperationDAO;
import com.excilys.excilysbanking.entities.Authority;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.entities.Operation;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.impl.OperationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OperationServiceTest {

	@Mock
	private OperationDAO operationDAOTest;

	@InjectMocks
	private OperationServiceImpl operationServiceTest;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		User userTest = new User("jmartinez", "password", "Jeremie", "Martinez");
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority(0, Authority.AuthorityType.ROLE_USER));
		userTest.setAuthorities(authorities);
		Compte compteTest = new Compte(6464, 2000.0, Compte.CompteType.ESPECE, userTest);
		List<Operation> operations = new ArrayList<Operation>();
		List<Operation> operationsNonCarte = new ArrayList<Operation>();
		Operation operation1 = new Operation(151, compteTest, Operation.OperationType.CARTE, 2000.0, new DateTime(2012, 6, 25, 0, 0));
		Operation operation2 = new Operation(152, compteTest, Operation.OperationType.CARTE, 2000.0, new DateTime(2012, 6, 25, 0, 0));
		Operation operation3 = new Operation(153, compteTest, Operation.OperationType.VIREMENT, -1000.0, new DateTime(2012, 6, 25, 0, 0));
		operations.add(operation1);
		operations.add(operation2);
		operations.add(operation3);
		operationsNonCarte.add(operation3);
		when(operationDAOTest.findOperationById(151)).thenReturn(operation1);
		when(operationDAOTest.findAllOperations()).thenReturn(operations);
		when(operationDAOTest.findOperationsNonCarteByCompteId(6464)).thenReturn(operationsNonCarte);
		when(operationDAOTest.findTotalMontantOperationsCarteByCompteId(6464)).thenReturn(4000.0);

	}

	@Test
	public void getAllOperationsTest() {
		assertEquals(operationServiceTest.getAllOperations().size(), 3);
	}

	@Test
	public void getOperationsNonCarteByCompteId() {
		assertEquals(operationServiceTest.getOperationsNonCarteByCompteId(6464).size(), 1);
		assertEquals(operationServiceTest.getOperationsNonCarteByCompteId(6464).get(0).getOperation_id(), new Integer(153));
		assertEquals(operationServiceTest.getOperationsNonCarteByCompteId(6464).get(0).getMontant(), new Double(-1000.00));
	}

	@Test
	public void getTotalMontantOperationNonCarteByCompteId() {
		assertEquals(operationServiceTest.getTotalMontantOperationsCarteByCompteId(6464), new Double(4000.0));
	}
}
