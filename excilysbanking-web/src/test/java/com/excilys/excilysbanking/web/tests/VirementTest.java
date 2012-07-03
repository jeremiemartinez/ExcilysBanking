
package com.excilys.excilysbanking.web.tests;

import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import com.excilys.excilysbanking.web.pages.LoginPage;
import com.excilys.excilysbanking.web.pages.VirementPage;

public class VirementTest extends AbstractTest {
	
	@Page
	public LoginPage loginPage;
	
	@Page
	public VirementPage virementPage;
	
	@Before
	public void setUp() {
		logout();
		goTo(loginPage);
	}
	
	@Test
	public void normalCase() {
		
	}
	
	@Test
	public void noChanges() {
		
	}
	
	@Test
	public void noMontant() {
		
	}
	
	@Test
	public void montantIsNotANumber() {
		
	}
	
	@Test
	public void montantIsTooBig() {
		
	}
	
	@Test
	public void montantIsNegative() {
		
	}
	
	@Test
	public void comptesAreTheSame() {
		
	}
	
}
