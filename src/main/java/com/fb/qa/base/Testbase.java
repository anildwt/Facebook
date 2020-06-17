package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.fb.qa.util.TestUtil;



public class Testbase {
	public static WebDriver driver;
	public static Properties prop;

	public Testbase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Anil Kontham\\eclipse-workspace\\facebook\\src\\main\\java\\com\\fb\\qa\\config\\base.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() throws InterruptedException {

		 String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\RUDRAKSHA\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\RUDRAKSHA\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\RUDRAKSHA\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		Thread.sleep(5000);
		
		
	
	
}


}
