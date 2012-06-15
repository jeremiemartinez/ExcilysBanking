
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.User;

public interface UserService {

	public User getUserByLogin(String login);

	public List<User> getAllUsers();
}
