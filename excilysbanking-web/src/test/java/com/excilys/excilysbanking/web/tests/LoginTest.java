
package com.excilys.excilysbanking.web.tests;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.excilys.excilysbanking.web.pages.LoginPage;

public class LoginTest extends FluentTest {

	public WebDriver webDriver = new HtmlUnitDriver();

	@Page
	public LoginPage page;

	@Before
	public void before() {
		goTo(page);
	}

	@Test
	public void test_no_exception() {
		assertThat(page).isAt();
	}

	@Override
	public WebDriver getDefaultDriver() {
		return webDriver;
	}

}
