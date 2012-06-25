
package com.excilys.excilysbanking.services;

import java.util.List;
import org.springframework.security.core.Authentication;
import com.excilys.excilysbanking.entities.User;

public interface UserService {

	User getUserByUsername(String username);

	List<User> getAllUsers();

	boolean isConnected(Authentication auth);

	boolean isAdmin(Authentication auth);

	User getConnectedUser();

}
