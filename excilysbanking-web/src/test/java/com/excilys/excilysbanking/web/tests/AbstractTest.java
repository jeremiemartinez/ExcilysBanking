
package com.excilys.excilysbanking.web.tests;

import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class AbstractTest extends FluentTest {
	
	public WebDriver webDriver = new HtmlUnitDriver();
	
	@Override
	public WebDriver getDefaultDriver() {
		return webDriver;
	}
	
	void logout() {
		goTo("/ebank/j_spring-security_logout");
	}
	
}
