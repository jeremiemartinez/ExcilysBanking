
package com.excilys.excilysbanking.services;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
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
		
		List<Compte> comptes = new ArrayList<Compte>();
		Compte compte1 = new Compte(42, 2000.0, Compte.CompteType.ESPECE, userTest);
		Compte compte2 = new Compte(64, 10000.0, Compte.CompteType.ESPECE, userTest);
		comptes.add(compte1);
		comptes.add(compte2);
		
		userTest.setComptes(comptes);
		userTest.setAuthorities(authorities);
		// ...
		
	}
	
	// The service has no business logic !
	// No need to test our mocks...
	
	@Test
	public void emptyTest() {
		Assert.assertTrue(true);
	}
}
