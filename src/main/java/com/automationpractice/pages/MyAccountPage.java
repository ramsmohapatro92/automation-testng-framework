package com.automationpractice.pages;

import com.automationpractice.qa.TestBase;

public class MyAccountPage extends TestBase {
	
	public static String validatePageTitle()
	{
		return driver.getTitle();
	}

}
