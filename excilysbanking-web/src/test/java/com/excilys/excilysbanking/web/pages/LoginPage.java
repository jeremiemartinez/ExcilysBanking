
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;

public class LoginPage extends AbstractPage {

	@Override
	public String getUrl() {
		return BASE_URL + "/index";
	}

	@Override
	public void isAt() {
		assertThat(title()).isEqualTo("The Big Bank Theory");
		assertThat(find("#moduleConnection")).hasSize(1);
	}

	public void fillAndSubmitForm(String username, String password) {
		fill("#j_username").with(username);
		fill("#j_password").with(password);
		click("#submit");
	}

	public void containsLoginFailError() {
		assertThat(find("#errorLogin")).hasSize(1);
	}
}
