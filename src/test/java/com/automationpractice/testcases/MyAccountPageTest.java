package com.automationpractice.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.qa.TestBase;

public class MyAccountPageTest extends TestBase{
	
	MyAccountPage myaccountpageobj;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		myaccountpageobj= new MyAccountPage();
	}

	
	@Test
	public void titleTest()
	{
		String actualtitle=MyAccountPage.validatePageTitle();
		String expectedtitle=prop.getProperty("My_Account_page_URL");
		AssertJUnit.assertEquals(actualtitle, expectedtitle, "Title Mismatch");
		if(actualtitle.equalsIgnoreCase(expectedtitle))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
	}
	
	@AfterTest
	public void tearDowntest()
	{
		tearDown();
	}
}
