
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsPositive;

public class MontantPositiveValidator implements ConstraintValidator<MontantIsPositive, Double> {

	@Override
	public void initialize(MontantIsPositive constraintAnnotation) {}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value != null) {
			if (value.compareTo(new Double(0)) > 0)
				return true;
			else
				return false;
		} else {
			return true;
		}
	}

}
