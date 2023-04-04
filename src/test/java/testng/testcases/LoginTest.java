package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.log.Log;
import testng.pages.UserMenuDropdownPage;
import testng.pages.LoginPage;
import testng.utilities.GetProperty;

public class LoginTest extends BaseTest{
	
	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url;
	LoginPage loginpage;
	UserMenuDropdownPage userdopdownpage;
	
	@BeforeMethod
	public void launchBrowser () throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);	
		userdopdownpage = new UserMenuDropdownPage(driver);
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Login");
	}
	
	@Test
	public void tc01() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("");
		loginpage.clickLogIn();
		validateErrMsg(loginpage.getErrorMsg(),"Please enter your password.");
		
	}
	
	@Test
	public void tc02() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
//		userdopdownpage.lookForHomeTab();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
	}
	
	@Test
	public void tc03() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickRememberMeCheckBox();
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdopdownpage.clickUserMenuDropdown();
		userdopdownpage.clickLogout();
		validateTitle("Login | Salesforce");
		loginpage.validateDisplayedUserName("hello@peppa.pig");
	}
	
	
	@Test
	public void tc04a() throws InterruptedException {
		Log.info("Launching the browser");
		validateTitle("Login | Salesforce");
		loginpage.clickForgotYourPassword();
		validateTitle("Forgot Your Password | Salesforce");
		loginpage.enterUsernameToResetYourPassword("divyashreepai2019@gmail.com");
		loginpage.clickContinueButton();
		Log.info("forgot button");
		validateTitle("Check Your Email | Salesforce");
		String expected = "We’ve sent you an email with a link to finish resetting your password.";
		loginpage.validateEmailSent(expected.trim());
		Log.info("Validation complete");
	}
	
	@Test
	public void tc04b() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("123");
		loginpage.enterPassword("22131");
		loginpage.clickLogIn();
		validateErrMsg(loginpage.getErrorMsg(), 
				"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		
	}
	
	@AfterMethod
	public void teardown(Method method) {
		takeScreenshot(method.getName());
		closeWindow();
	}
	
}
