package com.crm.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page Factory - OR : define 2 Way
	@FindBy(name="username") //we can use like this line (define number one)
	//@CacheLookup
	WebElement username; 
	
	@FindBy(name="password")//we can use like this line too.(define number two)
	//@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login' and @class='btn btn-small']")
	//@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement CRMLogo;
	
	//Initializing the page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}  
	
	public boolean validateCRMImage() {
		return CRMLogo.isDisplayed();
	}
	
	public SignUpPage signUplink() {
		Actions action = new Actions(driver);
		action.moveToElement(signUpBtn).build().perform();
		action.click();
		//signUpBtn.click();
		return new SignUpPage();
	}
	
	public HomePage Loging(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
//		Actions action = new Actions(driver);
//		action.moveToElement(LoginBtn).build().perform();
//		action.click();
		//LoginBtn.click();
		//clickon(driver,LoginBtn,40);
		
		//click on LoginBtn element by using js executor
		clickElementByJs(LoginBtn, driver);
		return new HomePage();
	}
	public static void clickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);
	}

}



