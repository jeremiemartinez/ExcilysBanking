
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.YearMonth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
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
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.entities.Operation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-impl.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = { "classpath:/datasets/datasetUsers.xml", "classpath:/datasets/datasetAuthorities.xml",
		"classpath:/datasets/datasetUsersAndAuthorities.xml", "classpath:/datasets/datasetComptes.xml", "classpath:/datasets/datasetOperations.xml" }, dbType = DBType.H2)
@TransactionConfiguration
@Transactional
@ActiveProfiles("testing")
public class OperationDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private OperationDAO operationDAOTest;

	@Test
	public void findMontantOperationsCarteByCompteIdAndYearMonthTest() {
		assertEquals(Double.valueOf(1766.43), operationDAOTest.findMontantOperationsCarte(6464, new YearMonth(2012, 6)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void findMontantOperationsCarteByNullCompteIdAndYearMonthTest() {
		operationDAOTest.findMontantOperationsCarte(null, new YearMonth(2012, 6));
	}

	@Test(expected = NullPointerException.class)
	public void findMontantOperationsCarteByCompteIdAndNullYearMonthTest() {
		operationDAOTest.findMontantOperationsCarte(6464, null);
	}

	@Test
	public void findMontantOperationsCarteByWrongCompteIdAndYearMonthTest() {
		assertEquals(Double.valueOf(0d), operationDAOTest.findMontantOperationsCarte(-9999, new YearMonth(2012, 6)));
	}

	@Test
	public void findMontantOperationsCarteByCompteIdAndWrongYearMonthTest() {
		assertEquals(Double.valueOf(0d), operationDAOTest.findMontantOperationsCarte(6464, new YearMonth(-987, 6)));
	}

	@Test(expected = IllegalFieldValueException.class)
	public void findMontantOperationsCarteByCompteIdAndYearWrongMonthTest() {
		operationDAOTest.findMontantOperationsCarte(6464, new YearMonth(2012, -456));
	}

	@Test
	public void findOperationsCarteByCompteIdAndYearMonth() {
		List<Operation> ops = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 0, 0);
		assertEquals(4, ops.size());

		Operation op = ops.get(0);
		assertEquals(Double.valueOf(500.68), op.getMontant());
		assertEquals(6464, op.getCompte().getId().intValue());
		assertEquals("Some operation #26867996", op.getLibelle());
		assertEquals(Operation.OperationType.CARTE, op.getType());

		DateTime d = op.getDate();
		assertEquals(2012, d.getYear());
		assertEquals(6, d.getMonthOfYear());
		assertEquals(24, d.getDayOfMonth());
		assertEquals(7, d.getHourOfDay());
		assertEquals(0, d.getMinuteOfHour());
	}

	@Test(expected = IllegalArgumentException.class)
	public void findOperationsCarteByNullCompteIdAndYearMonth() {
		operationDAOTest.findOperations(null, Operation.OperationType.CARTE, new YearMonth(2012, 6), 0, 0);
	}

	@Test
	public void findOperationsCarteByWrongCompteIdAndYearMonth() {
		assertEquals(Collections.emptyList(), operationDAOTest.findOperations(-9999, Operation.OperationType.CARTE, new YearMonth(2012, 6), 0, 0));
	}

	@Test(expected = NullPointerException.class)
	public void findOperationsCarteByCompteIdAndNullYearMonth() {
		operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, null, 0, 0);
	}

	@Test
	public void findOperationsCarteByCompteIdAndWrongYearMonth() {
		assertEquals(Collections.emptyList(), operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(-987, 6), 0, 0));
	}

	@Test(expected = IllegalFieldValueException.class)
	public void findOperationsCarteByCompteIdAndYearWrongMonth() {
		operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, -456), 0, 0);
	}

	@Test
	public void findNumberOperationsCarteByCompteIdByYearMonthTest() {
		assertEquals(Long.valueOf(4), operationDAOTest.findNumberOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6)));
	}

	@Test(expected = NullPointerException.class)
	public void findNumberOperationsCarteByCompteIdByNullYearMonthTest() {
		operationDAOTest.findNumberOperations(6464, Operation.OperationType.CARTE, null);
	}

	@Test(expected = IllegalFieldValueException.class)
	public void findNumberOperationsCarteByCompteIdByWrongYearMonthTest() {
		operationDAOTest.findNumberOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 13));
	}

	@Test
	public void findNumberOperationsVirementByCompteIdByYearMonthTest() {
		assertEquals(Long.valueOf(2), operationDAOTest.findNumberOperations(6464, Operation.OperationType.VIREMENT, new YearMonth(2012, 6)));
	}

	@Test(expected = NullPointerException.class)
	public void findNumberOperationsVirementByCompteIdByNullYearMonthTest() {
		operationDAOTest.findNumberOperations(6464, Operation.OperationType.VIREMENT, null);
	}

	@Test(expected = IllegalFieldValueException.class)
	public void findNumberOperationsVirementByCompteIdByWrongYearMonthTest() {
		operationDAOTest.findNumberOperations(6464, Operation.OperationType.VIREMENT, new YearMonth(2012, 13));
	}

	@Test
	public void findPagedOperationsCarteByCompteIdAndYearMonth() {
		List<Operation> ops = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 1, 1);
		assertEquals(1, ops.size());
		assertEquals("Some operation #26867996", ops.get(0).getLibelle());
		ops = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 1, 2);
		assertEquals(1, ops.size());
		assertEquals("Some operation #28420709", ops.get(0).getLibelle());
	}

	@Test
	public void findPagedOperationsVirementByCompteIdAndYearMonth() {
		List<Operation> ops = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 1, 1);
		assertEquals(1, ops.size());
		ops = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 1, 2);
		assertEquals(1, ops.size());
	}

	@Test
	public void saveTest() {
		List<Operation> ops = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 0, 0);
		assertEquals(4, ops.size());

		Compte compte = ops.get(0).getCompte();

		Operation newOperation = new Operation.Builder().compte(compte).date(new DateTime(2012, 6, 5, 0, 0)).libelle("libelleInsert").montant(1000.0)
				.type(Operation.OperationType.CARTE).compteDestination(compte).build();

		operationDAOTest.save(newOperation);

		List<Operation> opsPost = operationDAOTest.findOperations(6464, Operation.OperationType.CARTE, new YearMonth(2012, 6), 0, 0);
		assertEquals(5, opsPost.size());

	}
}
