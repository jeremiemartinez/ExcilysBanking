
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsNotBlank;

public class MontantValidator implements ConstraintValidator<MontantIsNotBlank, Double> {

	@Override
	public void initialize(MontantIsNotBlank constraintAnnotation) {}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value == null)
			return false;
		else
			return true;

	}
}