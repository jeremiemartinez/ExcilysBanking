
package com.excilys.excilysbanking.webservices.rest.impl;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.excilys.excilysbanking.dto.CompteDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.webservices.rest.CompteServiceRS;

@Path("/services/CompteServiceRS")
public class CompteServiceRSImpl implements CompteServiceRS {
	
	@Autowired
	@Qualifier("compteToCompteDTOConverter")
	private Converter<Compte, CompteDTO> converter;
	
	@Autowired
	private CompteService compteService;
	
	@Override
	@GET
	@Produces("application/json")
	@Path("/comptes/{username}")
	public List<CompteDTO> getComptesByUsername(@PathParam("username") String username) {
		return converter.convert(compteService.getComptesByUsername(username));
	}
	
}
