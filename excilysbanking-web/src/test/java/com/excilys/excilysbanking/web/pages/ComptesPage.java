
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;

public class ComptesPage extends AbstractPage {

	@Override
	public String getUrl() {
		return BASE_URL + "/secured/comptes";
	}

	@Override
	public void isAt() {
		assertThat(title()).isEqualTo("Your accounts");
		assertThat(find(".table")).hasSize(1);
	}

	public void checkNumberOfAlerts(int alert) {
		assertThat(find(".alert")).hasSize(alert);
	}
}
