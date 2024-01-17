package com.hrsoft.utils.zerocell;

import java.io.File;
import java.util.List;

import com.creditdatamw.zerocell.Reader;
import com.hrsoft.constants.Constants;

public final class ExcelReader {

	private ExcelReader() {}
	
	private static List<TestDataExcel> TestData = null; 
	
	
	public static List<TestDataExcel> getTestData() {
		return TestData;
	}


	static    
	{
		 TestData = Reader.of(TestDataExcel.class)
				.from(new File(Constants.SMOKE_TEST_MASTER))
				.sheet("TestData")
				.skipHeaderRow(true)
				.skipEmptyRows(true)
				.list();
		
	}
	
}
