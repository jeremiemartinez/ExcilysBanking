
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.web.validators.constraints.MontantIsValid;
import com.excilys.excilysbanking.web.views.VirementForm;

public class MontantSoldeValidator implements ConstraintValidator<MontantIsValid, VirementForm> {

	@Autowired
	private CompteService compteService;

	@Override
	public void initialize(MontantIsValid constraintAnnotation) {}

	@Override
	public boolean isValid(VirementForm value, ConstraintValidatorContext context) {
		if (value == null)
			return false;
		else {
			try {
				Double solde = compteService.getCompteById(value.getCompteDebit()).getSolde();
				if (solde.compareTo(Double.valueOf(value.getMontant())) > 0)
					return true;
				else
					return false;
			} catch (NumberFormatException e) {
				return true;
			}

		}
	}
}