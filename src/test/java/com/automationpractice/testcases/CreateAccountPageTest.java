package com.automationpractice.testcases;

import org.testng.annotations.Test;
import com.automationpractice.qa.TestBase;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.Utilites.FetchTestData;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.Indexpage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.SignInPage;

public class CreateAccountPageTest extends TestBase {

	CreateAccountPage createaccountpageobj;
	MyAccountPage myaccountpageobj;

	Indexpage indexpageobj;
	SignInPage signinpageobj;

	@BeforeMethod
	public void setup() {
		initialization();
		createaccountpageobj = new CreateAccountPage();
		signinpageobj = new SignInPage();
		indexpageobj = new Indexpage();

	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = FetchTestData.getTestDataFromExcel();
		return testData.iterator();
	}

	@Test
	public void clickSigninLink() {
		signinpageobj = indexpageobj.clickSignIn();
	}

	@Test
	public void inputEmail() {
		String emailid = prop.getProperty("emailid1");
		setTextValue(signinpageobj.getemailID(), emailid);
		createaccountpageobj = signinpageobj.submitEmailID();
	}

	@Test(dataProvider = "getTestData")
	public void inputPersonalInfo(String title, String firstname, String lastname, String password, String date,
			String companyname, String addressline, String cityname, String statename, String postalcode,
			String country, String mobilenumber) {

		String[] splitdate = date.split(" ");
		String day = " ", month = " ", year = " ";
		for (int i = 0; i < splitdate.length - 1; i++) {
			day = splitdate[0];
			month = splitdate[1];
			year = splitdate[2];

		}

		if (title.equalsIgnoreCase("Mr.")) {
			createaccountpageobj.getMalegender().sendKeys(title);
		} else {
			createaccountpageobj.getFemalegender().sendKeys(title);
		}

		setTextValue(createaccountpageobj.getFirstname(), firstname);
		setTextValue(createaccountpageobj.getLastname(), lastname);
		setTextValue(createaccountpageobj.getPassword(), password);
		selectbyVisibleText(createaccountpageobj.getDay(), day);
		selectbyVisibleText(createaccountpageobj.getMonth(), month);
		selectbyVisibleText(createaccountpageobj.getYear(), year);
		setTextValue(createaccountpageobj.getCompanyname(), companyname);
		setTextValue(createaccountpageobj.getAddressline(), addressline);
		setTextValue(createaccountpageobj.getCityname(), cityname);
		setTextValue(createaccountpageobj.getStatename(), statename);
		setTextValue(createaccountpageobj.getPostalcode(), postalcode);
		setTextValue(createaccountpageobj.getCountry(), country);
		setTextValue(createaccountpageobj.getMobilenumber(), mobilenumber);
		myaccountpageobj = createaccountpageobj.submitPersonalinfo();

	}

	@AfterTest(alwaysRun = false)
	public void tearDowntest() {
		tearDown();
	}

}
