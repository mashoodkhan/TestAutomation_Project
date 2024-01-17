package com.hrsoft.test.common;

import org.testng.annotations.Test;

import com.hrsoft.constants.AutomationTester;
import com.hrsoft.constants.ComponentGroups;
import com.hrsoft.constants.AutomationTester;
import com.hrsoft.constants.TestGroups;
import com.hrsoft.dataprovider.DataProviders;
import com.hrsoft.test.setuphelpers.WebBaseTest;
import com.hrsoft.utils.zerocell.TestDataExcel;
import com.techsol.annotations.Author;
import com.techsol.gui.JobsPage;
import com.techsol.gui.LinkedInPage;
import com.techsol.gui.LoginPage;
import com.techsol.gui.Messaging;
import com.techsol.gui.MyNetwork;
import com.techsol.gui.Notifications;

public class LoginLogoutTestSuite extends WebBaseTest {

	@Author(name = AutomationTester.WEBTECHIESOL)
	@Test(groups = { TestGroups.SMOKE,
			ComponentGroups.LinkedInLOGIN }, dataProviderClass = DataProviders.class, dataProvider = "SmokeTest")
	public void ST001_ST002_LoginAndLogout(TestDataExcel data) {
		LoginPage login = new LoginPage().loadUrl(data.getApplicationURL());
		login.refresh();
		LinkedInPage lp = login.logIn(data.getUserName(), data.getPassword());
		lp.logOut();

	}

	@Author(name = AutomationTester.WEBTECHIESOL)
	@Test(groups = { TestGroups.SMOKE,
			ComponentGroups.LinkedInLOGIN }, dataProviderClass = DataProviders.class, dataProvider = "SmokeTest")
	public void ST003_Validate_Navigating_To_CorrectPages(TestDataExcel data) {
		LoginPage login = new LoginPage().loadUrl(data.getApplicationURL());
		login.refresh();
		LinkedInPage homePage = login.logIn(data.getUserName(), data.getPassword());
		MyNetwork mn = homePage.clickMyNetworkTab();
		JobsPage jobs = homePage.clickJobs();
		Messaging msg = homePage.clickMessaging();
		Notifications notify = homePage.clickNotifications();
		homePage.logOut();

	}
}
