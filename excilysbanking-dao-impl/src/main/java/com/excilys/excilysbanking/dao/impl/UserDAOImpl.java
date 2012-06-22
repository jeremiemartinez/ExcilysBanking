
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.QUser.user;
import java.util.List;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.User;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAOQueryDSLHelper implements UserDAO {
	
	@Autowired
	private SessionFactory sessions;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User findUserByUsername(String username) {
		log.debug("Calling Method findUserByUsername");
		User user = (User) sessions.getCurrentSession().get(User.class, username);
		Assert.notNull(user, "Login does not exist...");
		return user;
	}
	
	@Override
	public List<User> findAllUsers() {
		log.debug("Calling Method findAllUsers");
		return query().from(user).list(user);
	}
	
	public void setSessions(SessionFactory sessions) {
		this.sessions = sessions;
	}
	
}
