
package com.excilys.excilysbanking.webservices.rest;

import java.util.List;
import com.excilys.excilysbanking.dto.CompteDTO;

public interface CompteServiceRS {

	public List<CompteDTO> getComptesByUsername(String username);

}
