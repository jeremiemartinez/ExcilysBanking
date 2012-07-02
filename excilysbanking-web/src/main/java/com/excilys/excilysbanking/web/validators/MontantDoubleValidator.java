
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsDouble;

public class MontantDoubleValidator implements ConstraintValidator<MontantIsDouble, String> {

	@Override
	public void initialize(MontantIsDouble constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			Double.valueOf(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
