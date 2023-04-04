package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testng.base.BasePage;

public class RandomScenariosPage extends BasePage {

	public RandomScenariosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeTab;

	@FindBy(xpath = "//h1/a[text()='Divya Pai']")
	WebElement firstNameLastNameLink;

	@FindBy(id = "tryLexDialogX")
	WebElement closepopup;

	@FindBy(xpath = "//a[@href='/home/showAllTabs.jsp']")
	WebElement plusTab;

	@FindBy(name = "customize")
	WebElement customizeMyTabs;

	@FindBy(id = "duel_select_1")
	WebElement selectedTabs;

	@FindBy(id = "duel_select_0_left")
	WebElement remove;

	@FindBy(id = "duel_select_0")
	WebElement availableTabs;

	@FindBy(xpath = "//a[text()='Chatter']")
	WebElement chatterTab;

	@FindBy(xpath = "//div[@class='content']/span/a")
	WebElement dateLink;
	
	@FindBy(xpath = "//a[contains(text(),'8:00 PM')]")
	WebElement link8PM;

	@FindBy(xpath = "//a[@title='Combo (New Window)']")
	WebElement subjectCombo;

	@FindBy(xpath = "//li[@class='listItem4']/a")
	WebElement linkOther;
	
	@FindBy(id="EndDateTime_time")
	WebElement endTime_Time;
	
	@FindBy(id="simpleTimePicker")
	WebElement endTimeDropdown;
	
	@FindBy(id="timePickerItem_42")
	WebElement time9PM;
	
	@FindBy(id="timePickerItem_38")
	WebElement time7PM;
	
	@FindBy(name="save")
	WebElement save;

	@FindBy(xpath = "//a[contains(text(),'4:00 PM')]")
	WebElement link4PM;
	
	@FindBy(id="IsRecurrence")
	WebElement recurrenceCheckBox;
	
	@FindBy(id="rectypeftw")
	WebElement weeklyRadioButton;
	
	@FindBy(id="wi")
	WebElement recurrenceEvery;
	
	@FindBy(id="RecurrenceEndDateOnly")
	WebElement recurrenceEndDate;

	@FindBy(xpath="//img[@title='Next Month']")
	WebElement nextMonth;
	
	@FindBy(xpath="//table/tbody/tr[@id='calRow3']/td[4]")
	WebElement twoWeeksFromNow;
	
	public void clickHomeTab() {
		explicitwait(10, homeTab);
		homeTab.click();
		explicitwait(10, closepopup);
		closePopup(closepopup);

	}

	public void clickFirstnameLatNameLink() {
		explicitwait(10, firstNameLastNameLink);
		firstNameLastNameLink.click();
	}

	public void clickPlusTab() {
		plusTab.click();
	}

	public void clickCustomizeMyTabs() {
		customizeMyTabs.click();
	}

	public void selectChatterFromSelectedTabs() {
		Select reports = new Select(selectedTabs);
		reports.selectByValue("Chatter");
	}

	public void clickRemove() {
		remove.click();
	}

	public void SelectChatterFromAailableTabs() {
		Select availableTabsDopdown = new Select(availableTabs);
		availableTabsDopdown.selectByValue("Chatter");

	}

	public void validatechatterTab(String nameExpected) {
		String nameActual = chatterTab.getText();
		validateText(nameActual, nameExpected);
	}

	public void clickDateLink() {
		dateLink.click();
	}

	public void click8PM() {
		link8PM.click();
	}

	public void clickSubjectCombo() {
		subjectCombo.click();
	}

	public void SwitchToChildWindowAndClickOther() {
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent :"+ parentWindow);
		
		String childWindow=null;
		
		for(String handle: driver.getWindowHandles())
			childWindow = handle;
		
		System.out.println("Child :"+childWindow);
		driver.switchTo().window(childWindow);
		
		linkOther.click();
		
		driver.switchTo().window(parentWindow);
	}
	
	public void clickEndTime_Time() {
		endTime_Time.click();
	}
	
	public void validateTimeDisplayedInDropdown(String timeExpected) {
		String timeActual=endTime_Time.getAttribute("value");
		Assert.assertEquals(timeActual, timeExpected);
	}
	
	public void select9PmfromDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(endTimeDropdown).build().perform();
		time9PM.click();
	}
	
	public void clickSave() {
		save.click();
	}
	
	public void click4PM() {
		link4PM.click();
	}
		
	public void select7PmfromDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(endTimeDropdown).build().perform();
		time7PM.click();
	}

	public void clickCreateRecurringEventCheckBox() {
		recurrenceCheckBox.click();
	}

	public void clickWeeklyRadioButton() {
		weeklyRadioButton.click();
	}
	
	public void validateRecurrenceEveryTextBox(String valueExpected) {
		String valueActual = recurrenceEvery.getText();
		validateText(valueActual, valueExpected);
	}
	
	public void clickRecurrenceEndDate() {
		recurrenceEndDate.click();
	}
		
	public void select2WeeksFromNow() {
		//today 3/29/2023 
		//2Weeks from now ::: 4/12/2023
		
		nextMonth.click();
		twoWeeksFromNow.click();
		
	}
	
	@FindBy(xpath="//img[@title='Month View']")
	WebElement monthView;
	
	public void clickMonthView() {
		monthView.click();
	}
}
