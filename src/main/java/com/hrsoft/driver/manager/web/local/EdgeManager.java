package com.hrsoft.driver.manager.web.local;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class EdgeManager {

	private EdgeManager() {}

	public static EdgeDriver getDriver() {

		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		options.addArguments("--disable-notifications");
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("excludeSwitches", new String[] { "load-extension", "enable-automation" });
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--start-maximized"); 
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
	
		options.merge(cap);
		return new EdgeDriver(options);

	}
}
