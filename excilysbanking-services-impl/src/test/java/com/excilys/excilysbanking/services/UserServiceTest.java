
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
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.entities.Authority;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserDAO userDAOTest;

	@InjectMocks
	private UserServiceImpl userServiceTest;

	private User userTest;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		userTest = new User("jmartinez", "password", "Jeremie", "Martinez");
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority(0, Authority.AuthorityType.ROLE_USER));
		userTest.setAuthorities(authorities);
		List<Compte> comptes = new ArrayList<Compte>();
		comptes.add(new Compte(42, 2000.0, Compte.CompteType.ESPECE, userTest));
		userTest.setComptes(comptes);
		when(userDAOTest.findUserByUsername("jmartinez")).thenReturn(userTest);
	}

	@Test
	public void getUserByUsernameTest() {
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getFirstname(), "Jeremie");
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getLastname(), "Martinez");
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getAuthorities().size(), 1);
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getComptes().size(), 1);
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getComptes().get(0).getCompte_id(), new Integer(42));
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getComptes().get(0).getSolde(), new Double(2000.0));
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getComptes().get(0).getType(), Compte.CompteType.ESPECE);
		assertEquals(userServiceTest.getUserByUsername("jmartinez").getComptes().get(0).getUser(), userTest);
	}

}
