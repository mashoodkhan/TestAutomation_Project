package com.hrsoft.driver;

import org.openqa.selenium.WebDriver;

import com.hrsoft.driver.entity.WebDriverData;

public interface IWebDriver {
	
	WebDriver getDriver(WebDriverData webDriverData);

}