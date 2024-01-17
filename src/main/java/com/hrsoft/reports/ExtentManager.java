package com.hrsoft.reports;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hrsoft.driver.DriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

	public class ExtentManager {

		private static ExtentReports extent;

		public static ExtentReports createInstance(String fileName) {
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
			final File CONF = new File(System.getProperty("user.dir") + "/src/test/resources/SparkConfig.xml");
			try {
				sparkReporter.loadXMLConfig(CONF);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//sparkReporter.config().setReportName(fileName.substring(fileName.lastIndexOf("/")+1));
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Automation Tester", "HRSoft Automation Team");
			extent.setSystemInfo("Organization", "HR SOft");
			extent.setSystemInfo("Environment", "SQA");
			return extent;
		}

		public static String screenshotPath;
		public static String screenshotName;

		public static void captureScreenshot(ITestResult result) {
			
			 Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverManager.getDriver());
			 Date d = new Date();	
	         screenshotName = d.toString().replace(":", "_").replace(" ", "_")+"_" +result.getMethod().getMethodName().toString().substring(0,5).trim()+".jpg";

				try {
					ImageIO.write(screenshot.getImage(), "jpg",
							new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
					setScreenshotName( screenshotName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		public static String getScreenshotName() {
			return screenshotName;
		}

		public static void setScreenshotName(String screenshotName) {
			ExtentManager.screenshotName = screenshotName;
		}

		}




