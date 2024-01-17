package com.techsol.gui;

import static com.hrsoft.driver.DriverManager.getDriver;
import static com.hrsoft.reports.ExtentLogger.info;
import static com.hrsoft.reports.ExtentLogger.pass;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hrsoft.gui.rewardsview.ManagerViewPage;
import com.hrsoft.utils.seleniumfy.BasePage;
import com.techsol.config.ConfigFactory;

public class LinkedInPage extends BasePage {

	private LoginPage lp = new LoginPage();

	private String profileBtn = "//span[@class='global-nav__primary-link-text' and text()='Me']";
	private String myNetworkTab = "//span[@title='My Network']";
	private String jobsTab = "//span[@title='Jobs']";
	private String messageTab = "//span[@title='Messaging']";
	private String notificationsTab = "//span[@title='Notifications']";

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions
				.visibilityOfElementLocated(locateBy("//li-icon[@type='app-linkedin-bug-color-icon']"));
	}

	public LoginPage logOut() {
		switchToDefaultContent();
		lp.loadUrl("https://www.linkedin.com/m/logout");
		return (LoginPage) navigateToPage(LoginPage.class);
	}

	public MyNetwork clickMyNetworkTab() {
		assertTrue(click(myNetworkTab));
		return new MyNetwork();
	}
	
	public JobsPage clickJobs() {
		assertTrue(click(jobsTab));
		return new JobsPage();
	}
	
	public Messaging clickMessaging() {
		assertTrue(click(messageTab));
		return new Messaging();
	}
	public Notifications clickNotifications() {
		assertTrue(click(notificationsTab));
		return new Notifications();
	}
	

}
