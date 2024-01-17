package com.hrsoft.utils.owner.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.hrsoft.enums.RunModeType;

public class StringToRunModeTypeCoverter implements Converter<RunModeType>{

	@Override
	public RunModeType convert(Method method, String runModeType) {
		return RunModeType.valueOf(runModeType.toUpperCase());
	}
	

}
