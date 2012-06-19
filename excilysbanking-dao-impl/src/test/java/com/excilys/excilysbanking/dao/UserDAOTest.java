
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = "/datasets/datasetUser.xml", dbType = DBType.H2)
@TransactionConfiguration
@Transactional
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserDAO userDAOTest;

	@Test
	public void findByLoginTest() {
		assertEquals(userDAOTest.findUserByLogin("jmartinez").getNationality(), "French");
		assertEquals(userDAOTest.findUserByLogin("lponnau").getPhone(), "0836656565");
	}
}
