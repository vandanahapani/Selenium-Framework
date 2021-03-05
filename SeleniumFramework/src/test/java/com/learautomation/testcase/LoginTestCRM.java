package com.learautomation.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learautomation.pages.BaseClass;
import com.learautomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass {

	@Test(priority = 1)
	public void loginAPP() {

		// logger is reposible for all logging activity inside the test
		logger = report.createTest("Login to CRM");
		// Create Page Object and initialize page - it will go to page check all
		// locators, initialize and return object of same class
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		// username and password from Excel file
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		logger.pass("Login Success");

	}
/*
	@Test(priority = 1)
	public void loginAPP1() {

		// logger is reposible for all logging activity inside the test
		logger = report.createTest("Login to CRM");
		// Create Page Object and initialize page - it will go to page check all
		// locators, initialize and return object of same class
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		// username and password from Excel file
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0) + "dummy", excel.getStringData("Login", 0, 1));

		logger.fail("Logout Failed");

	}*/
	/*
	 * //Just for example
	 * 
	 * @Test(priority = 2) public void loginAPP1() {
	 * 
	 * //logger is reposible for all logging activity inside the test
	 * logger=report.createTest("Logout");
	 * 
	 * logger.fail("Logout Failed");
	 * 
	 * }
	 */
}
