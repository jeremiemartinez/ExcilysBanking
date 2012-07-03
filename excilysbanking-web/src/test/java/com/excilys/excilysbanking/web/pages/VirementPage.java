
package com.excilys.excilysbanking.web.pages;

public class VirementPage extends AbstractPage {
	
	@Override
	public String getUrl() {
		return BASE_URL + "/index";
	}
	
	public void fillAndSubmitForm(String... paramsOrdered) {
		fill(".form-horizontal").with(paramsOrdered);
		click(".btn");
	}
	
}
