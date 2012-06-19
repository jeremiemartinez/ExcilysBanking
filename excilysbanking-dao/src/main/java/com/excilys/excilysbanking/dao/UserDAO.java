
package com.excilys.excilysbanking.dao;

import java.util.List;
import javax.validation.constraints.NotNull;
import com.excilys.excilysbanking.entities.User;

public interface UserDAO {

	User findUserByLogin(@NotNull String param);

	List<User> findAllUsers();

}
