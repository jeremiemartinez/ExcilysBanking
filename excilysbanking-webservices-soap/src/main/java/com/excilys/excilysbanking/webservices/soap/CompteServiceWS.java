
package com.excilys.excilysbanking.webservices.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.excilys.excilysbanking.dto.CompteDTO;

@WebService
public interface CompteServiceWS {

	@WebMethod
	public List<CompteDTO> getComptesByUsername(@WebParam String username);

	@WebMethod
	public List<CompteDTO> getAllComptes();

	@WebMethod
	public CompteDTO getCompteById(@WebParam Integer id);

}
