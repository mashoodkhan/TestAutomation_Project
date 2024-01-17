package com.hrsoft.utils.owner.converters;

import java.lang.reflect.Method;
import java.util.Map;

import org.aeonbits.owner.Converter;

import com.hrsoft.enums.BrowserType;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {

	@Override
	public BrowserType convert(Method method, String browserValue) {
		
		Map<String, BrowserType> browserTypeMap =
		Map.of("CHROME", BrowserType.CHROME, "EDGE", BrowserType.EDGE, "FIREFOX", BrowserType.FIREFOX);
		
		// Default browser set to CHROME
		return(browserTypeMap.getOrDefault(browserValue,BrowserType.CHROME));
	}

}
