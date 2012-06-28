
package com.excilys.excilysbanking.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.excilysbanking.dao.CompteDAO;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.services.CompteService;

@Service("compteService")
@Transactional(readOnly = true)
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteDAO compteDAO;

	@Override
	public List<Compte> getComptesByUsername(String username) {
		return compteDAO.findComptesByUsername(username);
	}

	@Override
	public List<Compte> getAllComptes() {
		return compteDAO.findComptes();
	}

}
