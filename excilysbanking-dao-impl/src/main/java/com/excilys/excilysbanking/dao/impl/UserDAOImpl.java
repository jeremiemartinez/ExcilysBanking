
package com.excilys.excilysbanking.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.entities.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		log.debug("Calling Method findAllUsers");
		String query = "SELECT u from User u ";
		Session session = sessions.getCurrentSession();
		Query results = session.createQuery(query);
		return results.list();
	}

	public void setSessions(SessionFactory sessions) {
		this.sessions = sessions;
	}

}
