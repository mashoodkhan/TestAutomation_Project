package com.hrsoft.test.setuphelpers;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.Status;
import com.google.common.util.concurrent.Uninterruptibles;
import com.hrsoft.driver.Driver;
import com.hrsoft.driver.DriverManager;
import com.hrsoft.reports.ExtentListener;
import com.hrsoft.utils.files.FileUtils;

public class WebBaseTest {

	protected SoftAssertions softAssertions;
	protected ValidationsHelper validationsHelper;
	protected long sleepInMillis = 500;
	protected int webdriverWait = 10;
	protected long millisDuration = 30000l; // 30sec
	protected long millisPoll = 1000l; // 1
	protected boolean checkAjaxCalls = true;

	@BeforeSuite
	public void setupFramework() throws IOException {
		FileUtils.moveFilesToArchive();

	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		Driver.initDriverWeb();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		softAssertions = new SoftAssertions();
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		softAssertions.assertAll();
		Driver.quitDriver();
	}

	public void doWait(long milliSeconds) {
		Uninterruptibles.sleepUninterruptibly(milliSeconds, TimeUnit.MILLISECONDS);
	}

//    public void pass (String message) {
//        ExtentListener.testReport.get ().log (Status.PASS, message);
//    }
//
//    public void fail (String message) {
//        ExtentListener.testReport.get ().log (Status.FAIL, message);
//    }

}
