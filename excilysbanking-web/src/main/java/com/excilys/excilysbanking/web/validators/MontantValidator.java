
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsValid;

public class MontantValidator implements ConstraintValidator<MontantIsValid, String> {

	@Autowired
	private CompteService compteService;

	@Override
	public void initialize(MontantIsValid constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			Double d = Double.valueOf(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
