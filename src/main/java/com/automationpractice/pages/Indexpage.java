package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.TestBase;

public class Indexpage extends TestBase {

	public Indexpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signinlink;

	public WebElement getSignInlink() {
		return signinlink;
	}

	public SignInPage clickSignIn() {
		getSignInlink().click();
		return new SignInPage();
	}

}
