package com.hrsoft.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

import com.hrsoft.driver.entity.WebDriverData;
import com.hrsoft.driver.factory.DriverFactory;
import com.techsol.config.ConfigFactory;

public class Driver {

	private Driver() {
	}

	public static void initDriverWeb() {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverData webDriverData = new WebDriverData(ConfigFactory.getConfig().browser(),
					ConfigFactory.getConfig().browserRemoteMode());

			WebDriver driver = DriverFactory.getDriverForWeb(ConfigFactory.getConfig().runModeBrowser())
					.getDriver(webDriverData);
			DriverManager.setDriver(driver);
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver()))
			DriverManager.getDriver().quit();
		DriverManager.unload();
	}

	/**
	 * Place holder for a method to get mobile driver. To Be Implemented-This will
	 * extend the existing framework capabilities to mobile automation. Consider
	 * using fields runModeType, mobilePlatformType and mobileRemoteModeType
	 */
	public static void initDriverFoMobile() {
		/** */
	}

}