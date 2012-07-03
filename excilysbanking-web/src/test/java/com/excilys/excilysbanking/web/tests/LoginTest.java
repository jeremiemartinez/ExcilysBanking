
package com.excilys.excilysbanking.web.tests;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import com.excilys.excilysbanking.web.pages.LoginPage;

public class LoginTest extends AbstractTest {
	
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
	
}
