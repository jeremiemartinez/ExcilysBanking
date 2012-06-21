
package com.excilys.excilysbanking.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import com.excilys.excilysbanking.dao.CompteDAO;
import com.excilys.excilysbanking.entities.Authority;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.impl.CompteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CompteServiceTest {

	@Mock
	private CompteDAO compteDAOTest;

	@InjectMocks
	private CompteServiceImpl compteServiceTest;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		User userTest = new User("jmartinez", "password", "Jeremie", "Martinez");
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority(0, Authority.AuthorityType.ROLE_USER));
		userTest.setAuthorities(authorities);
		List<Compte> comptes = new ArrayList<Compte>();
		Compte compte1 = new Compte(42, 2000.0, Compte.CompteType.CARTE, userTest);
		Compte compte2 = new Compte(64, 10000.0, Compte.CompteType.ESPECE, userTest);
		comptes.add(compte1);
		comptes.add(compte2);
		userTest.setComptes(comptes);
		when(compteDAOTest.findComptesByUsername("jmartinez")).thenReturn(comptes);
		when(compteDAOTest.findCompteById(64)).thenReturn(compte2);

	}

	@Test
	public void getComptesByUsernameTest() {
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").get(0).getUser().getFirstname(), "Jeremie");
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").get(0).getUser().getLastname(), "Martinez");
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").get(0).getUser().getAuthorities().size(), 1);
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").size(), 2);
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").get(0).getCompte_id(), new Integer(42));
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").get(0).getSolde(), new Double(2000.0));
		assertEquals(compteServiceTest.getComptesByUsername("jmartinez").get(0).getType(), Compte.CompteType.CARTE);
	}

	@Test
	public void getCompteByIdTest() {
		assertEquals(compteServiceTest.getCompteById(64).getUser().getFirstname(), "Jeremie");
		assertEquals(compteServiceTest.getCompteById(64).getUser().getLastname(), "Martinez");
		assertEquals(compteServiceTest.getCompteById(64).getUser().getAuthorities().size(), 1);
		assertEquals(compteServiceTest.getCompteById(64).getSolde(), new Double(10000.0));
		assertEquals(compteServiceTest.getCompteById(64).getType(), Compte.CompteType.ESPECE);
	}
}
