
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsNotBlank;

public class MontantNotBlankValidator implements ConstraintValidator<MontantIsNotBlank, String> {

	@Override
	public void initialize(MontantIsNotBlank constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.isEmpty())
			return false;
		else
			return true;
	}

}
