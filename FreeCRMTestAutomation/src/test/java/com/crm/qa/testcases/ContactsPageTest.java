package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.ContactsPage;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.util.TestUtil;



public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName="contacts";

	public ContactsPageTest () {
		super();
	}


	@BeforeMethod
	public void SetUp(){
		initialization();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.Loging(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
	}
	@Test(priority=1)
	public void verifyContactsPageLableTest() {
		Assert.assertTrue(contactspage.verifyContactsLable(),"Contacts lable is missing on the page");
	}
	//	@Test(priority=2)
	//	public void selectSingleContactsTest() {
	//		contactspage.selectContactsByName("test2 test2");
	//	}
	//	
	//	@Test(priority=3)
	//	public void selectmultipleContactsTest() {
	//		contactspage.selectContactsByName("test2 test2");
	//		contactspage.selectContactsByName("ui uiii");
	//	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContactsTest(String Title,String Firstname,String Lastname,String Company) {
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContact("Mr.", "roy", "dada", "Google");
		contactspage.createNewContact(Title, Firstname, Lastname, Company);
	}





	@AfterMethod
	public void tearDown() {
	 driver.quit();
	}

}
