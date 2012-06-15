
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.User;

public interface UserDAO {

	public User findUserByLogin(String param);

	public List<User> findAllUsers();

}
