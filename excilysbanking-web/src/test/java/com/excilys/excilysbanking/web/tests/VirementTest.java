
package com.excilys.excilysbanking.web.tests;

import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import com.excilys.excilysbanking.web.pages.ComptesPage;
import com.excilys.excilysbanking.web.pages.LoginPage;
import com.excilys.excilysbanking.web.pages.LogoutPage;
import com.excilys.excilysbanking.web.pages.VirementPage;

public class VirementTest extends AbstractTest {
	
	@Page
	public LoginPage loginPage;
	
	@Page
	public LogoutPage logoutPage;
	
	@Page
	public VirementPage virementPage;
	
	@Page
	public ComptesPage comptesPage;
	
	@Before
	public void setUp() {
		goTo(logoutPage);
		goTo(loginPage);
		loginPage.fillAndSubmitForm("jmartinez", "lucestunbizu");
		goTo(virementPage);
	}
	
	@Test
	public void normalCase() {
		virementPage.fillAndSubmitForm("6464", "2138962500", "2.5");
		comptesPage.isAt();
	}
	
	@Test
	public void noChanges() {
		virementPage.fillAndSubmitForm("", "", "");
		virementPage.hasErrorCompteIdAreTheSame();
		virementPage.hasErrorMontantisBlank();
	}
	
	@Test
	public void noMontant() {
		virementPage.fillAndSubmitForm("6464", "2138962500", "");
		virementPage.hasErrorMontantisBlank();
	}
	
	@Test
	public void montantIsNotANumber() {
		virementPage.fillAndSubmitForm("6464", "2138962500", "qsdf");
		virementPage.hasErrorMontantisValid();
	}
	
	@Test
	public void montantIsTooBig() {
		virementPage.fillAndSubmitForm("6464", "2138962500", "99999");
		virementPage.hasErrorMontantisValid();
	}
	
	@Test
	public void montantIsNegative() {
		virementPage.fillAndSubmitForm("6464", "2138962500", "-1");
		virementPage.hasErrorMontantisValid();
	}
	
	@Test
	public void comptesAreTheSame() {
		virementPage.fillAndSubmitForm("6464", "6464", "1");
		virementPage.hasErrorCompteIdAreTheSame();
	}
	
	@Test
	public void noCompteCredit() {
		virementPage.fillAndSubmitForm("6464", "", "1");
		virementPage.hasErrorCompteCreditIsNull();
	}
	
	@Test
	public void compteCreditIsNotANumber() {
		virementPage.fillAndSubmitForm("6464", "qsdf", "1");
		virementPage.hasErrorCompteCreditIsNotValid();
	}
	
	@Test
	public void compteCreditNotExist() {
		virementPage.fillAndSubmitForm("6464", "12", "1");
		virementPage.hasErrorCompteCreditIsNotValid();
	}
	
	@Test
	public void noCompteDebit() {
		virementPage.fillAndSubmitForm("", "2138962500", "-1");
		virementPage.hasErrorCompteDebitIsNull();
	}
	
	@Test
	public void compteDebitIsNotANumber() {
		virementPage.fillAndSubmitForm("qsdf", "2138962500", "-1");
		virementPage.hasErrorCompteDebitIsNotValid();
	}
	
	@Test
	public void compteDebitNotExist() {
		virementPage.fillAndSubmitForm("12", "2138962500", "-1");
		virementPage.hasErrorCompteDebitIsNotValid();
	}
	
}
