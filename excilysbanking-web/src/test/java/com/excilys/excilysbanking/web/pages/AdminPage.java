
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;

public class AdminPage extends AbstractPage {

	@Override
	public String getUrl() {
		return BASE_URL + "/secured/admin/admin";
	}

	@Override
	public void isAt() {
		assertThat(title()).isEqualTo("Administrator Interface");
		assertThat(find("#tableUsers")).hasSize(1);
		assertThat(find("#tableComptes")).hasSize(1);
	}

}
