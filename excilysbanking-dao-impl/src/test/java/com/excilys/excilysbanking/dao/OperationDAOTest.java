
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import org.joda.time.DateTime;
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
import com.excilys.excilysbanking.entities.Operation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-impl.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = "classpath:/datasets/dataset*.xml", dbType = DBType.H2)
@TransactionConfiguration
@Transactional
@ActiveProfiles("testing")
public class OperationDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private OperationDAO operationDAOTest;
	
	@Test
	public void findMontantOperationsCarteByCompteIdTest() {
		assertEquals(Double.valueOf(-2500), operationDAOTest.findMontantOperationsCarteByCompteId(6464));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findMontantOperationsCarteByNullCompteIdTest() {
		operationDAOTest.findMontantOperationsCarteByCompteId(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findMontantOperationsCarteByWrongCompteIdTest() {
		operationDAOTest.findMontantOperationsCarteByCompteId(-9999);
	}
	
	@Test
	public void findOperationsCarteByCompteIdAndYearMonth() {
		List<Operation> ops = operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(6464, 2012, 6);
		assertEquals(2, ops.size());
		
		Operation op = ops.get(0);
		assertEquals(Double.valueOf(-2000), op.getMontant());
		assertEquals(Integer.valueOf(6464), op.getCompte().getCompte_id());
		assertEquals("SNCF Pau-Montreal", op.getLibelle());
		assertEquals(Operation.OperationType.CARTE, op.getType());
		assertEquals(Integer.valueOf(151), op.getOperation_id());
		assertEquals(new DateTime(2012, 6, 25, 2, 0), op.getDate());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findOperationsCarteByNullCompteIdAndYearMonth() {
		operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(null, 2012, 6);
	}
	
	@Test
	public void findOperationsCarteByWrongCompteIdAndYearMonth() {
		assertEquals(Collections.emptyList(), operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(-9999, 2012, 6));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findOperationsCarteByCompteIdAndNullYearMonth() {
		operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(6464, null, 6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findOperationsCarteByCompteIdAndYearNullMonth() {
		operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(6464, 2012, null);
	}
	
	@Test
	public void findOperationsCarteByCompteIdAndWrongYearMonth() {
		assertEquals(Collections.emptyList(), operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(6464, -987, 6));
	}
	
	@Test
	public void findOperationsCarteByCompteIdAndYearWrongMonth() {
		assertEquals(Collections.emptyList(), operationDAOTest.findOperationsCarteByCompteIdAndYearMonth(6464, 2012, -123));
	}
}
