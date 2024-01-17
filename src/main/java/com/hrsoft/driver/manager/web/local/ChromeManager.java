package com.hrsoft.driver.manager.web.local;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class ChromeManager {

	private ChromeManager() {}

	public static ChromeDriver getDriver() {

		WebDriverManager.chromedriver().setup();
//	    System.setProperty ("webdriver.chrome.driver",System.getProperty ("user.dir")+"/src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("excludeSwitches", new String[] { "load-extension", "enable-automation" });
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--start-maximized"); //maximize window

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		options.merge(cap);
		return new ChromeDriver(options);

	}
}
