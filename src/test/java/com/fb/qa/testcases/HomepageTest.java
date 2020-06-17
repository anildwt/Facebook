package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.Testbase;
import com.fb.qa.pages.Homepage;
import com.fb.qa.pages.Loginpage;

public class HomepageTest extends Testbase {
	Loginpage loginpage;
	Homepage homepage;
	
	public HomepageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void Setup() throws InterruptedException
	{
		initialization();
		loginpage = new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	@Test(priority=1)
	public void verifyhomepageTitleTest()
	{
		
		String homepagetitle = homepage.VerifyhomepageTitle();
		System.out.println(homepagetitle);
		Assert.assertEquals(homepagetitle, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void clickonaccount() throws Exception
	{
		homepage.accountclick();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
}
