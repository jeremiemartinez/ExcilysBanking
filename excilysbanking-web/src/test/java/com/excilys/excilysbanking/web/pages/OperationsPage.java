
package com.excilys.excilysbanking.web.pages;

import static org.fest.assertions.Assertions.assertThat;

public class OperationsPage extends AbstractPage {

	@Override
	public String getUrl() {
		return BASE_URL + "/secured/operations/id/6464/year/2012/month/6";
	}

	@Override
	public void isAt() {
		assertThat(title()).isEqualTo("Your Operations");
		assertThat(find(".table")).hasSize(2);
	}

	public void ajaxWorking() {
		click("#detailsCarte");
	}
}
