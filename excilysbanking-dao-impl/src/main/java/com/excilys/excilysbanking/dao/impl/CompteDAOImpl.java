
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.QCompte.compte;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import com.excilys.excilysbanking.dao.CompteDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.Compte;

@Repository("compteDAO")
public class CompteDAOImpl extends AbstractDAOQueryDSLHelper implements CompteDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompteDAOImpl.class);

	@Override
	public List<Compte> findComptesByUsername(String username) {
		LOGGER.debug("Calling Method findComptesByComptename");
		return query().from(compte).where(compte.user.username.eq(username)).list(compte);
	}

	@Override
	public List<Compte> findComptes() {
		LOGGER.debug("Calling Method findComptes");
		return query().from(compte).groupBy(compte).orderBy(compte.id.asc()).list(compte);
	}

	@Override
	public Compte findCompteById(Integer id) {
		LOGGER.debug("Calling Method findCompteById");
		Compte compte = (Compte) sessions.getCurrentSession().get(Compte.class, id);
		Assert.notNull(compte, "Compte does not exist");
		return compte;
	}

	@Override
	public void update(Compte compte) {
		sessions.getCurrentSession().update(compte);
	}

}
