
package com.excilys.excilysbanking.web.validators;

import java.lang.annotation.Annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompteDebitValidator implements ConstraintValidator {

	@Override
	public void initialize(Annotation constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}
