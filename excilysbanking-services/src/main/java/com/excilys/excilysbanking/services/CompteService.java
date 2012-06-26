
package com.excilys.excilysbanking.services;

import java.util.List;
import com.excilys.excilysbanking.entities.Compte;

public interface CompteService {
	
	List<Compte> getComptesByUsername(String username);
	
	List<Compte> getAllComptes();
	
}
