package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.Testbase;
import com.fb.qa.pages.Homepage;
import com.fb.qa.pages.Loginpage;

public class LoginpageTest extends Testbase {
	
	Loginpage loginpage;
	Homepage homepage;
	
	public LoginpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization(); 
		loginpage = new Loginpage();
	}
	
	@Test(priority=1)
	public void loginpagetitleTest()
	{
	String title = loginpage.Validatingtitlepage();
	Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
