package com.hrsoft.gui.rewardsview;

import static java.lang.String.format;
import static org.testng.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.hrsoft.enums.ManagerViewTabsType;
import com.hrsoft.reports.ExtentLogger;
import com.hrsoft.utils.seleniumfy.BasePage;

/**
 * @author Annameni Srinivas*
 *         <a href="mailto:annameni.srinivas@hrsoft.com">annameni.srinivas@hrsoft.com</a>
 */

public class ManagerViewPage extends BasePage {

    private String selectDropDown           = "[placeholder='Select a Compensation Plan']";
    private String planName                 = "//div[contains(@class,'webix_popup')][contains(@style,'display: block;')]//div[text()='%s']";
    private String compensationStatement    = "a[nav-title='Compensation Statement']";
    private String openSearchButton         = "button[data-content='Search']>i.fa-search";
    private String employeeTab              = "//span[text()='By Employee']/parent::a";
    private String downloadBtn              = "i.fa-arrow-alt-circle-down.font-icon";
    private String downloadBulkbtn          = "//i[@class='far fa-file-archive   font-icon  ']";
    private String searchingPleaseWait      = "//h5[text()='Searching...Please wait']";
    private String pleaseWait               = "//h5[text()='Please wait...']";
    private String employee                 = "(//span[text()='%s'])";
    private String selectAllCheckBoxes      = "(//div[@class='webix_hcell webix_first webix_last center webix_last_row webix_span']//input[@type='checkbox'])";
    private String share                    = "(//button[@data-content=\"Share with all selected employees\"])[2]";
    private String confirm                  = "//button[contains(@class,'btn btn-primary btn-md')]";
    private String okPopUp                  = "[class='btn btn-secondary btn-md']";
    private String horizontalTabs           = "ul[id$='339113015646596'][id*='NAVIGATION'][subnavtype='horizontal'] > li > a";
    private String horizontalTab            = "ul[id$='339113015646596'][subnavtype='horizontal'] > li >a[nav-title='%s']";
    private String managerFirstNameTextBox  = "input[id*='text_input'][id$='INPUT_8b55d382'][placeholder='Enter first name...']";
    private String managerLastNameTextBox   = "input[id*='text_input'][id$='INPUT_a8c76ccc'][placeholder='Enter last name...']";
    private String managerEmpIdTextBox      = "input[id*='text_input'][id$='INPUT_44d4f2ee'][placeholder='Enter Employee Id...']";
    private String employeefirstNameTextBox = "input[id*='text_input'][id$='INPUT_dc60c8c2'][placeholder='Enter first name...']";
    private String employeelastNameTextBox  = "input[id*='text_input'][id$='INPUT_9ed9c90f'][placeholder='Enter last name...']";
    private String employeeEmpIdTextBox   	= "input[id*='text_input'][id$='INPUT_b3c00c16'][placeholder='Enter Employee Id...']";
    private String searchInGridButton       = "div[itemid='BUTTON_8c81fd3b'] > button";
    private String searchInGridEmployeeButton = "div[itemid='BUTTON_dde01402'] > button";

    private String resultRowSelectButton    = "a[title='Select']>i.far.fa-check-circle";
    private String mngrFirstNameColumnCells = "[id$='GRID_1703328221919181'] div.webix_ss_center div.webix_column:nth-child(1) > div[role='gridcell']";
    private String mngrRowColumnCells       = "[id$='GRID_1703328221919181'] div.webix_ss_center div.webix_column > div[role='gridcell']";
    
    private String empResultRowSelectButton    = "a[title='Select']";
    private String empFirstNameColumnCells = "[id$='GRID_7468a3a8'] div.webix_ss_center div.webix_column:nth-child(1) > div[role='gridcell']";
    private String empRowColumnCells       = "div[id$='GRID_7468a3a8'] div.webix_ss_center div.webix_column > div[role='gridcell']";

    
    @Override
	protected ExpectedCondition getPageLoadCondition() {
    	return ExpectedConditions.visibilityOfElementLocated(locateBy (openSearchButton));
	}
    
    public ManagerViewPage selectPlan (String plan) {
        assertTrue (click (selectDropDown));
        assertTrue (click (format (planName, plan)));
        return this;
    }

    public ManagerViewPage clickToOpenSearch () {
        assertTrue (click (openSearchButton));
        return this;
    }
    
    public ManagerViewPage selectSearch () {
        assertTrue (click (openSearchButton));
        return this;
    }

    public ManagerViewPage clickCompensationStatement () {
        assertTrue (click (compensationStatement));
        return this;
    }

    public ManagerViewPage enterManager (String firstName, String lastName) {
        assertTrue (setText ("input[placeholder='Enter first name...']", firstName));
        assertTrue (setText ("input[placeholder='Enter last name...']", lastName));
        return this;
    }

