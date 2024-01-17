package com.hrsoft.driver.manager.web.local;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxManager {

	private FirefoxManager() {}
	
	static DesiredCapabilities cap;
	static FirefoxOptions ffOptions;
	static FirefoxProfile ffProfile;
	
	public static FirefoxDriver getDriver() {
		WebDriverManager.firefoxdriver().clearDriverCache().setup();
		WebDriverManager.firefoxdriver().driverVersion("47").setup();
		cap = new DesiredCapabilities();
		ffOptions = new FirefoxOptions();
		ffProfile = new FirefoxProfile();
		ffProfile.setPreference("browser.download.dir", "target/downloadedFiles/");
		ffProfile.setPreference("browser.download.folderList", 2);
		// no inspection SpellCheckingInspection
		ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", ffOptions.setProfile(ffProfile));
		ffOptions.setCapability("webSocketUrl", true);
		cap.setAcceptInsecureCerts(true);
		ffOptions.merge(cap);
		return new FirefoxDriver(ffOptions);
	}
}
