
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;

public class Error403Page extends AbstractPage {

	@Override
	public void isAt() {
		assertThat(title()).isEqualTo("Error 403");
	}

}
