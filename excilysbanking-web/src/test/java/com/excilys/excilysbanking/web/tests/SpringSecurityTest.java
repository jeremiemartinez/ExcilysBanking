
package com.excilys.excilysbanking.web.tests;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.excilys.excilysbanking.web.pages.AdminPage;
import com.excilys.excilysbanking.web.pages.ComptesPage;
import com.excilys.excilysbanking.web.pages.LoginPage;
import com.excilys.excilysbanking.web.pages.LogoutPage;

public class SpringSecurityTest extends FluentTest {

	public WebDriver webDriver = new HtmlUnitDriver();

	@Page
	public LoginPage loginPage;

	@Page
	public LogoutPage logoutPage;

	@Page
	public ComptesPage comptesPage;

	@Page
	public AdminPage adminPage;

	@Test
	public void TestLoginAndLogoutWorking() {
		goTo(loginPage);
		assertThat(loginPage).isAt();
		loginPage.fillAndSubmitForm("jmartinez", "lucestunbizu");
		assertThat(comptesPage).isAt();
		goTo(loginPage);
		assertThat(comptesPage).isAt();
		goTo(logoutPage);
		assertThat(loginPage).isAt();
	}

	@Test
	public void TestLoginAndLogoutWorkingForAdmin() {
		goTo(loginPage);
		assertThat(loginPage).isAt();
		loginPage.fillAndSubmitForm("lponnau", "chucknorris");
		assertThat(adminPage).isAt();
		goTo(loginPage);
		assertThat(adminPage).isAt();
		goTo(comptesPage);
		assertThat(comptesPage).isAt();
		goTo(logoutPage);
		assertThat(loginPage).isAt();
	}

	@Test
	public void TestLoginAndLogoutNotWorking() {
		goTo(loginPage);
		assertThat(loginPage).isAt();
		loginPage.fillAndSubmitForm("false", "false");
		assertThat(loginPage).isAt();
		loginPage.containsLoginFailError();
	}

	@Test
	public void TestAnonymousAccessAccount() {
		goTo(comptesPage);
		assertThat(loginPage).isAt();
	}

	@Override
	public WebDriver getDefaultDriver() {
		return webDriver;
	}

}
