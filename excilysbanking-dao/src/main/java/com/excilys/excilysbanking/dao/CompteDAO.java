
package com.excilys.excilysbanking.dao;

import java.util.List;
import com.excilys.excilysbanking.entities.Compte;

public interface CompteDAO {

	List<Compte> findComptesByUsername(String username);

	List<Compte> findComptes();

	Compte findCompteById(Integer id);

	void update(Compte compte);

}
