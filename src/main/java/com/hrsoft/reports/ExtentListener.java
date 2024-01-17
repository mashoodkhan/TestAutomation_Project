package com.hrsoft.reports;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.techsol.annotations.Author;

public class ExtentListener implements ITestListener {

    public static ThreadLocal <ExtentTest> testReport = new ThreadLocal <ExtentTest> ();
    private static String                  TestcaseName;

    static Date                            d          = new Date ();
    static String                          fileName   = "HRSoft_Automation_" + d.toString ().replace (":", "_")
                                                                                .replace (" ", "_") + ".html";
    public static ExtentReports            extent     = ExtentManager.createInstance (System.getProperty ("user.dir") + "/reports/" + fileName);

    public static String getTestcaseName () {
        return TestcaseName;
    }

    public static void setTestcaseName (String testcaseName) {
        TestcaseName = testcaseName;
    }
    public ExtentTest test;

    public void onTestStart (ITestResult result) {
         test = extent.createTest (result.getMethod ().getMethodName ());

        ITestNGMethod method = result.getMethod ();
        String component = Arrays.stream (method.getGroups ())
                                 .filter (group -> group.startsWith ("Component."))
                                 .map (group -> group.substring (group.indexOf (".") + 1))
                                 .findFirst ()
                                 .orElse (null);

        if (component != null) {
            test.assignCategory ("Component - " + component);
        }

        ConstructorOrMethod constructorOrMethod = method.getConstructorOrMethod ();
        Method javaMethod = constructorOrMethod.getMethod ();
        Annotation[] declaredAnnotations = javaMethod.getDeclaredAnnotations ();
        String authorName = Arrays.stream (declaredAnnotations)
                                  .filter (annotation -> annotation instanceof Author)
                                  .map (annotation -> (Author) annotation)
                                  .map (Author::name)
                                  .findFirst ()
                                  .orElse (null);

        if (authorName != null) {
            test.assignAuthor (authorName);
        }

        testReport.set (test);
        TestcaseName = result.getMethod ().getMethodName ();
        testReport.get ().info ("Test scipt execution started: " + TestcaseName);
        System.out.println ("Test Started: " + TestcaseName);

    }

    public void onTestSuccess (ITestResult result) {
        String methodName = result.getMethod ().getMethodName ();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase () + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel (logText, ExtentColor.GREEN);
        testReport.get ().pass (m);
        System.out.println ("\u001B[32m" + "Test Passed : " + TestcaseName + "\n" + "=".repeat (50) + "\u001B[0m");
        if(Objects.nonNull(testReport.get ())){
            testReport.remove();
        }

    }

    public void onTestFailure (ITestResult result) {

        String exceptionMessage = result.getThrowable ().getMessage () + "\n";
        exceptionMessage = exceptionMessage + Arrays.toString (result.getThrowable ().getStackTrace ());
        testReport.get ()
                  .fail ("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see" + "</font>" + "</b >" + "</summary>" + exceptionMessage.replaceAll (",",
                                                                                                                                                                                            "<br>") + "</details>" + " \n");

        ExtentManager.captureScreenshot (result);
        testReport.get ().fail ("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                                MediaEntityBuilder.createScreenCaptureFromPath (ExtentManager.screenshotName).build ());

        String failureLogg = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel (failureLogg, ExtentColor.RED);
        testReport.get ().log (Status.FAIL, m);
        System.err.println ("Test Failed : " + TestcaseName + "\n" + "=".repeat (50));
        if(Objects.nonNull(testReport.get ())){
            testReport.remove();
        }

    }

    public void onTestSkipped (ITestResult result) {
        String exceptionMessage = result.getThrowable ().getMessage () + "\n";
        exceptionMessage = exceptionMessage + Arrays.toString (result.getThrowable ().getStackTrace ());
        
        String methodName = result.getMethod ().getMethodName ();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel (logText, ExtentColor.YELLOW );
        testReport.get ().skip (m+exceptionMessage);
        System.out.println ("\u001B[33m" + "Test Skipped : " + TestcaseName + "\n" + "=".repeat (50) + "\u001B[0m");
        if(Objects.nonNull(testReport.get ())){
            testReport.remove();
        }
    
    }

    public void onTestFailedButWithinSuccessPercentage (ITestResult result) {

    }

    public void onStart (ITestContext context) {
        //Change logging level to desired level to print the log to console or report
        ExtentLogger.MIN_LOGGING_LEVEL = ExtentLogger.DEBUG;
    }

    public void onFinish (ITestContext context) {

        if (extent != null) {
            extent.flush ();
        }
        
    }

}
