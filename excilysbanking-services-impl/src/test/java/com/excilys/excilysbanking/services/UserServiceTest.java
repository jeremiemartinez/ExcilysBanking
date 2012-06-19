
package com.excilys.excilysbanking.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserDAO userDAOTest;

	@InjectMocks
	private UserServiceImpl userServiceTest;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		when(userDAOTest.findUserByLogin("jmartinez")).thenReturn(new User("jmartinez", "password", "Jeremie Martinez", "0652776432", "French"));
	}

	@Test
	public void findByLoginTest() {
		assertEquals(userServiceTest.getUserByLogin("jmartinez").getName(), "Jeremie Martinez");
	}
}
