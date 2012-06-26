
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
@DataSet(locations = { "classpath:/datasets/datasetUsersAndAuthorities.xml", "classpath:/datasets/datasetComptes.xml" }, dbType = DBType.H2)
@TransactionConfiguration
@Transactional
@ActiveProfiles("testing")
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private UserDAO userDAOTest;
	
	@Test
	public void findUserByUsernameTest() {
		User userTest = userDAOTest.findUserByUsername("jmartinez");
		User userTest2 = userDAOTest.findUserByUsername("lponnau");
		assertEquals("Martinez", userTest.getLastname());
		assertEquals("Jérémie", userTest.getFirstname());
		assertEquals(userTest.getAuthorities().size(), 2);
		assertEquals(userTest.getAuthorities().get(0).getAuthority(), "ROLE_ADMIN");
		assertEquals(userTest.getAuthorities().get(1).getAuthority(), "ROLE_USER");
		assertEquals(userTest2.getAuthorities().get(0).getAuthority(), "ROLE_USER");
		assertEquals(userTest.getComptes().size(), 2);
		assertEquals(userTest.getComptes().get(0).getCompte_id(), new Integer(2138962500));
		assertEquals(userTest.getComptes().get(0).getSolde(), new Double(2000));
		assertEquals(userTest.getComptes().get(1).getSolde(), new Double(10000));
		assertEquals(userTest.getComptes().get(0).getType(), Compte.CompteType.ESPECE);
	}
	
	@Test
	public void findAllUsersTest() {
		List<User> users = userDAOTest.findAllUsers();
		assertEquals(users.size(), 2);
		assertEquals(users.get(0).getUsername(), "lponnau");
		assertEquals(users.get(1).getUsername(), "jmartinez");
		assertEquals(users.get(0).getAuthorities().size(), 1);
		assertEquals(users.get(1).getAuthorities().size(), 2);
		assertEquals(users.get(0).getAuthorities().get(0).getAuthority(), "ROLE_USER");
	}
}
