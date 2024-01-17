package com.hrsoft.driver.factory.web.remote;

import org.openqa.selenium.WebDriver;

import com.hrsoft.driver.manager.web.remote.seleniumgrid.seleniumGridChromeManager;
import com.hrsoft.driver.manager.web.remote.seleniumgrid.seleniumGridFirefoxManager;
import com.hrsoft.enums.BrowserType;

public final class SeleniumGridFactory {
	
	private SeleniumGridFactory() {}
	
	public static WebDriver getDriver(BrowserType browserType) {
		
		return browserType==BrowserType.CHROME
				?seleniumGridChromeManager.getDriver()
				:seleniumGridFirefoxManager.getDriver();	
	}
}
