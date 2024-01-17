package com.hrsoft.utils.owner.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.hrsoft.enums.WebRemoteModeType;

public class StringToBrowserRemoteModeType implements Converter<WebRemoteModeType> {
	
	private  StringToBrowserRemoteModeType() {}

	@Override
	public WebRemoteModeType convert(Method method, String nrowserRemoteMode) {
		
		return WebRemoteModeType.valueOf(nrowserRemoteMode);
	}
	

}
