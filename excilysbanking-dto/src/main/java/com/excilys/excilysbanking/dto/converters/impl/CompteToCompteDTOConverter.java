
package com.excilys.excilysbanking.dto.converters.impl;

import org.springframework.stereotype.Component;
import com.excilys.excilysbanking.dto.CompteDTO;
import com.excilys.excilysbanking.dto.converters.Converter;
import com.excilys.excilysbanking.entities.Compte;

@Component("compteToCompteDTOConverter")
public class CompteToCompteDTOConverter extends Converter<Compte, CompteDTO> {

	@Override
	public CompteDTO convert(Compte s) {
		return new CompteDTO.Builder().id(s.getId()).solde(s.getSolde()).type(s.getType()).user(s.getUser().getUsername()).build();
	}

}
