package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testng.base.BasePage;

public class CreateOpportunityPage extends BasePage{

	public CreateOpportunityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="fcf")
	WebElement opp;
	
	@FindBy(name="new")
	WebElement newButton;
	
	@FindBy(id="opp3")
	WebElement oppName;
	
	@FindBy(id="opp4_lkwgt")
	WebElement searchAccountNameButton;
	
	@FindBy(id="searchFrame")
	WebElement frame;
	
	@FindBy(xpath="//div[@class='pBody']/input[@id='lksrch']")
	WebElement search;
	
	@FindBy(name="go")
	WebElement goButton;
	
	@FindBy(xpath="//a[@tabindex='7']")
	WebElement date;
	
	@FindBy(id="opp11")
	WebElement stageDropdown;
	
	@FindBy(id="opp12")
	WebElement probability;
	
	@FindBy(id="opp17_lkwgt")
	WebElement campaign;
	
	@FindBy(xpath="//table/tbody/tr[@class='dataRow even first'][1]/th[1]/a")
	WebElement account;
	
	@FindBy(id="resultsFrame")
	WebElement resultFrame;
	
	@FindBy(xpath="//table/tbody/tr/th/a")
	WebElement resultCampaign;
	
	@FindBy(name="save")
	WebElement save;
	
	@FindBy(xpath="//a[text()='Opportunity Pipeline']")
	WebElement opportunityPipeline;
	
	@FindBy(xpath="//a[text()='Stuck Opportunities']")
	WebElement stuckOpportunity;
	
	@FindBy(id="quarter_q")
	WebElement intervalDropDown;
	
	@FindBy(id="current")
	WebElement currenetFQ;
	
	@FindBy(id="open")
	WebElement includeDropDown;
	
	@FindBy(xpath="//input[@value='Run Report']")
	WebElement runReport;
	
	public void validateOpportunityDropdown(String dropdownExpected)
	{
		String dropdownActual = opp.getText();
		validateText(dropdownActual, dropdownExpected);		
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void enterOpportunityName(String OppName) {
		oppName.sendKeys(OppName);		
	}
	
	public void lookUpInSearch(String AccountName){
		
		String parentWindow = driver.getWindowHandle();
		String childWindow = null;
		for (String handle : driver.getWindowHandles())
			childWindow = handle;

		driver.switchTo().window(childWindow);
		
		driver.switchTo().frame(frame);
		explicitwait(5, search);
		search.sendKeys(AccountName);
		
		goButton.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(resultFrame);
		account.click();
		driver.switchTo().window(parentWindow);

	}
	
	public void clickSearchAccountNameButton() {
		searchAccountNameButton.click();
	}
		
	public void clickDate() {
		date.click();
	}
	
	
	public void selectProspectingFronStageDropdown() {
		Select stage = new Select(stageDropdown);
		stage.selectByValue("Prospecting");
	}
	
	public void clickSearchCampaignButton() {
		campaign.click();
	}
	
	public void eneterProbability(String prob) {
		probability.clear();
		probability.sendKeys(prob);
	}
	
	public void lookUpInSearchForCampaign(String strCampaign) {
		
		String parentWindow = driver.getWindowHandle();
		String childWindow = null;
		for (String handle : driver.getWindowHandles())
			childWindow = handle;

		driver.switchTo().window(childWindow);
		
		driver.switchTo().frame(frame);
		explicitwait(5, search);
		search.sendKeys(strCampaign);
		
		goButton.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(resultFrame);
		resultCampaign.click();
		driver.switchTo().window(parentWindow);

	}

	public void clickSave() {
		save.click();
	}
	
	public void clickOpportunityPipeline() {
		opportunityPipeline.click();
		
	}
	
	public void clickStuckOpportunity() {
		stuckOpportunity.click();
	}
	
	public void selectCurrentFQFromintervalDropDown() {
		Select interval = new Select(intervalDropDown);
		interval.selectByValue("current");
	}
	
	public void selectAllOpportunityFromIncludeDropDown() {
		Select include = new Select(includeDropDown);
		include.selectByValue("all");
	}
	
	public void clickRunReport() {
		runReport.click();
	}
}
