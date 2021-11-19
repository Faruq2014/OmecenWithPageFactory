package com.Omecen.ExtentReportManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Omecen.Base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BaseTest{
	private static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentReports createInstance(String filename) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(filename);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// ExtentHtmlReporter reporter is for setting up look and feel environment.
		reporter.config().setDocumentTitle("Omecen Automation Report"); // Tile of report
		reporter.config().setReportName("Regression Testing"); // Name of the report
		reporter.config().setDocumentTitle("utf-8");
		 reporter.config().setTheme(Theme.STANDARD);
		//reporter.config().setTheme(Theme.DARK);
		
		//ExtentReports extent; is setting environment with the help of java system class. 
		extent.setSystemInfo("User name", System.getProperty("user.name"));
		extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		extent.setSystemInfo("User Location", System.getProperty("user.country"));
		extent.setSystemInfo("OS name", System.getProperty("os.name"));
		extent.setSystemInfo("OS version", System.getProperty("os.version"));
		extent.setSystemInfo("JDK version", System.getProperty("java.version"));
		extent.setSystemInfo("Selenium version", "3.141.59");
		extent.setSystemInfo("Maven version", "3.15"); // you can write any thing.
		
		return extent;
		  
		
	}
	
	public static String getScreenshot(WebDriver driver, String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + screenShotName + System.currentTimeMillis()
				+ ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;

	}

	public static String getScreenshot2(WebDriver driver, String screenShotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshot/" + screenShotName + dateName + ".png";
		File finaldestination = new File(destination);

		FileUtils.copyFile(src, finaldestination);

		return destination;

	}

}
