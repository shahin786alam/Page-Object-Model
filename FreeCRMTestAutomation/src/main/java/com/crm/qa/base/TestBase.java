package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
	
		try {
			prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Shahin Alam\\Page-Object-Model.git"
				+ "\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
		e.printStackTrace();
		}

		}

	public static void initialization() {
		String browsername=  prop.getProperty("browser");
		if( browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Shahin Alam\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");	
			driver = new ChromeDriver();//launch Chrome	
			driver.manage().window().maximize();
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\geckodriver.exe");	
			driver = new FirefoxDriver();  //launch FF
			driver.manage().window().maximize();
		}
		else if(browsername.equals("IE")) {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\internetexplorerdriver.exe");	
			driver = new InternetExplorerDriver();  //launch IE
			driver.manage().window().maximize();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
	
//	public static void clickon(WebDriver driver, WebElement locator, int timeout) {
//		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
//		.until(ExpectedConditions.elementToBeClickable(locator));
//		locator.click();
//	}
}



