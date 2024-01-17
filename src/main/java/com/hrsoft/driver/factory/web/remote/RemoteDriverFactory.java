package com.hrsoft.driver.factory.web.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.hrsoft.enums.WebRemoteModeType;
import com.hrsoft.enums.BrowserType;


public class RemoteDriverFactory {
	
	private RemoteDriverFactory() {}
	
	private static final Map<WebRemoteModeType,  Function<BrowserType, WebDriver>> MAP = new EnumMap<>(WebRemoteModeType.class);
	private static final Function<BrowserType, WebDriver> SELENIUMGRID =   SeleniumGridFactory::getDriver;
	
	static {
		MAP.put(WebRemoteModeType.SELENIUMGRID, SELENIUMGRID);
	}
	
	public static WebDriver getDriver(WebRemoteModeType browserRemoteModeType, BrowserType browserType) {
		return MAP.get(browserRemoteModeType).apply(browserType);
	}
	

}
