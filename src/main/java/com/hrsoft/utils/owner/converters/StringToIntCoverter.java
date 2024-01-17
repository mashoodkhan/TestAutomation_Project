package com.hrsoft.utils.owner.converters;

import java.lang.reflect.Method;
import org.aeonbits.owner.Converter;

public class StringToIntCoverter implements Converter<Integer>{

	@Override
	public Integer convert(Method method, String intValue) {
		return Integer.parseInt(intValue);
	}
}