    public ManagerViewPage enterManagerAndSearch (String firstName, String lastName) {
        enterManager (firstName,lastName);
        assertTrue (click ("(//span[text()='Search'])[2]"));
        assertTrue (waitForElementInvisible (searchingPleaseWait));
        assertTrue (click (resultRowSelectButton));
        ExtentLogger.info ("selected "+firstName+" "+lastName +" as manager");
        return this;
    }

    public ManagerViewPage selectAllCheckBoxes () {
        assertTrue (click (selectAllCheckBoxes + "[2]"));
        return this;
    }

    public ManagerViewPage clickShareAndConfirm () {
        assertTrue (click (share));
        assertTrue (click (confirm));
        assertTrue (waitForElementInvisible (pleaseWait));
        return this;
    }

    public ManagerViewPage clickEmployee (String empName) {
        assertTrue (click (format (employee, empName)));
        return this;
    }

    public ManagerViewPage clickReset () {
        assertTrue (click ("[data-content='Reset the view']"));
        return this;
    }

    public ManagerViewPage clickDownload () {
        assertTrue (click (downloadBtn));
        assertTrue (waitForElementInvisible (".modal-body .bootbox-body"));
        return this;
    }

    public ManagerViewPage clickDownloadFromRecentDownload () {
        assertTrue (click ("(//a[@title=\"Download\"])[1]"));
        return this;
    }

    public ManagerViewPage clickBulkDownload () {
        assertTrue (click (downloadBulkbtn));
        String ok = "button[id$='BUTTON_344146230498775']";
        assertTrue (click (ok));
        doWait (5000);
        String pop ="//button[@class='btn btn-secondary btn-md']";
        if(isElementPresent (pop))
        assertTrue (click (pop));
        return this;
    }

    public ManagerViewPage clickRecentDownload () {
        assertTrue (click ("[data-content='Recent Downloads']"));
        return this;
    }

    public boolean isRecentDownloadsPresent () {
        return isElementPresent ("(//div[@class='webix_ss_body'])[12]");
    }

    public boolean isErrorPresent () {
        return isElementVisible (".modal-body");
    }

    public ManagerViewPage clickOk () {
        assertTrue (click (okPopUp));
        return this;
    }

    public ManagerViewPage closePopUp () {
        assertTrue (click ("[class='bootbox-close-button close']"));
        return this;
    }

    public boolean isDefaultTabSelected (ManagerViewTabsType tabNameType) {
        Optional <WebElement> defaultTab = 
    	getHorizontalTabs ()
    		.stream ()
    		.filter (tab -> tab.getText ().trim ()
    		.equals (tabNameType.getName ()))
    		.findFirst ();
        return defaultTab.isPresent () ? defaultTab.get ().getAttribute ("class").contains ("active") : false;
    }

    public boolean checkAllFourTabs () {
        return Stream.of (ManagerViewTabsType.DASHBOARD.getName (),
                          ManagerViewTabsType.MY_TEAM.getName (),
                          ManagerViewTabsType.COMPENSATION_STATEMENT.getName (),
                          ManagerViewTabsType.REPORTS.getName ())
                     .allMatch (tabName -> getHorizontalTabs ().stream ()
                                                               .anyMatch (tab -> tab.getText ().trim ()
                                                                                    .equals (tabName)));
    }

    public ManagerViewPage searchForManagerByFieldAndverifyResult (String firstName, String lastName) {
        searchForManagerByFirstName (firstName);
        searchForManagerByLastName (lastName);
//        searchForManagerByEmployeeId (manager.getEmployeeId ());

        return this;
    }
    
    public ManagerViewPage searchForEmployeeByFieldAndverifyResult (String firstName, String lastName) {
        searchForEmployeeByFirstName (firstName);
        searchForEmployeeByLastName (lastName);
//        searchForEmployeeByEmployeeId (manager.getEmployeeId ());

        return this;
    }

    private ManagerViewPage verifyResultInGrid (String searchedText) {
        List <WebElement> gridFirstNameCols = waitForElementsVisible (mngrFirstNameColumnCells);
        Assert.assertTrue (gridFirstNameCols.size () > 0, "Failed to display the result grid, aborting test");
        boolean allNameMatch = waitForElementsVisible (mngrRowColumnCells).stream ().map (WebElement::getText)
                                                                          .anyMatch (text -> text.contains (searchedText));

        if (allNameMatch) {
            ExtentLogger.info ("The searched text found in one of the column cell");
        } else {
            ExtentLogger.info ("The searched text not found in any of the column cell");
        }
        return this;
    }
    
    private ManagerViewPage verifyEmpResultInGrid (String searchedText) {
        List <WebElement> gridFirstNameCols = waitForElementsVisible (empFirstNameColumnCells);
        Assert.assertTrue (gridFirstNameCols.size () > 0, "Failed to display the result grid, aborting test");
        boolean allNameMatch = waitForElementsVisible (empRowColumnCells).stream ().map (WebElement::getText)
                                                                          .anyMatch (text -> text.contains (searchedText));

        if (allNameMatch) {
            ExtentLogger.info ("The searched text found in one of the column cell");
        } else {
            ExtentLogger.info ("The searched text not found in any of the column cell");
        }
        return this;
    }

