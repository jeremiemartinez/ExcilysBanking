
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.User;

public interface UserService {

	User getUserByLogin(String login);

	List<User> getAllUsers();
}
