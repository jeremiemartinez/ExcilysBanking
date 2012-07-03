
package com.excilys.excilysbanking.web.pages;

public class VirementPage extends AbstractPage {
	
	@Override
	public String getUrl() {
		return BASE_URL + "/index";
	}
	
	public void fillAndSubmitForm(String compteDebit, String compteCredit, String montant) {
		fill("#compteDebit").with(compteDebit);
		fill("#compteCredit").with(compteCredit);
		fill("#montant").with(montant);
		click("#submit");
	}
	
	public void hasErrorCompteIdAreTheSame() {
		// find("#errorVirement");...
	}
	
	public void hasErrorCompteCreditIsNull() {
		
	}
	
	public void hasErrorCompteCreditIsNotValid() {
		
	}
	
	public void hasErrorCompteDebitIsNull() {
		
	}
	
	public void hasErrorCompteDebitIsNotValid() {
		
	}
	
	public void hasErrorMontantisBlank() {
		
	}
	
	public void hasErrorMontantisValid() {
		
	}
	
}
