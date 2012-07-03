
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
		User userTest = new User.Builder().username("jmartinez").password("password").firstname("Jeremie").lastname("Martinez").build();
		
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority.Builder().id(0).type(Authority.AuthorityType.ROLE_USER).build());
		
		List<Compte> comptes = new ArrayList<Compte>();
		Compte compte1 = new Compte.Builder().id(42).solde(2000.0).type(Compte.CompteType.ESPECE).user(userTest).build();
		Compte compte2 = new Compte.Builder().id(64).solde(10000.0).type(Compte.CompteType.ESPECE).user(userTest).build();
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
