package com.crm.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Md alam')]")	
	//@CacheLookup
	WebElement userNameLable;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")	
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")	
	WebElement newcontactsLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")	
	WebElement dealsLink;	

	@FindBy(xpath="//a[contains(text(),'Tasks')]")	
	WebElement tasksLink;	

	//Initializing the page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TaskaPage clickOnTasksLink() {
		tasksLink.click();
		return new TaskaPage();
	}

	public void clickOnNewContactsLink() {
		Actions actions= new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newcontactsLink.click();
	}






}
