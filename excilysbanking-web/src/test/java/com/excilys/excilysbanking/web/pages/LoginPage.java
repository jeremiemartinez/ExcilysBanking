
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

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

	public void isEnglish() {
		assertThat(find("#moduleConnection", withText("Connection"))).hasSize(1);
	}

	public void isFrench() {
		assertThat(find("#moduleConnection", withText("Connexion"))).hasSize(1);
	}

	public void changeLangageToFr() {
		click("#fr");
	}

	public void changeLangageToEn() {
		click("#en");
	}

}
