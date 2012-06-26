
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
		userTest = new User("jmartinez", "password", "Jeremie", "Martinez");
		
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority(0, Authority.AuthorityType.ROLE_USER));
		
		List<Compte> comptes = new ArrayList<Compte>();
		comptes.add(new Compte(42, 2000.0, Compte.CompteType.ESPECE, userTest));
		
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
		assertEquals(Integer.valueOf(42), user.getComptes().get(0).getCompte_id());
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
