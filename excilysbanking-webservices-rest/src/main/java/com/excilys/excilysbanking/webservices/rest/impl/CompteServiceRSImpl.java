
package com.excilys.excilysbanking.webservices.rest.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.excilys.excilysbanking.dto.CompteDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.webservices.rest.CompteServiceRS;

public class CompteServiceRSImpl implements CompteServiceRS {
	
	@Autowired
	@Qualifier("compteToCompteDTOConverter")
	private Converter<Compte, CompteDTO> converter;
	
	@Autowired
	private CompteService compteService;
	
	@Override
	public List<CompteDTO> getComptesByUsername(String username) {
		return converter.convert(compteService.getComptesByUsername(username));
	}
	
}
