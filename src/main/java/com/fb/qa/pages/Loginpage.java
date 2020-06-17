package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.Testbase;

public class Loginpage extends Testbase{
	
	//page Factory OR object REPOSITORY
	@FindBy(name ="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement Password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath ="//a[contains(text(),'Forgotten account?')]")
	WebElement forgettenbtn;
	
	@FindBy(xpath = "//i[@class='fb_logo img sp_PtoC_M4ckZu_1_5x sx_77b69d']")
	WebElement gotohomepage;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Signupbtn;
	
	// Construter to initialization
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions (methods)
	
	public String Validatingtitlepage()
	{
		return driver.getTitle();
	}
	
	public String gotohomepage()
	{
		return driver.getCurrentUrl();
	}
	
	public Homepage login(String un, String pwd)
	{
		email.sendKeys(un);
		Password.sendKeys(pwd);
		loginbtn.click();
		return new Homepage();
		
	}
	
}
