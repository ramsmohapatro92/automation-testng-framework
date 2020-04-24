package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.TestBase;

public class CreateAccountPage extends TestBase {
	
	public CreateAccountPage() {
		 PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement malegender;

	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement femalegender;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//select[@id='days']")
	WebElement day;

	@FindBy(xpath = "//select[@id='months']")
	WebElement month;

	@FindBy(xpath = "//select[@id='years']")
	WebElement year;

	@FindBy(xpath = "//input[@id='company']")
	WebElement companyname;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement addressline;

	@FindBy(xpath = "//input[@id='city']")
	WebElement cityname;

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement statename;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement postalcode;

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobilenumber;
	
	@FindBy(id="submitAccount")
	WebElement Registerbtn;
	
	public WebElement getRegisterbtn() {
		return Registerbtn;
	}

	public WebElement getMalegender() {
		return malegender;
	}

	public WebElement getFemalegender() {
		return femalegender;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getCompanyname() {
		return companyname;
	}

	public WebElement getAddressline() {
		return addressline;
	}

	public WebElement getCityname() {
		return cityname;
	}

	public WebElement getStatename() {
		return statename;
	}

	public WebElement getPostalcode() {
		return postalcode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getMobilenumber() {
		return mobilenumber;
	}
	
	public MyAccountPage submitPersonalinfo()
	{
		getRegisterbtn().click();
		return new MyAccountPage();
	}
	
	

}
