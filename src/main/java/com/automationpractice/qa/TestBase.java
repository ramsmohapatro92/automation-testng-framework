package com.automationpractice.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.Utilites.TestUtilities;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	static String browsername;
	public static Select selectdropdown;
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {
		File propertiesfile = new File(".\\BuildDetails.properties");
		//System.out.println(propertiesfile.getAbsolutePath());
		try {
			fis = new FileInputStream(propertiesfile);
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
//		File propertiesfile = new File(".\\BuildDetails.properties");
//		try {
//			fis = new FileInputStream(propertiesfile);
//			try {
//				prop.load(fis);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		browsername = prop.getProperty("browser");
		String url = prop.getProperty("url");
		switch (browsername) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Launching Chrome browser");

		case "firefox":
			System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Launching firefox browser");

		default:
			System.out.println("Not a valid web driver");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtilities.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.implicitly_wait, TimeUnit.SECONDS);
		driver.get(url);
		log.info(url + " :is launched");
	}

	public static void clickonbtn(WebElement element) {
		element.click();
		log.info(element + " " + "has been clicked");
	}

	public static void setTextValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
		log.info("Value entered: " + value);
	}

	public static void selectbyVisibleText(WebElement element, String value) {
		selectdropdown = new Select(element);
		selectdropdown.selectByVisibleText(value);
		log.info("Value enterd: " + value);
	}

	public static void selectbyIndex(WebElement element, int value) {
		selectdropdown = new Select(element);
		selectdropdown.selectByIndex(value);
		log.info("Value enterd: " + value);
	}

	public static void selectbyValue(WebElement element, String value) {
		selectdropdown = new Select(element);
		selectdropdown.selectByVisibleText(value);
		log.info("Value enterd: " + value);
	}

	public static void tearDown() {
		driver.close();
		log.info("Session ended");
	}

}
