
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.excilysbanking.entities.Compte;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.web.validators.constraints.CompteIdIsValid;

public class CompteIdValidator implements ConstraintValidator<CompteIdIsValid, Integer> {

	@Autowired
	private CompteService compteService;

	@Override
	public void initialize(CompteIdIsValid constraintAnnotation) {}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		Compte compte = compteService.getCompteById(value);
		if (compte == null)
			return false;
		else
			return true;
	}

}
