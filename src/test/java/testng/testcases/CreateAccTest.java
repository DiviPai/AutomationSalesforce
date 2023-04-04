package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.pages.CreateAccPage;
import testng.pages.LoginPage;
import testng.pages.UserMenuDropdownPage;
import testng.utilities.GetProperty;

public class CreateAccTest extends BaseTest{

	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url;
	String title;
	String uniqueView = RandomStringUtils.randomAlphabetic(4);
	String username, password,userdropdownName; 
	String accountName;
	LoginPage loginpage;
	UserMenuDropdownPage userdropdownpapge;
	CreateAccPage createaccountpage;
	
	@BeforeMethod
	public void launchBrowser () throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		userdropdownpapge = new UserMenuDropdownPage(driver);
		createaccountpage = new CreateAccPage(driver);
	}
	
	@Test
	public void tc10() throws InterruptedException, IOException {
		title =getProperty.getValue("loginPageTitle");
		validateTitle(title);
		username = getProperty.getValue("username");
		loginpage.enterUsername(username);
		password = getProperty.getValue("password");
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		title=getProperty.getValue("homePageTitle");
		validateTitle(title);
		userdropdownName = getProperty.getValue("userdropdownName");
		userdropdownpapge.ValidateUsername(userdropdownName);
		
		//Click On Accounts Tab
		userdropdownpapge.clickAccountsTab();
		title = getProperty.getValue("AccountsPage");
		validateTitle(title);
		
		//Create new account
		createaccountpage.clickNewButton();
		accountName = getProperty.getValue("AccountName");
		createaccountpage.enterAccountName(accountName);
		createaccountpage.selectTechnologyPartnerFromTypeDropdwon();
		createaccountpage.selectHighFromCustomerPriorityDropdown();
		createaccountpage.clickSave();
		title=getProperty.getValue("NewAccPage");
		validateTitle(title);
		createaccountpage.validateNewAccount(accountName);
		
	}
	
	@Test
	public void tc11() throws InterruptedException, IOException {
		title =getProperty.getValue("loginPageTitle");
		validateTitle(title);
		username = getProperty.getValue("username");
		loginpage.enterUsername(username);
		password = getProperty.getValue("password");
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		title=getProperty.getValue("homePageTitle");
		validateTitle(title);
		userdropdownName = getProperty.getValue("userdropdownName");
		userdropdownpapge.ValidateUsername(userdropdownName);
		
		//Click On Accounts Tab
		userdropdownpapge.clickAccountsTab();
		title = getProperty.getValue("AccountsPage");
		validateTitle(title);
		
		//Create new view
		createaccountpage.clickCreateNewView();
		title=getProperty.getValue("CreateNewViewAccountsPage");
		validateTitle(title);
		createaccountpage.enterViewName("Abcdef");
		System.out.println(uniqueView);
		createaccountpage.enterUniqueViewName(uniqueView);
		createaccountpage.clickSave();
		Thread.sleep(5000);
		createaccountpage.validateNewView("Abcdef");
	}
	
	
	@Test
	public void tc12() throws InterruptedException, IOException {
		title =getProperty.getValue("loginPageTitle");
		validateTitle(title);
		username = getProperty.getValue("username");
		loginpage.enterUsername(username);
		password = getProperty.getValue("password");
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		title=getProperty.getValue("homePageTitle");
		validateTitle(title);
		userdropdownName = getProperty.getValue("userdropdownName");
		userdropdownpapge.ValidateUsername(userdropdownName);
		
		//Click On Accounts Tab
		userdropdownpapge.clickAccountsTab();
		title = getProperty.getValue("AccountsPage");
		validateTitle(title);
		
		//Edit view
		createaccountpage.selectViewFromDropdown("Abcdef");
		createaccountpage.clickEdit();
		title=getProperty.getValue("EditViewPage");
		validateTitle(title);
		createaccountpage.enterViewName("Abcd123");
		createaccountpage.enterUniqueViewName("Ab1212");
		createaccountpage.selectAccountNameFromFieldDropdown();
		createaccountpage.selectContainsFromOperatorDropdown();
		createaccountpage.enterValue("a");
		createaccountpage.clickSave();
	}
	
	
	@Test
	public void tc13() throws InterruptedException, IOException {
		title =getProperty.getValue("loginPageTitle");
		validateTitle(title);
		username = getProperty.getValue("username");
		loginpage.enterUsername(username);
		password = getProperty.getValue("password");
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		title=getProperty.getValue("homePageTitle");
		validateTitle(title);
		userdropdownName = getProperty.getValue("userdropdownName");
		userdropdownpapge.ValidateUsername(userdropdownName);
		
		//Click On Accounts Tab
		userdropdownpapge.clickAccountsTab();
		title = getProperty.getValue("AccountsPage");
		validateTitle(title);
	
		//Merge accounts
		createaccountpage.clickMergeAccount();
		title=getProperty.getValue("MergeAccountPage");
		validateTitle(title);
		createaccountpage.enterIntoSeach("Dipai");
		createaccountpage.clickFindAccounts();
//		createaccountpage.clickFirstCheckBox();
//		createaccountpage.clickSecondCheckBox();
		createaccountpage.uncheckThirdCheckBox();
		createaccountpage.clickGoNext();
		createaccountpage.validateHeader("Merge My Accounts");
		createaccountpage.validateSecondHeader("Step 2. Select the values to retain");
		createaccountpage.clickSave();
		title=getProperty.getValue("AccountsPage");
		createaccountpage.selectRecentlyViwedFromDropdown();
		//Validate merged account
	}
	
	
	@Test
	public void tc14() throws InterruptedException, IOException {
		title =getProperty.getValue("loginPageTitle");
		validateTitle(title);
		username = getProperty.getValue("username");
		loginpage.enterUsername(username);
		password = getProperty.getValue("password");
		loginpage.enterPassword(password);
		loginpage.clickLogIn();
		title=getProperty.getValue("homePageTitle");
		validateTitle(title);
		userdropdownName = getProperty.getValue("userdropdownName");
		userdropdownpapge.ValidateUsername(userdropdownName);
		
		//Click On Accounts Tab
		userdropdownpapge.clickAccountsTab();
		title = getProperty.getValue("AccountsPage");
		validateTitle(title);
		
		//Select report options
		createaccountpage.clickLastActivity();
		title=getProperty.getValue("ReportPage");
		validateTitle(title);
		
		createaccountpage.enterFromDate("3/21/2023");
		createaccountpage.eneterToDate("2/30/2022");
		createaccountpage.clickRunReport();
		
	
	}
	
	@AfterMethod
	public void teardown(Method method) {
		takeScreenshot(method.getName());
		driver.close();
	}
}
