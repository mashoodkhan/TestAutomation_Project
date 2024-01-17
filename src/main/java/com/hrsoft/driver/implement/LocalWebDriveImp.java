package com.hrsoft.driver.implement;

import org.openqa.selenium.WebDriver;

import com.hrsoft.driver.IWebDriver;
import com.hrsoft.driver.entity.WebDriverData;
import com.hrsoft.driver.factory.web.local.LocalDriverFactory;

public class LocalWebDriveImp implements IWebDriver {

	@Override
	public WebDriver getDriver(WebDriverData webDriverData) {

		return LocalDriverFactory.getDriver(webDriverData.getBrowserType());
	}
}
