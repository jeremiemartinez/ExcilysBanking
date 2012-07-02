
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
import java.util.Collections;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-impl.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = { "classpath:/datasets/datasetUsers.xml", "classpath:/datasets/datasetAuthorities.xml",
		"classpath:/datasets/datasetUsersAndAuthorities.xml", "classpath:/datasets/datasetComptes.xml", "classpath:/datasets/datasetOperations.xml" }, dbType = DBType.H2)
@TransactionConfiguration
@Transactional
@ActiveProfiles("testing")
public class CompteDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CompteDAO compteDAOTest;

	@Test
	public void findComptesByUsernameTest() {
		List<Compte> comptes = compteDAOTest.findComptesByUsername("jmartinez");
		assertEquals(2, comptes.size());
		assertEquals(Double.valueOf(10000), comptes.get(0).getSolde());
		assertEquals(Compte.CompteType.ESPECE, comptes.get(0).getType());
		assertEquals("jmartinez", comptes.get(0).getUser().getUsername());
	}

	@Test(expected = IllegalArgumentException.class)
	public void findComptesByNullUsernameTest() {
		compteDAOTest.findComptesByUsername(null);
	}

	@Test
	public void findComptesByEmptyUsernameTest() {
		assertEquals(Collections.emptyList(), compteDAOTest.findComptesByUsername(""));
	}

	@Test
	public void findComptesByWrongUsernameTest() {
		assertEquals(Collections.emptyList(), compteDAOTest.findComptesByUsername("tDurden"));
	}

	@Test
	public void findAllComptesTest() {
		List<Compte> comptes = compteDAOTest.findComptes();
		assertEquals(3, comptes.size());
		Compte c = comptes.get(0);
		assertEquals(42, c.getId().intValue());
		assertEquals(Double.valueOf(2.68), c.getSolde());
		assertEquals(Compte.CompteType.ESPECE, c.getType());
		assertEquals("lponnau", c.getUser().getUsername());
	}

	@Test
	public void updateTest() {
		Compte comptePreTest = compteDAOTest.findCompteById(6464);
		assertEquals(Double.valueOf("10000.0"), comptePreTest.getSolde());
		comptePreTest.setSolde(1000.0);
		compteDAOTest.update(comptePreTest);
		Compte comptePostTest = compteDAOTest.findCompteById(6464);
		assertEquals(Double.valueOf("1000.0"), comptePostTest.getSolde());
	}
}
