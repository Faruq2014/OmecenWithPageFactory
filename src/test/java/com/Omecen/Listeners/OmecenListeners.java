package com.Omecen.Listeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Omecen.Base.BaseTest;
import com.Omecen.ExtentReportManager.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class OmecenListeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	static Date d = new Date(System.currentTimeMillis());
	static String filenameString = "Extent_Report" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    static String projectPath="./Reports/";
    static String realPath=projectPath+filenameString;
    public static ExtentReports extent = ExtentManager.createInstance(realPath);
	public static ThreadLocal<ExtentTest> testRepor = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getClass().getName() + " @TestCase" + result.getMethod().getMethodName());
		testRepor.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + "  PASSED" + "</b>";

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

		// logger.getStatus();
		// logger.log(Status.PASS, " TEST CASE PASS IS " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// First arugement
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.log(Status.FAIL, m);

		// second argument
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " FAILED" + "</b>";

		Markup m1 = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.fail(m1);
		// Third argument individual
		test.fail(result.getThrowable().getMessage());
		test.log(Status.FAIL, result.getName() + " TEST CASE ERROR IS " + result.getThrowable().getMessage());
		
		// screen shot
		String screenShotPath = ExtentManager.getScreenshot(driver, result.getName());
		try {
			test.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// first argument
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.skip("<details>" + "<summary>" + "<b>" + "<fontcolor=" + "red>" + "Exception occured:Click to see"
				+ "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n");

		String failureLogg = "TEST CASE SKIPPED  " + result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.ORANGE);
		test.log(Status.SKIP, m);
		
		// taking screen shot
		String screenShotPath = ExtentManager.getScreenshot(driver, result.getName());
		try {
			test.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// second argument
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE: - " + methodName.toUpperCase() + " SKIPPED" + "</b>";

		Markup m1 = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		test.pass(m1);
		// third argument
		test.skip(result.getThrowable().getMessage());
		test.log(Status.SKIP, result.getName() + " TEST CASE ERROR IS " + result.getThrowable().getMessage());

	}



	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
			System.out.println(context.getName()+" *******   EXECUTED   ********* ");
		}
	}
	
}
