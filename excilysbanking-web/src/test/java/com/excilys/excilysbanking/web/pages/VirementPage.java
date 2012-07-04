
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import org.fluentlenium.core.domain.FluentWebElement;

public class VirementPage extends AbstractPage {
	
	@Override
	public String getUrl() {
		return BASE_URL + "/secured/virement";
	}
	
	public void fillAndSubmitForm(String compteDebit, String compteCredit, String montant) {
		int credit = (compteCredit.equals("6464")) ? 0 : 1;
		int debit = (compteDebit.equals("6464")) ? 0 : 1;
		((FluentWebElement) find("select", withId("compteDebit")).find("option").get(credit)).click();
		((FluentWebElement) find("select", withId("compteCredit")).find("option").get(debit)).click();
		fill("#montant").with(montant);
		click("#submit");
	}
	
	public void hasErrorCompteIdAreTheSame() {
		assertThat(find("#errorVirement")).hasSize(1);
	}
	
	public void hasErrorCompteCreditIsBlank() {
		assertThat(find("#errorCompteCredit")).hasSize(1);
	}
	
	public void hasErrorCompteCreditIsNotValid() {
		assertThat(find("#errorCompteCredit")).hasSize(1);
	}
	
	public void hasErrorCompteDebitIsBlank() {
		assertThat(find("#errorCompteDebit")).hasSize(1);
	}
	
	public void hasErrorCompteDebitIsNotValid() {
		assertThat(find("#errorCompteDebit")).hasSize(1);
	}
	
	public void hasErrorMontantisBlank() {
		assertThat(find("#errorMontant")).hasSize(1);
	}
	
	public void hasErrorMontantisValid() {
		assertThat(find("#errorMontant")).hasSize(1);
	}
	
	public void hasErrorMontantIsTooBig() {
		assertThat(find("#errorVirement")).hasSize(1);
	}
	
}
