package com.hrsoft.utils.owner.converters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.aeonbits.owner.Converter;

import lombok.SneakyThrows;

public class StringToURLConverter implements Converter<URL> {

	@SneakyThrows
	@Override
	public URL convert(Method method, String selemiumGridURL) {
		
		try {
			return new URL(selemiumGridURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
