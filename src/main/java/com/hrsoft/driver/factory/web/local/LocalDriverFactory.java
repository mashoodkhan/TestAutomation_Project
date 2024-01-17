package com.hrsoft.driver.factory.web.local;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import com.hrsoft.driver.manager.web.local.ChromeManager;
import com.hrsoft.driver.manager.web.local.EdgeManager;
import com.hrsoft.driver.manager.web.local.FirefoxManager;
import com.hrsoft.enums.BrowserType;

public final class LocalDriverFactory {

	private LocalDriverFactory() {}
	
	private static final Map<BrowserType, Supplier<WebDriver>> BROWSERDRIVERMAP = new EnumMap<>(BrowserType.class);
	private static final Supplier<WebDriver> CHROME = ChromeManager::getDriver;
	private static final Supplier<WebDriver> EDGE = EdgeManager::getDriver;
	private static final Supplier<WebDriver> FIREFOX = FirefoxManager::getDriver;
	
	static {
		BROWSERDRIVERMAP.put(BrowserType.CHROME, CHROME);
		BROWSERDRIVERMAP.put(BrowserType.FIREFOX, FIREFOX);
		BROWSERDRIVERMAP.put(BrowserType.EDGE, EDGE);
	}

	public static WebDriver getDriver(BrowserType browserType) {
		return BROWSERDRIVERMAP.get(browserType).get();
		
	}
	
	
}
