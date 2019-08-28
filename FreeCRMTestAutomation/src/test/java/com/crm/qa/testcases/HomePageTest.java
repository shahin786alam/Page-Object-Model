package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated --independent with each other
	//before each test cases -- launch the browser and login
	//@test -- excute test cases
	//after each test cases -- close the browser
	
	@BeforeMethod
	public void SetUp(){
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.Loging(prop.getProperty("username"),prop.getProperty("password"));
		testutil=new TestUtil();
		contactspage=new ContactsPage();
	}
	@Test
	public void verifyHomePageTitleTest() {
		String hometitle= homepage.verifyHomePageTitle();
		Assert.assertEquals(hometitle, "CRMPRO", "Home Page Title is not matched");
	}

	@Test
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=1)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
