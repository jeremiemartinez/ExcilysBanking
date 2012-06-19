
package com.excilys.excilysbanking.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import com.excilys.excilysbanking.dao.UserDAO;
import com.excilys.excilysbanking.entities.User;

@Repository("userDAO")
@Validated
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessions;

	@Override
	public User findUserByLogin(String param) {

		User user = (User) sessions.getCurrentSession().get(User.class, param);
		Assert.notNull(user, "Login does not exist...");
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		String query = "SELECT u from User u ";
		Session session = sessions.getCurrentSession();
		Query results = session.createQuery(query);
		return results.list();
	}

	public void setSessions(SessionFactory sessions) {
		this.sessions = sessions;
	}

}
