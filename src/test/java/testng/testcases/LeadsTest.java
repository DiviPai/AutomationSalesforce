package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.pages.LeadsPage;
import testng.pages.LoginPage;
import testng.pages.UserMenuDropdownPage;
import testng.utilities.GetProperty;

public class LeadsTest extends BaseTest {

	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url;
	String title;
	LoginPage loginpage;
	UserMenuDropdownPage userdropdownpage;
	LeadsPage leadspage;

	@BeforeMethod
	public void launchBrowser() throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		userdropdownpage = new UserMenuDropdownPage(driver);
		leadspage = new LeadsPage(driver);
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc20(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Leads Tab
		userdropdownpage.clickLeadsTab();
		title = getProperty.getValue("LeadsPage");
		validateTitle(title);

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc21(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Leads Tab
		userdropdownpage.clickLeadsTab();
		title = getProperty.getValue("LeadsPage");
		validateTitle(title);

		// Validate leads dropdown
		leadspage.validateLeadsDropdown("All Open Leads\n" + "My Unread Leads\n" + "Recently Viewed Leads\n"
				+ "Today's Leads\n" + "View - Custom 1\n" + "View - Custom 2");

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc22(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Leads Tab
		userdropdownpage.clickLeadsTab();
		title = getProperty.getValue("LeadsPage");
		validateTitle(title);

		// Select Unread Leads
		leadspage.selectUnreadLeadsFromLeadsDropdown();

		// logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

		// Login Again
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// Leads Tab
		userdropdownpage.clickLeadsTabAgain();
		title = getProperty.getValue("LeadsPage");
		validateTitle(title);
		leadspage.clickGo();
		title = getProperty.getValue("LeadsDropDownPage");
		validateTitle(title);

		// Reset leads dropdown
		leadspage.selectTodaysLeadsFromLeadsDropdown();

		// logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

	}

	@Test
	@Parameters({ "username", "password" })
	public void tc23(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Leads Tab
		userdropdownpage.clickLeadsTab();
		title = getProperty.getValue("LeadsPage");
		validateTitle(title);

		// Select Today's leads from dropdown
		leadspage.selectTodaysLeadsFromLeadsDropdown();
		title = getProperty.getValue("LeadsDropDownPage");
		validateTitle(title);
		
		// logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

	}
	
	@Test
	@Parameters({ "username", "password" })
	public void tc24(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Leads Tab
		userdropdownpage.clickLeadsTab();
		title = getProperty.getValue("LeadsPage");
		validateTitle(title);

		//Create new lead
		leadspage.clickNewButton();
		leadspage.enterlastName("ABCDE");
		leadspage.enterCompany("ABCDE");
		leadspage.clickSave();
		leadspage.validateHeader("ABCDE");
		title=getProperty.getValue("NewLeadsPage");
		validateTitle(title);
		
		// logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

	}

	@AfterMethod
	public void teardown(Method method) {
		takeScreenshot(method.getName());
		closeWindow();
	}

}
