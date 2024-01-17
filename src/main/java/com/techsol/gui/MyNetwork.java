package com.techsol.gui;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedCondition;

import com.hrsoft.utils.seleniumfy.BasePage;

public class MyNetwork extends BasePage {

	private String myNetworkTitle = "//h2[text()='Manage my network']";

	public void navigatedToMyNetworkPage() {
		assertTrue(isElementPresent(myNetworkTitle));
	}

	@Override
	protected ExpectedCondition<Boolean> getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
