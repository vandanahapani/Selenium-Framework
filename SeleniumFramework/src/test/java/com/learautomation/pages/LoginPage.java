package com.learautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//To store all locators
public class LoginPage {

	WebDriver driver;

	// Create constructor to initialize WebDriver
	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(name = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	// takes two parameter to feed data to script
	public void loginToCRM(String appUsername, String appPassword) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		uname.sendKeys(appUsername);
		pass.sendKeys(appPassword);
		loginButton.click();
	}
}
