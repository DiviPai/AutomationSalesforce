package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.pages.ContactsPage;
import testng.pages.LoginPage;
import testng.pages.UserMenuDropdownPage;
import testng.utilities.GetProperty;

public class ContactsTest extends BaseTest {

	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url;
	String title;

	String uniqueView = RandomStringUtils.randomAlphabetic(4);
	LoginPage loginpage;
	UserMenuDropdownPage userdropdownpage;
	ContactsPage contactspage;

	@BeforeMethod
	public void launchBrowser() throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		userdropdownpage = new UserMenuDropdownPage(driver);
		contactspage = new ContactsPage(driver);
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc25(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// Create new contact
		contactspage.clickNewButton();
		contactspage.enterLastname("ABCD");
		contactspage.enterAccountname("EFGH");
		contactspage.clickSave();

		title = getProperty.getValue("NewContactPageABCD");
		validateTitle(title);

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc26(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// Create new View
		contactspage.clickCreateNewView();
		title = getProperty.getValue("CreateNewViewContactsPage");
		validateTitle(title);
		contactspage.enterViewName("ABCDE");
		contactspage.enterViewUniqueName(uniqueView);
		contactspage.clickSave();
		title = getProperty.getValue("ContactsPage");
		validateTitle(title);
		contactspage.checkNewViewCreatedDisplayed("ABCDE");

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

	}

	@Test
	@Parameters({ "username", "password" })
	public void tc27(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// Recently created from dropdown
		contactspage.selectRecentlyCreatedFromDropdown();
		contactspage.validateRecentContacts();

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

	}

	@Test
	@Parameters({ "username", "password" })
	public void tc28(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// My contacts
		contactspage.selectMyContactsfromDropdown();
		title = getProperty.getValue("ContactsPage");
		validateTitle(title);

		//Reset to recent contact
		contactspage.selectAllContactsfromDropdown();
		
		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

	}

	@Test
	@Parameters({ "username", "password" })
	public void tc29(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// My contacts: Gonzalez
		contactspage.clickContactGonzalez();
		title = getProperty.getValue("GonzalezInfoPage");
		validateTitle(title);

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc30(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// Create new View
		contactspage.clickCreateNewView();
		title = getProperty.getValue("CreateNewViewContactsPage");
		validateTitle(title);
//		contactspage.enterViewName("ABCDE");
		contactspage.enterViewUniqueName("EFGH");
		contactspage.clickSave();
		contactspage.validateErrorMsg("Error: You must enter a value");
		
		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");
	}

	@Test
	@Parameters({ "username", "password" })
	public void tc31(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// Cancel new View
		contactspage.clickCreateNewView();
		title = getProperty.getValue("CreateNewViewContactsPage");
		validateTitle(title);
		contactspage.enterViewName("ABCDEF");
		contactspage.enterViewUniqueName("EFGH");
		contactspage.clickCancel();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);
		
		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");
	}
	
	@Test
	@Parameters({ "username", "password" })
	public void tc32(String username, String password) throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");

		// Contacts tab
		userdropdownpage.clickContactsTab();
		title = getProperty.getValue("ContactsHomePage");
		validateTitle(title);

		// Create new contact
		contactspage.clickNewButton();
		contactspage.enterLastname("Indian");
		contactspage.enterCampaignname("Global Media");
		contactspage.clickSave();

		title = getProperty.getValue("NewContactPageIndian");
		validateTitle(title);

		// Logout
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
