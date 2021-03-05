package com.learautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.learautomation.utility.BrowserFactory;
import com.learautomation.utility.ConfigDataProvider;
import com.learautomation.utility.ExcelDataProvider;
import com.learautomation.utility.Helper;

/* all PRecondition and POstcondition methods which are required for all testCase */
public class BaseClass {
	public WebDriver driver; // used accross all over test
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	// setup suite for objects creation
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and Testing is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		// Report
		ExtentSparkReporter spark = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Reports/FreeCRM_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(spark);
		Reporter.log("Setting Done - Test can be started", true);
		
	}

	// PreCondition
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser,String url) {
		

		Reporter.log("Trying to start Browser and Getting application ready", true);
		
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		driver = BrowserFactory.startApplication(driver, browser, url);

		Reporter.log("Browser and Application is up and running", true);

	}

	// Postcondition
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);

	}

//to run after every testcase
	@AfterMethod
	public void tearDownMethod(ITestResult result) {

		Reporter.log("Test is about to end", true);

		// taking Screen shot on Failure
		// After test completion result variable will have all the information
		if (result.getStatus() == ITestResult.FAILURE) {
			// Helper.captureScreenShot(driver);

			// add screenshot on failure to report
			logger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			// Helper.captureScreenShot(driver);

			// add screenshot on success to report
			logger.pass("Test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());

		}
		report.flush(); // Appends the HTML file with all the ended tests.

		Reporter.log("Test Completed  >>> Reports Generated", true);

	}
}
