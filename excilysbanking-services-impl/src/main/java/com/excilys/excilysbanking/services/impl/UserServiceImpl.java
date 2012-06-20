
package com.excilys.excilysbanking.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.entities.User;
import com.excilys.excilysbanking.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUserByLogin(String login) {
		// return userDAO.findUserByLogin(login);
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.findAllUsers();
	}

}
