
package com.excilys.excilysbanking.web.views;

import javax.validation.constraints.NotNull;
import com.excilys.excilysbanking.web.validators.constraints.MontantGreaterThanSolde;

@MontantGreaterThanSolde
public class VirementForm {

	@NotNull
	public Integer compteDebit;

	@NotNull
	public Integer compteCredit;

	public Double montant;

	public String libelle;

	public Integer getCompteDebit() {
		return compteDebit;
	}

	public void setCompteDebit(Integer compteDebit) {
		this.compteDebit = compteDebit;
	}

	public Integer getCompteCredit() {
		return compteCredit;
	}

	public void setCompteCredit(Integer compteCredit) {
		this.compteCredit = compteCredit;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
