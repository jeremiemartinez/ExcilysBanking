
package com.excilys.excilysbanking.web.tests;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import com.excilys.excilysbanking.web.pages.LoginPage;
import com.excilys.excilysbanking.web.pages.LogoutPage;

public class InternationalizationTest extends AbstractTest {

	@Page
	public LoginPage loginPage;

	@Page
	public LogoutPage logoutPage;

	@Test
	public void TestInternationalization() {
		goTo(loginPage);
		assertThat(loginPage).isAt();
		loginPage.changeLangageToFr();
		assertThat(loginPage).isAt();
		loginPage.isFrench();
		goTo(logoutPage);
		assertThat(loginPage).isAt();
	}

}
