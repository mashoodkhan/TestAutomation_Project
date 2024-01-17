package com.hrsoft.driver.manager.web.remote.seleniumgrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hrsoft.enums.BrowserType;
import com.techsol.config.ConfigFactory;

public final class seleniumGridChromeManager {
	
	private seleniumGridChromeManager() {}

	public static WebDriver getDriver() {
		DesiredCapabilities capb = new DesiredCapabilities();
		capb.setBrowserName(BrowserType.CHROME.name());
		return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(),capb);
	}

}
