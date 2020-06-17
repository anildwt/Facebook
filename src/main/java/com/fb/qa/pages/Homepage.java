package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.Testbase;

public class Homepage extends Testbase{
	
	// Finding webelements
	
	@FindBy(xpath = "//div[contains(text(),'Messenger')]")
	WebElement messenger;
	
	@FindBy(xpath = "//div[contains(text(),'Events')]")
	WebElement Events;
	
	@FindBy(xpath = "//div[contains(text(),'Groups')]")
	WebElement Groups;
	
	@FindBy(xpath = "//div[@aria-label='Account']//i")
	WebElement Account;
	
	@FindBy(xpath = "//span[@dir='auto' and (text()='Log Out')]")
	WebElement Logoutbtn;
	
	// Constructor for initializing elements
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods for actions
	
	public String VerifyhomepageTitle()
	{
		return driver.getTitle();
	}
	
	public Messengerpage clickonmessenger()
	{
		messenger.click();
		return new Messengerpage();
	}
	
	public GroupsPage clickonGroups()
	{
		Groups.click();
		return new GroupsPage();
	}
	
	public Eventspage clickononEvents()
	{
		Events.click();
		return new Eventspage();
	}
	public void accountclick() throws InterruptedException
	{
		Thread.sleep(5000);
		Account.click();
		Thread.sleep(10000);
		Logoutbtn.click();
		
	}
	

}