    public ManagerViewPage selectManagerFromGrid () {

        return this;
    }

    private ManagerViewPage clickOnSearchAndWait () {
        click (searchInGridButton);
        waitForElementInvisible (searchingPleaseWait);
        return this;
    }
    
    private ManagerViewPage clickOnEmployeeSearchAndWait(){
    	click (searchInGridEmployeeButton);
        waitForElementInvisible (searchingPleaseWait);
        return this;
    }

    private ManagerViewPage enterManagerFirstName (String firstName) {
        setText (managerFirstNameTextBox, firstName);
        return this;
    }

    private ManagerViewPage enterManagerLastName (String firstName) {
        setText (managerLastNameTextBox, firstName);
        return this;
    }

    private ManagerViewPage enterManagerEmployeeId (String firstName) {
        setText (managerEmpIdTextBox, firstName);
        return this;
    }
    
    private ManagerViewPage enterEmployeeFirstName (String firstName) {
        setText (employeefirstNameTextBox, firstName);
        return this;
    }

    private ManagerViewPage enterEmployeeLastName (String firstName) {
        setText (employeelastNameTextBox, firstName);
        return this;
    }

    private ManagerViewPage enterEmployeeEmployeeId (String firstName) {
        setText (employeeEmpIdTextBox, firstName);
        return this;
    }

    public ManagerViewPage selectEachTabAndVerify () {
        selectMyTeamTab ();
        selectCompenationTab ();
        selectReportsTab ();
        return this;
    }

    public ManagerViewPage selectMyTeamTab () {
        selectTab (ManagerViewTabsType.MY_TEAM.getName ());
        return this;
    }

    public ManagerViewPage selectCompenationTab () {
        selectTab (ManagerViewTabsType.COMPENSATION_STATEMENT.getName ());
        return this;
    }

    public ManagerViewPage selectReportsTab () {
        selectTab (ManagerViewTabsType.REPORTS.getName ());
        return this;
    }

    public ManagerViewPage selectTab (String managerViewTabName) {
        click (String.format (horizontalTab, managerViewTabName));
        return this;
    }

    public List <WebElement> getHorizontalTabs () {
        return findElements (horizontalTabs);
    }

    public ManagerViewPage selectDashBoardTab () {
        selectTab (ManagerViewTabsType.DASHBOARD.getName ());
        return this;
    }

    public ManagerViewPage searchForManagerByFirstName (String firstName) {
        enterManagerFirstName (firstName);
        clickOnSearchAndWait ();
        verifyResultInGrid (firstName);
        return this;
    }

    public ManagerViewPage searchForManagerByEmployeeId (String employeeId) {
        enterManagerEmployeeId (employeeId);
        clickOnSearchAndWait ();
        verifyResultInGrid (employeeId);
        return this;
    }

    public ManagerViewPage searchForManagerByLastName (String lastName) {
        enterManagerLastName (lastName);
        clickOnSearchAndWait ();
        verifyResultInGrid (lastName);
        return this;
    }
    
    public ManagerViewPage searchForEmployeeByFirstName (String firstName) {
        enterEmployeeFirstName(firstName);
        clickOnEmployeeSearchAndWait ();
        verifyEmpResultInGrid (firstName);
        return this;
    }

    private ManagerViewPage searchForEmployeeByEmployeeId (String employeeId) {
        enterEmployeeEmployeeId(employeeId);
        clickOnEmployeeSearchAndWait() ;
        verifyEmpResultInGrid (employeeId);
        return this;
    }

    private ManagerViewPage searchForEmployeeByLastName (String lastName) {
        enterEmployeeLastName(lastName);
        clickOnEmployeeSearchAndWait();
        verifyEmpResultInGrid (lastName);
        return this;
    }

    public ManagerViewPage clickSelectForTheROw () {
        click (resultRowSelectButton);
        return this;
    }
    
    public ManagerViewPage clickSelectForTheROwEmployee () {
        click (empResultRowSelectButton);
        return this;
    }

    public ManagerViewPage clickMyTeamTab () {
        assertTrue (click ("//span[@class='menu-item-text d-none d-lg-inline-block wrap-text' and text()='My Team']"));
        return this;
    }
    public boolean isMyTeamsEmployees () {
        return isElementPresent ("[itemid='GRID_LAYOUT_COLUMN_647494503530842']") ;
    }
    public boolean isCompensationStatementEmployees () {
        return isElementPresent ("[itemid=\"GRID_LAYOUT_COLUMN_1599168917715_d77a9367\"]") ;
    }

	public ManagerViewPage selectEmployeeTab() {
		assertTrue (click ("//span[text()='By Employee']/parent::a"));
		waitForElement(employeefirstNameTextBox);
		return this;
	}

}
