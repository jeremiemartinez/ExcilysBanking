
package com.excilys.excilysbanking.web.tests;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import com.excilys.excilysbanking.web.pages.LoginPage;
import com.excilys.excilysbanking.web.pages.LogoutPage;
import com.excilys.excilysbanking.web.pages.OperationsPage;

public class OperationsTest extends AbstractTest {

	@Page
	public LoginPage loginPage;

	@Page
	public LogoutPage logoutPage;

	@Page
	public OperationsPage operationsPage;

	@Test
	public void TestOperationsWorkingWithAjax() {
		goTo(loginPage);
		assertThat(loginPage).isAt();
		loginPage.fillAndSubmitForm("jmartinez", "lucestunbizu");
		goTo(operationsPage);
		assertThat(operationsPage).isAt();
		operationsPage.ajaxWorking();
		await().atMost(2000).until("#35").hasSize(1);
		goTo(logoutPage);

	}
}
