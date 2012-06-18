
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.User;

public interface UserDAO {

	User findUserByLogin(String param);

	List<User> findAllUsers();

}
