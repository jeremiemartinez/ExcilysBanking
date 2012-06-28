
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

	@SuppressWarnings("unchecked")
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		userTest = new User.Builder().username("jmartinez").password("password").firstname("Jeremie").lastname("Martinez").build();

		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority.Builder().id(0).type(Authority.AuthorityType.ROLE_USER).build());

		List<Compte> comptes = new ArrayList<Compte>();
		Compte compte = new Compte.Builder().id(6464).solde(2000.0).type(Compte.CompteType.ESPECE).user(userTest).build();
		comptes.add(compte);
		userTest.setAuthorities(authorities);
		userTest.setComptes(comptes);

		when(userDAOTest.findUserByUsername("jmartinez")).thenReturn(userTest);
		when(userDAOTest.findUserByUsername(null)).thenThrow(IllegalArgumentException.class);
		when(userDAOTest.findUserByUsername("")).thenThrow(IllegalArgumentException.class);
	}

	@Test
	public void getUserByUsernameTest() {
		User user = userServiceTest.getUserByUsername("jmartinez");
		assertEquals("Jeremie", user.getFirstname());
		assertEquals("Martinez", user.getLastname());
		assertEquals(1, user.getAuthorities().size());
		assertEquals(1, user.getComptes().size());
		assertEquals(Integer.valueOf(6464), user.getComptes().get(0).getId());
		assertEquals(Double.valueOf(2000), user.getComptes().get(0).getSolde());
		assertEquals(Compte.CompteType.ESPECE, user.getComptes().get(0).getType());
		assertEquals(userTest, user.getComptes().get(0).getUser());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getUserByNullUsernameTest() {
		userServiceTest.getUserByUsername(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getUserByEmptyUsernameTest() {
		userServiceTest.getUserByUsername("");
	}

}
