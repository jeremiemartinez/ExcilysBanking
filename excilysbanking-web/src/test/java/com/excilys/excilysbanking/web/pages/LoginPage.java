
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
	}
}
