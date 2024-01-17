package com.hrsoft.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;

public class TestDataExcel {
	
	@Column(name="TestScriptName",index=0)
	private String testCase;
	
	@Column(name="ApplicationURL",index=1)
	private String applicationURL;
	
	@Column(name="UserName",index=2)
	private String userName;
	
	@Column(name="Password",index=3)
	private String password;
	

	public String getTestCase() {
		return testCase;
	}

	public String getApplicationURL() {
		return applicationURL;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "TestDataExcel [testCase=" + testCase + ", applicationURL=" + applicationURL + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
}