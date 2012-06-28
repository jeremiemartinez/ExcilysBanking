
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.QUser.user;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.User;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAOQueryDSLHelper implements UserDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Override
	public User findUserByUsername(String username) {
		LOGGER.debug("Calling Method findUserByUsername");
		User user = (User) sessions.getCurrentSession().get(User.class, username);
		Assert.notNull(user, "Username does not exist");
		return user;
	}
	
	@Override
	public List<User> findAllUsers() {
		LOGGER.debug("Calling Method findAllUsers");
		return query().from(user).list(user);
	}
	
}
