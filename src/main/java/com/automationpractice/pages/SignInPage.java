package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.TestBase;

public class SignInPage extends TestBase {

	String emailid = prop.getProperty("emailid");

	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailID;

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement submitEmailID;

	public WebElement getemailID() {
		return emailID;
	}

	public WebElement getsubmitEmailID() {
		return submitEmailID;
	}

	public void login() {
		getemailID().clear();
		getemailID().sendKeys(emailid);
	}

	public CreateAccountPage submitEmailID() {
		getsubmitEmailID().click();
		return new CreateAccountPage();
	}
}
