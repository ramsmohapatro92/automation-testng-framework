package com.automationpractice.testcases;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.pages.Indexpage;
import com.automationpractice.pages.SignInPage;
import com.automationpractice.qa.TestBase;

public class IndexPageTest extends TestBase {

	Indexpage indexpageobj;
	SignInPage signinpageob;
	Logger log = Logger.getLogger(IndexPageTest.class);

	@BeforeMethod
	public void setup() {
		initialization();
		indexpageobj = new Indexpage();
	}
	
	@Test
	public void clickSigninLink()
	{
		signinpageob=indexpageobj.clickSignIn();
	}

	@AfterTest
	public void tearDowntest() {
		tearDown();
	}

}
