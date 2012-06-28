
package com.excilys.excilysbanking.dao.impl;

import static com.excilys.excilysbanking.entities.QCompte.compte;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.excilys.excilysbanking.dao.CompteDAO;
import com.excilys.excilysbanking.dao.impl.base.AbstractDAOQueryDSLHelper;
import com.excilys.excilysbanking.entities.Compte;

@Repository("compteDAO")
public class CompteDAOImpl extends AbstractDAOQueryDSLHelper implements CompteDAO {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Compte> findComptesByUsername(String username) {
		log.debug("Calling Method findComptesByUsername");
		return query().from(compte).where(compte.user.username.eq(username)).list(compte);
	}

	@Override
	public List<Compte> findAllComptes() {
		log.debug("Calling Method findAllComptes");
		return query().from(compte).list(compte);
	}

}