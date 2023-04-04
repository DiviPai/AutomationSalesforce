package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.pages.DeveloperConsolePage;
import testng.pages.LoginPage;
import testng.pages.MyProfilePage;
import testng.pages.MySettingsPage;
import testng.pages.UserMenuDropdownPage;
import testng.utilities.GetProperty;

public class UserMenuDropdownTest extends BaseTest {
	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url;
	LoginPage loginpage;
	UserMenuDropdownPage userdropdownpage;
	MyProfilePage myprofilepage;
	MySettingsPage mysettingspage;
	DeveloperConsolePage developerconsolepage;
	
	@BeforeMethod
	public void launchBrowser () throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);	
		userdropdownpage = new UserMenuDropdownPage(driver);
		myprofilepage = new MyProfilePage(driver);
		mysettingspage = new MySettingsPage(driver);
		developerconsolepage = new DeveloperConsolePage(driver);
	}

//	@Test
	public void tc05() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.validateUserMenuDropdown("My Profile\n"
				+"My Settings\n"
				+"Developer Console\n"
				+"Switch to Lightning Experience\n"
				+"Logout");
	}
	
	@Test
	public void tc06() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");
		userdropdownpage.clickUserMenuDropdown();
		
		//userdopdownpage.validateUserMenuDropdown();
		userdropdownpage.clickMyProfile();
		validateTitle("User: Divya Pai ~ Salesforce - Developer Edition");
		myprofilepage.clickEditProfile();
		myprofilepage.clickAboutTab();
		myprofilepage.updtaeLastname("ABCD");
		myprofilepage.clickSaveAll();
		myprofilepage.validateDispalyedUsername("Divya ABCD ");
		
		//Reverse it back to Divya Pai
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickMyProfile();
		validateTitle("User: Divya ABCD ~ Salesforce - Developer Edition");
		myprofilepage.clickEditProfile();
		myprofilepage.clickAboutTab();
		myprofilepage.updtaeLastname("Pai");
		myprofilepage.clickSaveAll();
		myprofilepage.validateDispalyedUsername("Divya Pai ");
		
		//POst
		myprofilepage.clickPostLink();
		myprofilepage.enterAnUpdateToShare("Hello, now in Automation Framework");
		myprofilepage.clickShare();
		//myprofilepage.validateAuthor("Divya Pai");
		myprofilepage.validatePostDisplayed("Hello, now in Automation Framework");
		
		//delete the post
//		myprofilepage.clickPostDropdown();
//		myprofilepage.clickDelete();
//		myprofilepage.clickOkPopup();
		
		
		//Upload a file
		Thread.sleep(5000);
		myprofilepage.clickFile();
		myprofilepage.clickUploadFileFromComputer();
		myprofilepage.chooseFile("C:\\Users\\Prabhu\\Desktop\\Swapping2Nums.png");
		myprofilepage.shareFile();
		
		//Upload a Photo
		Thread.sleep(5000);
		myprofilepage.hoverPhotoSection();
//		Thread.sleep(3000);
		myprofilepage.clickAddPhoto();
//		Thread.sleep(3000);
		myprofilepage.choosePhoto();
		myprofilepage.clickSave();
		myprofilepage.clickSaveAgain();
	}
	
//	@Test
	public void tc07() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");
		userdropdownpage.clickUserMenuDropdown();
		
		userdropdownpage.clickMySettings();
		validateTitle("Hello, Divya Pai! ~ Salesforce - Developer Edition");
		mysettingspage.clickPersonal();
		mysettingspage.clickLoginHistory();
		validateTitle("Login History ~ Salesforce - Developer Edition");
		mysettingspage.clickDownloadLoginHistory();
		
		//Dispaly And Layout
		mysettingspage.clickDisplayAndLayout();
		mysettingspage.clickCustomizeTabs();
		mysettingspage.selectSalesforceChatterFromCustomApp();
		mysettingspage.SelectReportFromAailableTabs();
		mysettingspage.clickAdd();
		mysettingspage.clickSave();
		
		mysettingspage.clickPageDropdown();
		mysettingspage.clickSales();
		mysettingspage.checkForReportsTabInSales();
		
		mysettingspage.clickPageDropdown();
		mysettingspage.clickSalesforceChatter();
		mysettingspage.checkForrreportsTabInSalesforceChatter();
		
		mysettingspage.clickPageDropdown();
		mysettingspage.clickMarketing();
		mysettingspage.checkForReortsTabInMarketing();
		
		//Remove Reorts Tab from SalesforceChatter
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickMySettings();
		mysettingspage.clickDisplayAndLayout();
		mysettingspage.clickCustomizeTabs();
		mysettingspage.selectSalesforceChatterFromCustomApp();
		mysettingspage.selectReportsFromSelectedTabs();
		mysettingspage.clickRemove();
		mysettingspage.clickSave();
		
		mysettingspage.clickEmail();
		mysettingspage.clickMyEmailSettings();
		validateTitle("My Email Settings ~ Salesforce - Developer Edition");
		mysettingspage.updateEmailName("Divyashree Pai");
		mysettingspage.updateEmailAdd("divijayu@gmail.com");
		mysettingspage.clickRadioButtonYes();
		mysettingspage.clickSave();
		mysettingspage.closeAlert();
		mysettingspage.validateSuccessMsg("Your settings have been successfully saved.");
		
		//Resetting the changes
		mysettingspage.clickMyEmailSettings();
		validateTitle("My Email Settings ~ Salesforce - Developer Edition");
		mysettingspage.updateEmailName("Divya Pai");
		mysettingspage.updateEmailAdd("divyashreepai2019@gmail.com");
		mysettingspage.clickRadioButtonYes();
		mysettingspage.clickSave();
		mysettingspage.validateSuccessMsg("Your settings have been successfully saved.");
		
		//Calender And Reminder
		mysettingspage.clickCalenderAndReminder();
		mysettingspage.clickActivityReminder();
		mysettingspage.clickOpenATestReminder();
		mysettingspage.validateSampleWindowPopUp();
		
	}
	
	
	@Test
	public void tc08() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");
		userdropdownpage.clickUserMenuDropdown();
		
		developerconsolepage.clickDeveloperConsole();
	}

	@Test
	public void tc09() throws InterruptedException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpage.ValidateUsername("Divya Pai");
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
