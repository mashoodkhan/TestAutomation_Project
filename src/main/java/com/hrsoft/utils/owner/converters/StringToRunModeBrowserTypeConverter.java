package com.hrsoft.utils.owner.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;
import com.hrsoft.enums.RunModeType;

public class StringToRunModeBrowserTypeConverter implements Converter<RunModeType> {
	
	@Override
	public RunModeType convert(Method method, String runModeBrowserType) {
		
		return RunModeType.valueOf(runModeBrowserType);
	}
	

}
