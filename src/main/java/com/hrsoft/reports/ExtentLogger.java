package com.hrsoft.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.Markup;

import java.io.PrintStream;

public class ExtentLogger {

	public static int MIN_LOGGING_LEVEL = 10;

	public static final int DEBUG = 10;
	public static final int INFO = 20;
	public static final int WARN = 30;
	public static final int ERROR = 40;
	public static final int FATAL = 50;

	private ExtentLogger() {
		// private to avoid initialization
	}

	public static void debug(String message) {
		log(DEBUG, message);
	}

	public static void info(String message) {
		log(INFO, message);
	}

	public static void pass(String message) {
		log(INFO, message);
	}

	public static void warn(String message) {
		log(WARN, message);
	}

	public static void warning(String message) {
		log(30, message);
	}

	public static void error(String message) {
		log(ERROR, message);
	}

	public static void fatal(String message) {
		log(FATAL, message);
	}

	private static void log(int status, String message) {
		if (status < MIN_LOGGING_LEVEL)
			return;

		if (ExtentListener.testReport.get() != null)
			ExtentListener.testReport.get().log(getExtentStatus(status), message);
		else
			printToConsole(status, message);
	}

	private static Status getExtentStatus(int status) {
		if (status <= 20)
			return Status.INFO;
		if (status == 30)
			return Status.WARNING;
		else
			return Status.FAIL;
	}

	private static void printToConsole(int status, String message) {
		if (status == 10) {
			System.out.println("[DEBUG] " + message);
		} else if (status == 20) {
			System.out.println("[INFO] " + message);
		} else if (status == 30) {
			System.err.println(ANSI_YELLOW + "[WARN] " + message + ANSI_RESET);
		} else if (status == 40) {
			System.err.println(ANSI_RED + "[ERROR] " + message + ANSI_RESET);
		} else if (status == 50) {
			System.err.println(ANSI_RED + "[FATAL] " + message + ANSI_RESET);
		}
	}

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_YELLOW = "\u001B[33m";

}
