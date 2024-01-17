package com.hrsoft.test.setuphelpers;


	
	import org.assertj.core.api.Assertions;
	import org.assertj.core.api.SoftAssertions;
import org.testng.ITestResult;
import org.testng.Reporter;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class ValidationsHelper {
	    private SoftAssertions softAssertions;
	    private Map<ITestResult, List<Throwable>> verificationFailuresMap;

	    public ValidationsHelper() {
	        softAssertions = new SoftAssertions();
	        verificationFailuresMap = new HashMap<>();
	    }

	    public void assertTrue(boolean condition) {
	        Assertions.assertThat(condition).isTrue();
	    }

	    public void assertTrue(boolean condition, String message) {
	        Assertions.assertThat(condition).as(message).isTrue();
	    }
	    
	    public void assertTrue(boolean condition, String asMessage, String withFailsMessage) {
	        Assertions.assertThat(condition).as(asMessage).isTrue().withFailMessage(withFailsMessage);
	    }

	    public void assertFalse(boolean condition) {
	        Assertions.assertThat(condition).isFalse();
	    }

	    public void assertFalse(boolean condition, String message) {
	        Assertions.assertThat(condition).as(message).isFalse();
	    }

	    public void assertEquals(boolean actual, boolean expected) {
	        Assertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void assertEquals(Object actual, Object expected) {
	        Assertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void assertEquals(Object[] actual, Object[] expected) {
	        Assertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void assertEquals(Object actual, Object expected, String message) {
	        Assertions.assertThat(actual).as(message).isEqualTo(expected);
	    }

	    public void verifyTrue(boolean condition) {
	        softAssertions.assertThat(condition).isTrue();
	    }

	    public void verifyTrue(boolean condition, String message) {
	        softAssertions.assertThat(condition).as(message).isTrue();
	    }
	    
	    public void verifyTrue(boolean condition, String asMessage, String failMessage) {
	        softAssertions.assertThat(condition).as(asMessage).isTrue().withFailMessage(failMessage);
	    }

	    public void verifyFalse(boolean condition) {
	        softAssertions.assertThat(condition).isFalse();
	    }

	    public void verifyFalse(boolean condition, String message) {
	        softAssertions.assertThat(condition).as(message).isFalse();
	    }

	    public void verifyEquals(boolean actual, boolean expected) {
	        softAssertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void verifyEquals(String actual, String expected) {
	        softAssertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void verifyEquals(int actual, int expected) {
	        softAssertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void verifyEquals(Object actual, Object expected) {
	        softAssertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void verifyEquals(Map<?, ?> actual, Map<?, ?> expected) {
	        softAssertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void verifyEquals(Object[] actual, Object[] expected) {
	        softAssertions.assertThat(actual).isEqualTo(expected);
	    }

	    public void fail(String message) {
	        Assertions.fail(message);
	    }

	    public List<Throwable> getVerificationFailures() {
	        List<Throwable> verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
	        return verificationFailures == null ? new ArrayList<Throwable>() : verificationFailures;
	    }

	    public void addVerificationFailure(Throwable e) {
	        List<Throwable> verificationFailures = getVerificationFailures();
	        verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
	        verificationFailures.add(e);
	    }

	    public void assertAll() {
	        softAssertions.assertAll();
	    }
	}   



