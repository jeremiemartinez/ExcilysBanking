
package com.excilys.excilysbanking.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.excilysbanking.services.CompteService;
import com.excilys.excilysbanking.web.validators.constraints.MontantGreaterThanSolde;
import com.excilys.excilysbanking.web.views.VirementForm;

public class MontantSoldeValidator implements ConstraintValidator<MontantGreaterThanSolde, VirementForm> {

	@Autowired
	private CompteService compteService;

	private MontantGreaterThanSolde mgts;

	@Override
	public void initialize(MontantGreaterThanSolde constraintAnnotation) {

	}

	@Override
	public boolean isValid(VirementForm value, ConstraintValidatorContext context) {
		Double solde = compteService.getComptesById(value.getCompteDebit()).getSolde();
		if (solde.compareTo((value.getMontant()));
	}
}