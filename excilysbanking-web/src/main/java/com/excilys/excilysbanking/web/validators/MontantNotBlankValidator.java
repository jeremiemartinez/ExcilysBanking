
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsBlank;

public class MontantNotBlankValidator implements ConstraintValidator<MontantIsBlank, Double> {

	@Override
	public void initialize(MontantIsBlank constraintAnnotation) {}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value == null)
			return false;
		else
			return true;
	}

}
