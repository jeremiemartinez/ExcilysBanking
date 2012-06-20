
package com.excilys.excilysbanking.dao;

import static org.junit.Assert.assertEquals;
import java.util.List;
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
import com.excilys.excilysbanking.entities.Compte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/appcontext-dao-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@DataSet(locations = { "classpath:/datasets/datasetUsersAndAuthorities.xml", "classpath:/datasets/datasetComptes.xml" }, dbType = DBType.H2)
@TransactionConfiguration
@Transactional
public class CompteDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CompteDAO compteDAOTest;

	@Test
	public void findCompteByIdTest() {
		Compte compteTest = compteDAOTest.findCompteById(6464);
		assertEquals(new Double(10000), compteTest.getSolde());
		assertEquals(Compte.CompteType.CARTE, compteTest.getType());
		assertEquals(compteTest.getUser().getUsername(), "jmartinez");
	}

	@Test
	public void findAllComptesTest() {
		List<Compte> comptes = compteDAOTest.findAllComptes();
		assertEquals(comptes.size(), 3);
		assertEquals(new Double(2.68), comptes.get(1).getSolde());
		assertEquals(Compte.CompteType.CARTE, comptes.get(1).getType());
		assertEquals(comptes.get(1).getUser().getUsername(), "lponnau");
	}

	@Test
	public void findComptesByUsernameTest() {
		List<Compte> comptes = compteDAOTest.findComptesByUsername("jmartinez");
		assertEquals(comptes.size(), 2);
		assertEquals(new Double(2000), comptes.get(0).getSolde());
		assertEquals(Compte.CompteType.CARTE, comptes.get(0).getType());
		assertEquals(comptes.get(0).getUser().getUsername(), "jmartinez");
	}
}
