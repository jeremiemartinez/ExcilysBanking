
package com.excilys.excilysbanking.webservices.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.excilys.excilysbanking.dto.CompteDTO;

@Path("/services/CompteServiceRS")
@Produces("application/json")
public interface CompteServiceRS {
	
	@GET
	@Path("/comptes/{username}")
	public List<CompteDTO> getComptesByUsername(@PathParam("username") String username);
	
}
