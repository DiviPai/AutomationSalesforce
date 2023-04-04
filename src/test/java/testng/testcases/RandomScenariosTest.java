package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.pages.LoginPage;
import testng.pages.MyProfilePage;
import testng.pages.MySettingsPage;
import testng.pages.RandomScenariosPage;
import testng.pages.UserMenuDropdownPage;
import testng.utilities.GetProperty;

public class RandomScenariosTest extends BaseTest {

	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url, title;
	LoginPage loginpage;
	UserMenuDropdownPage userdopdownpage;
	RandomScenariosPage randomScenariosPage;
	MyProfilePage myprofilepage;
	UserMenuDropdownPage userdropdownpage;
	MySettingsPage mysettingspage;

	@BeforeMethod
	public void launchBrowser() throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		userdopdownpage = new UserMenuDropdownPage(driver);
		randomScenariosPage = new RandomScenariosPage(driver);
		myprofilepage = new MyProfilePage(driver);
		mysettingspage = new MySettingsPage(driver);
		userdropdownpage = new UserMenuDropdownPage(driver);
	}

	@Test
	public void tc33() throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// Home Tab
		randomScenariosPage.clickHomeTab();
		title = getProperty.getValue("HomeTabPage");
		validateTitle(title);

		// Firstname LastName link
		randomScenariosPage.clickFirstnameLatNameLink();
		title = getProperty.getValue("MyProfilePage");
		validateTitle(title);

	}

	@Test
	public void tc34() throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// Home Tab
		randomScenariosPage.clickHomeTab();
		title = getProperty.getValue("HomeTabPage");
		validateTitle(title);

		// Firstname LastName link
		randomScenariosPage.clickFirstnameLatNameLink();
		title = getProperty.getValue("MyProfilePage");
		validateTitle(title);

		// Edit profile
		myprofilepage.clickEditProfile();
		myprofilepage.clickAboutTab();
		myprofilepage.updtaeLastname("Abcd");
		myprofilepage.clickSaveAll();
		myprofilepage.validateDispalyedUsername("Divya Abcd ");
		userdropdownpage.ValidateUsername("Divya Abcd");
		title = getProperty.getValue("UpdatedMyProfilePage");
		validateTitle(title);

		// Reset changes
		myprofilepage.clickEditProfile();
		myprofilepage.clickAboutTab();
		myprofilepage.updtaeLastname("Pai");
		myprofilepage.clickSaveAll();

	}

	@Test
	public void tc35() throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// + Tab
		randomScenariosPage.clickPlusTab();
		title = getProperty.getValue("AllTabsPage");
		validateTitle(title);

		// clickCustomizeMyTabs
		randomScenariosPage.clickCustomizeMyTabs();
		title = getProperty.getValue("CustomizeMyTabsPage");
		validateTitle(title);

		randomScenariosPage.selectChatterFromSelectedTabs();
		mysettingspage.clickRemove();
		mysettingspage.clickSave();

		title = getProperty.getValue("AllTabsPage");
		validateTitle(title);

		// Logout
		userdropdownpage.clickUserMenuDropdown();
		userdropdownpage.clickLogout();
		validateTitle("Login | Salesforce");

		// Login again
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// Reset Chatter Tab
		// + Tab
		randomScenariosPage.clickPlusTab();
		title = getProperty.getValue("AllTabsPage");
		validateTitle(title);

		// clickCustomizeMyTabs
		randomScenariosPage.clickCustomizeMyTabs();
		randomScenariosPage.SelectChatterFromAailableTabs();
		mysettingspage.clickAdd();
		mysettingspage.clickSave();

		// Validate Chatter Tab
		randomScenariosPage.validatechatterTab("Chatter");

	}

	@Test
	public void tc36() throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// Home Tab
		randomScenariosPage.clickHomeTab();
		title = getProperty.getValue("HomeTabPage");
		validateTitle(title);
		
		//Current Date Link
		randomScenariosPage.clickDateLink();
		title=getProperty.getValue("CalenderPage");
		validateTitle(title);
		randomScenariosPage.click8PM();
		title=getProperty.getValue("NewEventPage");
		validateTitle(title);
		
		//SubjectCombo
		randomScenariosPage.clickSubjectCombo();
		Thread.sleep(8000);
		randomScenariosPage.SwitchToChildWindowAndClickOther();
		
//		title=getProperty.getValue("ComboBox");
//		validateTitle(title);
		randomScenariosPage.validateTimeDisplayedInDropdown("9:00 PM");
		randomScenariosPage.clickEndTime_Time();
		randomScenariosPage.select9PmfromDropdown();
		randomScenariosPage.clickSave();
		title=getProperty.getValue("CalenderPage");
		validateTitle(title);
		
	}
	
	
	@Test
	public void tc37() throws InterruptedException, IOException {
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");

		// Home Tab
		randomScenariosPage.clickHomeTab();
		title = getProperty.getValue("HomeTabPage");
		validateTitle(title);
		
		//Current Date Link
		randomScenariosPage.clickDateLink();
		title=getProperty.getValue("CalenderPage");
		validateTitle(title);
		randomScenariosPage.click4PM();
		title=getProperty.getValue("NewEventPage");
		validateTitle(title);
		
		//SubjectCombo
		randomScenariosPage.clickSubjectCombo();
		Thread.sleep(8000);
		randomScenariosPage.SwitchToChildWindowAndClickOther();
		
//		title=getProperty.getValue("ComboBox");
//		validateTitle(title);
		randomScenariosPage.validateTimeDisplayedInDropdown("5:00 PM");
		randomScenariosPage.clickEndTime_Time();
		randomScenariosPage.select7PmfromDropdown();
		
		//Recurrence series of event
		randomScenariosPage.clickCreateRecurringEventCheckBox();
		randomScenariosPage.clickWeeklyRadioButton();
//		randomScenariosPage.validateRecurrenceEveryTextBox("1");
		randomScenariosPage.clickRecurrenceEndDate();
		randomScenariosPage.select2WeeksFromNow();
		randomScenariosPage.clickSave();
		title=getProperty.getValue("CalenderPage");
		validateTitle(title);
		
		//month view
		randomScenariosPage.clickMonthView();
		title=getProperty.getValue("MonthViewPage");
		validateTitle(title);
		
	}


	@AfterMethod
	public void teardown(Method method) {
		takeScreenshot(method.getName());
		closeWindow();
	}

}
