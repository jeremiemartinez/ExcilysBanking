
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
import java.util.List;
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
import com.excilys.excilysbanking.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-impl.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = { "classpath:/datasets/datasetUsers.xml", "classpath:/datasets/datasetAuthorities.xml",
		"classpath:/datasets/datasetUsersAndAuthorities.xml", "classpath:/datasets/datasetComptes.xml", "classpath:/datasets/datasetOperations.xml" }, dbType = DBType.H2)
@TransactionConfiguration
@Transactional
@ActiveProfiles("testing")
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private UserDAO userDAOTest;
	
	@Test
	public void findUserByUsernameTest() {
		User userTest = userDAOTest.findUserByUsername("jmartinez");
		assertEquals("Martinez", userTest.getLastname());
		assertEquals("Jérémie", userTest.getFirstname());
		
		assertEquals(2, userTest.getAuthorities().size());
		assertEquals("ROLE_ADMIN", userTest.getAuthorities().get(0).getAuthority());
		assertEquals("ROLE_USER", userTest.getAuthorities().get(1).getAuthority());
		
		assertEquals(2, userTest.getComptes().size());
		assertEquals(Integer.valueOf(2138962500), userTest.getComptes().get(0).getId());
		assertEquals(Double.valueOf(2000), userTest.getComptes().get(0).getSolde());
		assertEquals(Double.valueOf(10000), userTest.getComptes().get(1).getSolde());
		assertEquals(Compte.CompteType.ESPECE, userTest.getComptes().get(0).getType());
	}
	
	@Test
	public void findAllUsersTest() {
		List<User> users = userDAOTest.findUsers();
		assertEquals(2, users.size());
		assertEquals("lponnau", users.get(1).getUsername());
		assertEquals("jmartinez", users.get(0).getUsername());
		assertEquals(1, users.get(1).getAuthorities().size());
		assertEquals(2, users.get(0).getAuthorities().size());
		assertEquals("ROLE_USER", users.get(1).getAuthorities().get(0).getAuthority());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findUserByNullUsernameTest() {
		userDAOTest.findUserByUsername(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findUserByEmptyUsernameTest() {
		userDAOTest.findUserByUsername("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void findUserByWrongUsernameTest() {
		userDAOTest.findUserByUsername("tDurden");
	}
}
