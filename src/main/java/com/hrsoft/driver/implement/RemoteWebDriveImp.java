package com.hrsoft.driver.implement;

import org.openqa.selenium.WebDriver;

import com.hrsoft.driver.IWebDriver;
import com.hrsoft.driver.entity.WebDriverData;
import com.hrsoft.driver.factory.web.remote.RemoteDriverFactory;

public class RemoteWebDriveImp implements IWebDriver {

	@Override
	public WebDriver getDriver(WebDriverData webDriverData) {

		return RemoteDriverFactory.getDriver(webDriverData.getWebRemoteModeType(), webDriverData.getBrowserType());
	}

}
