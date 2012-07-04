
package com.excilys.excilysbanking.webservices.soap.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.excilysbanking.dto.CompteDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.webservices.soap.CompteServiceWS;

@WebService(endpointInterface = "com.excilys.formation.webservice.UserServiceWs")
public class CompteServiceWSImpl implements CompteServiceWS {

	@Autowired
	private Converter<Compte, CompteDTO> converter;

	@Autowired
	private CompteService compteService;

	@Override
	@WebMethod
	public List<CompteDTO> getComptesByUsername(@WebParam String username) {
		return converter.convert(compteService.getComptesByUsername(username));
	}

	@Override
	@WebMethod
	public List<CompteDTO> getAllComptes() {
		return converter.convert(compteService.getAllComptes());
	}

	@Override
	@WebMethod
	public CompteDTO getCompteById(@WebParam Integer id) {
		return converter.convert(compteService.getCompteById(id));
	}

}
