package testng.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng.base.BaseTest;
import testng.pages.CreateAccPage;
import testng.pages.CreateOpportunityPage;
import testng.pages.LoginPage;
import testng.pages.UserMenuDropdownPage;
import testng.utilities.GetProperty;

public class CreateOpportunityTest extends BaseTest{

	public WebDriver driver;
	GetProperty getProperty = new GetProperty();
	String url;
	String title;
	String username, password,userdropdownName; 
	String accountName;
	LoginPage loginpage;
	UserMenuDropdownPage userdropdownpapge;
	CreateAccPage createaccountpage;
	CreateOpportunityPage createOppPage;
	
	@BeforeMethod
	public void launchBrowser () throws IOException {
		driver = getDriver();
		url = getProperty.getValue("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		userdropdownpapge = new UserMenuDropdownPage(driver);
		createaccountpage = new CreateAccPage(driver);
		createOppPage = new CreateOpportunityPage(driver);
	}
	
	@Test
	public void tc15() throws InterruptedException, IOException{
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpapge.ValidateUsername("Divya Pai");
		
		//Opportunities Tab
		userdropdownpapge.clickOpportunitiesTab();
		title=getProperty.getValue("OpportunitiesPage");
		validateTitle(title);
		createOppPage.validateOpportunityDropdown("All Opportunities\n"
				+ "Closing Next Month\n"
				+ "Closing This Month\n"
				+ "My Opportunities\n"
				+ "New Last Week\n"
				+ "New This Week\n"
				+ "Opportunity Pipeline\n"
				+ "Private\n"
				+ "Recently Viewed Opportunities\n"
				+ "Won");
				
	}
	
	@Test
	public void tc16() throws InterruptedException, IOException{
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpapge.ValidateUsername("Divya Pai");
		
		//Opportunities Tab
		userdropdownpapge.clickOpportunitiesTab();
		title=getProperty.getValue("OpportunitiesPage");
		validateTitle(title);
		
		//create new opportunity
		createOppPage.clickNewButton();
		createOppPage.enterOpportunityName("ABCD");
		createOppPage.clickSearchAccountNameButton();
		createOppPage.lookUpInSearch("DiPai");
		createOppPage.clickDate();
		createOppPage.selectProspectingFronStageDropdown();
		createOppPage.eneterProbability("20");
		createOppPage.clickSearchCampaignButton();
		createOppPage.lookUpInSearchForCampaign("DM");
		createOppPage.clickSave();
		title=getProperty.getValue("NewOppPage");
		validateTitle(title);
	}
	

	@Test
	public void tc17() throws InterruptedException, IOException{
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpapge.ValidateUsername("Divya Pai");
		
		//Opportunities Tab
		userdropdownpapge.clickOpportunitiesTab();
		title=getProperty.getValue("OpportunitiesPage");
		validateTitle(title);
	
		//Opportunity Pipeline
		createOppPage.clickOpportunityPipeline();
		title=getProperty.getValue("OppPipelinePage");
		validateTitle(title);
	}
	
	@Test
	public void tc18() throws InterruptedException, IOException{
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpapge.ValidateUsername("Divya Pai");
		
		//Opportunities Tab
		userdropdownpapge.clickOpportunitiesTab();
		title=getProperty.getValue("OpportunitiesPage");
		validateTitle(title);
		
		//Stuck Opportunity
		createOppPage.clickStuckOpportunity();
		title=getProperty.getValue("StuckOppPage");
		validateTitle(title);
	}
	
	@Test
	public void tc19() throws InterruptedException, IOException{
		validateTitle("Login | Salesforce");
		loginpage.enterUsername("hello@peppa.pig");
		loginpage.enterPassword("Sales1Force");
		loginpage.clickLogIn();
		validateTitle("Home Page ~ Salesforce - Developer Edition");
		userdropdownpapge.ValidateUsername("Divya Pai");
		
		//Opportunities Tab
		userdropdownpapge.clickOpportunitiesTab();
		title=getProperty.getValue("OpportunitiesPage");
		validateTitle(title);
		
		//Interval and Include
		createOppPage.selectCurrentFQFromintervalDropDown();
		createOppPage.selectAllOpportunityFromIncludeDropDown();
		createOppPage.clickRunReport();
		title=getProperty.getValue("OppReportPage");
		validateTitle(title);
	
	}
	
	@AfterMethod
	public void teardown(Method method) {
		takeScreenshot(method.getName());
		closeWindow();
	}


}
