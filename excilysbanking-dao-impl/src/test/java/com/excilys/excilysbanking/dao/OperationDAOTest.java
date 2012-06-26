
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.ebi.spring.dbunit.config.DBType;
import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import com.excilys.excilysbanking.entities.Operation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = "classpath:/datasets/dataset*.xml", dbType = DBType.H2)
@TransactionConfiguration
@Transactional
public class OperationDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private OperationDAO operationDAOTest;

	@Test
	public void findOperationByIdTest() {
		Operation operationTest = operationDAOTest.findOperationById(151);
		assertEquals(new Double(2000), operationTest.getMontant());
		assertEquals(Operation.OperationType.CARTE, operationTest.getType());
		assertEquals(operationTest.getCompte().getCompte_id(), new Integer(6464));
		assertEquals(operationTest.getDate(), new DateTime(2012, 6, 25, 2, 0));
	}

	@Test
	public void findAllOperationsTest() {
		List<Operation> operations = operationDAOTest.findAllOperations();
		assertEquals(operations.size(), 3);
		assertEquals(new Double(-500), operations.get(1).getMontant());
		assertEquals(operations.get(1).getCompte().getCompte_id(), new Integer(6464));
		assertEquals(new DateTime(2012, 6, 25, 2, 0), operations.get(1).getDate());
	}

	@Test
	public void findTotalMontantOperationsCarteByCompteIdTest() {
		assertEquals(new Double(2500.0), operationDAOTest.findTotalMontantOperationsCarteByCompteId(6464));
	}
}
