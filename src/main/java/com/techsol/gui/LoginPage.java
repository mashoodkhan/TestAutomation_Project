package com.techsol.gui;

import static com.hrsoft.reports.ExtentLogger.*;
import static com.techsol.config.ConfigFactory.*;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hrsoft.driver.DriverManager;
import com.hrsoft.utils.seleniumfy.BasePage;

public class LoginPage extends BasePage {

    private String username       = "#session_key";
    private String password       = "#session_password";
    private String loginBtn       = "//button[@data-id='sign-in-form__submit-btn']";
    private String settingsBtn    = "//i[@class='fal fa-cog fa-2x   font-icon  text-none']";
    
    @SuppressWarnings("unchecked")
	@Override
	protected ExpectedCondition getPageLoadCondition() {
    	return ExpectedConditions.visibilityOfElementLocated(locateBy (loginBtn));
	}

    public LoginPage navigatedToLoginPage () {
        assertTrue (waitUntilVisible ("//h1[text()='Login to TalentCenter']"));
        assertTrue (hasPageLoaded ());
        return this;
    }

    public LoginPage enterUsername () {
        assertTrue (setText (username, getConfig ().userName ()));
        return this;
    }

    public LoginPage enterUsername (String user) {
        assertTrue (setText (username, user));
        return this;
    }

    public LoginPage enterPassword () {
        assertTrue (setText (password, getConfig ().password ()));
        return this;
    }

    public LoginPage enterPassword (String pass) {
        assertTrue (setText (password, pass));
        return this;
    }

    public LinkedInPage clickLogin () {
        assertTrue (click (loginBtn));
        return new LinkedInPage ();
    }

    public LoginPage clickLoginAndReturnLoginPage () {
        assertTrue (click (loginBtn));
        return this;
    }

    public LinkedInPage logIn () {

        enterUsername (getConfig ().userName ());
        enterPassword (getConfig ().password ());
        clickLogin ();
        assertTrue (hasPageLoaded ());
        info ("Logged in as: " + getConfig ().userName ());
        return (LinkedInPage) navigateToPage(LinkedInPage.class);
    }

    public String getLoginError () {
        return getText ("div.app-title");
    }

    public void returnToLogin () {
        assertTrue (click ("a#return-login"));
    }

    public LinkedInPage logInAndRefresh () {
        enterUsername (getConfig ().userName ());
        enterPassword (getConfig ().password ());
        clickLogin ();
        refresh ();
        info ("Logged in as: " + getConfig ().userName ());
        return (LinkedInPage) navigateToPage(LinkedInPage.class);
    }

    public LinkedInPage logIn (String user, String pass) {
        enterUsername (user);
        enterPassword (pass);
        clickLogin ();
        assertTrue (hasPageLoaded ());
        info ("Logged in as: " + user);
        return (LinkedInPage) navigateToPage(LinkedInPage.class);
    }

    public LinkedInPage logInAndRefresh (String user, String pass) {
        enterUsername (user);
        enterPassword (pass);
        clickLogin ();
        assertTrue (hasPageLoaded ());
        refresh ();
        info ("Logged in as: " + user);
        return (LinkedInPage) navigateToPage(LinkedInPage.class);
    }

    public String getAttribute (String text) {
        String attrValue = getAttribute (username, text);
        return attrValue;
    }

    public String getLoginCss (String text) {
        String css = getCssValue (loginBtn, text);
        return css;
    }

    

    public LoginPage clickReturnToLogin () {
        click ("#return-login");
        return this;
    }

    public  LoginPage loadUrl (String applicationURL) {
        DriverManager.getDriver ().get (applicationURL);
        return this;
    }

	

}
