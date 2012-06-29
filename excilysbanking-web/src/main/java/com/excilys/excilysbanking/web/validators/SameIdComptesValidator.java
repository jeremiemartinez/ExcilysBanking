
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.excilys.excilysbanking.web.validators.constraints.ComptesIdAreTheSame;
import com.excilys.excilysbanking.web.views.VirementForm;

public class SameIdComptesValidator implements ConstraintValidator<ComptesIdAreTheSame, VirementForm> {

	@Override
	public void initialize(ComptesIdAreTheSame constraintAnnotation) {}

	@Override
	public boolean isValid(VirementForm value, ConstraintValidatorContext context) {
		if (value.getCompteCredit().equals(value.compteDebit))
			return false;
		else
			return true;
	}

}
