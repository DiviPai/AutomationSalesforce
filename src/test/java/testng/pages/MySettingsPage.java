package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testng.base.BasePage;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='header setupFolder']/span[text()='Personal']")
	WebElement personal;
	
	@FindBy(id="LoginHistory_font")
	WebElement loginHistory;
	
	@FindBy(xpath="//a[contains(text(),'Download')]")
	WebElement downloadLoginHistory;
	
	@FindBy(id="DisplayAndLayout_font")
	WebElement displayAndLayout;
	
	@FindBy(id="CustomizeTabs_font")
	WebElement customizeTabs;
	
	@FindBy(id="p4")
	WebElement customAppDropdown;
	
	@FindBy(id="duel_select_0")
	WebElement availableTabs;
	
	@FindBy(id="duel_select_1")
	WebElement selectedTabs;
	
	@FindBy(id="duel_select_0_right")
	WebElement addButton;
	
	@FindBy(id="duel_select_0_left")
	WebElement remove;
	
	@FindBy(name="save")
	WebElement save;
	
	@FindBy(id="tsidButton")
	WebElement pageDropdown;
	
	@FindBy(xpath="//a[text()='Sales']")
	WebElement sales;
	
	@FindBy(id="tryLexDialogX")
	WebElement closePopup;
	
	@FindBy(xpath="//a[text()='Reports']")
	WebElement reportsTab;
	
	@FindBy(xpath="//a[text()='Salesforce Chatter']")
	WebElement salesforceChatter;
	
	@FindBy(id="report_Tab")
	WebElement reportsTabInSalesforceChatter;
	
	@FindBy(xpath="//a[text()='Marketing']")
	WebElement marketing;
	
	@FindBy(id="EmailSetup_font")
	WebElement email;
	
	@FindBy(id="EmailSettings_font")
	WebElement myEmailSettings;
	
	@FindBy(id="sender_name")
	WebElement emailName;
	
	@FindBy(id="sender_email")
	WebElement emailAdd;
	
	@FindBy(id="auto_bcc1")
	WebElement autoBCCYes;
	
	@FindBy(xpath="//div[@class='messageText']")
	WebElement successMsg;
	
	@FindBy(id="CalendarAndReminders_font")
	WebElement calendarAndReminders;
	
	public void clickPersonal() {
		explicitwait(10, personal);
		personal.click();
	}
	
	public void clickLoginHistory() {
		loginHistory.click();
	}

	public void clickDownloadLoginHistory() {
		downloadLoginHistory.click();
	}
	
	public void clickDisplayAndLayout() {
		explicitwait(5, displayAndLayout);
		displayAndLayout.click();
	}
	
	public void clickCustomizeTabs() {
		customizeTabs.click();
	}
	
	public void selectSalesforceChatterFromCustomApp() {
		Select customApp = new Select(customAppDropdown);
		customApp.selectByValue("02uDm0000019nKC");
 
	}
	
	public void SelectReportFromAailableTabs() {
		Select availableTabsDopdown = new Select(availableTabs);
		availableTabsDopdown.selectByValue("report");

	}
	
	public void clickAdd() {
		addButton.click();
	}
	
	public void clickPageDropdown() {
		pageDropdown.click();
	}
	
	public void clickSave() {
		save.click();
	}
	
	public void clickSales() {
		sales.click();
		closePopup(closePopup);

	}
	
	public void checkForReportsTabInSales() {
		explicitwait(5, reportsTab);
		String tabActual = reportsTab.getText();
		String tabExpected = "Reports";
		validateText(tabActual,tabExpected);
	}
	
	public void clickSalesforceChatter() {
		salesforceChatter.click();
//		closePopup(closePopup);
	}
	
	public void checkForrreportsTabInSalesforceChatter() {
		explicitwait(5, reportsTabInSalesforceChatter);
		String tabActual = reportsTabInSalesforceChatter.getText();
		String tabExpected ="Reports";
		validateText(tabActual, tabExpected);
	}
	
	public void clickMarketing() {
		marketing.click();
//		closePopup(closePopup);
	}
	
	public void checkForReortsTabInMarketing() {
		explicitwait(10, reportsTab);
		String tabActual = reportsTab.getText();
		String tabExpected = "Reports";
		validateText(tabActual, tabExpected);
	}
	
	
	public void selectReportsFromSelectedTabs() {
		Select reports = new Select(selectedTabs);
		reports	.selectByValue("report");	
	}
	
	public void clickRemove() {
		remove.click();
	}
	
	public void clickEmail() {
		email.click();
	}
	
	public void clickMyEmailSettings() {
		myEmailSettings.click();
	}
	
	public void updateEmailName(String senderName) {
		emailName.clear();
		emailName.sendKeys(senderName);
	}
	
	public void updateEmailAdd(String newEmailAdd) {
		emailAdd.clear();
		emailAdd.sendKeys(newEmailAdd);
	}
	
	public void clickRadioButtonYes() {
		autoBCCYes.click();
	}
	
	public void validateSuccessMsg(String expectedMsg) {
		explicitwait(10, successMsg);
		String actualMsg = successMsg.getText();
		validateText(actualMsg, expectedMsg);
		
	}
	
	public void clickCalenderAndReminder() {
		calendarAndReminders.click();
	}
	
	@FindBy(id="Reminders_font")
	WebElement activityReminder;
	
	@FindBy(id="testbtn")
	WebElement openATestReminder;
	
	@FindBy(xpath="//div[contains(text(),'Sample Event')]")
	WebElement samplwEventWindowHeader;
	
	public void clickActivityReminder() {
		activityReminder.click();
	}
	
	public void clickOpenATestReminder() {
		openATestReminder.click();
	}
	
	public void validateSampleWindowPopUp() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		String childHandle = null;
		Thread.sleep(5000);
		
		for(String handle:driver.getWindowHandles())
			childHandle = handle;
		System.out.println(parentWindow);
		System.out.println(childHandle);
		
		driver.switchTo().window(childHandle);
		String actualHeader = samplwEventWindowHeader.getText();
		String expectedHeader = "  Sample Event.";
		validateText(actualHeader, expectedHeader);
		driver.close();
		driver.switchTo().window(parentWindow);
	}
}
