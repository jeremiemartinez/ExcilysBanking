
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
import com.excilys.excilysbanking.dao.CompteDAO;
import com.excilys.excilysbanking.entities.Compte;

@Repository("compteDAO")
public class CompteDAOImpl implements CompteDAO {

	@Autowired
	private SessionFactory sessions;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Compte> findComptesByUsername(String username) {
		log.debug("Calling Method findComptesByUsername");
		String query = "SELECT c from Compte c where c.user=:username";
		Session session = sessions.getCurrentSession();
		Query results = session.createQuery(query).setString("username", username);
		return results.list();
	}

	@Override
	public Compte findCompteById(Integer id) {
		log.debug("Calling Method findCompteById");
		Compte compte = (Compte) sessions.getCurrentSession().get(Compte.class, id);
		Assert.notNull(compte, "Compte does not exist...");
		return compte;
	}

	@Override
	public List<Compte> findAllComptes() {
		log.debug("Calling Method findAllComptes");
		String query = "SELECT c from Compte c ";
		Session session = sessions.getCurrentSession();
		Query results = session.createQuery(query);
		return results.list();
	}

}
