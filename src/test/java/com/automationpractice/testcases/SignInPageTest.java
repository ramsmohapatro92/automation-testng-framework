package com.automationpractice.testcases;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.Utilites.FetchTestData;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.qa.TestBase;

public class SignInPageTest extends TestBase{

	SignInPage signinpageobj;
	CreateAccountPage createaccountpageobj;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		signinpageobj= new SignInPage();
	}
	
	@Test
	public void inputEmail()
	{
		String emailid=prop.getProperty("emailid1");
		setTextValue(signinpageobj.getemailID(), emailid);
		createaccountpageobj=signinpageobj.submitEmailID();
	}
	
	@AfterTest
	public void tearDowntest()
	{
		tearDown();
	}

}
