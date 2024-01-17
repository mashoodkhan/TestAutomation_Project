package com.hrsoft.driver.manager.web.remote.seleniumgrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.techsol.config.ConfigFactory;

public final class seleniumGridFirefoxManager {

	private seleniumGridFirefoxManager() {}

	public static WebDriver getDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(ConfigFactory.getConfig().browser().name());
		return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(), capabilities);
	}

}
