package com.hrsoft.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import com.hrsoft.utils.zerocell.ExcelReader;

public class DataProviders {
	
	
	/** Data provider for smoke test*/ 
	@DataProvider(name = "SmokeTest", parallel = false)
	public Object[] getData(Method m) {

		return ExcelReader.getTestData()
				.stream()
				.filter(o -> o.getTestCase()
				.equalsIgnoreCase(m.getName())).toArray();
	}
}
