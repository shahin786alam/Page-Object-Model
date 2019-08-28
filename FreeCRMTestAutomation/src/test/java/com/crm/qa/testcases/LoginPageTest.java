package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.page.HomePage;
import com.crm.qa.page.LoginPage;
import com.crm.qa.page.SignUpPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	SignUpPage signuppage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage= new LoginPage();
	}

	@Test(priority=1)
	public void LogingPageTitleTest() {
		String title= loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority=2)
	public void crmlogoImageTest() {
		boolean fl=loginpage.validateCRMImage();
		Assert.assertTrue(fl);
	}

	@Test(priority=3)
	public void loginTest() {
		homepage=loginpage.Loging(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=4)
	public void signUpLinkTest() {
		signuppage=loginpage.signUplink();
	}




	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}



