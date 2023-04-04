package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testng.base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="new")
	WebElement newButton;
	
	@FindBy(id="name_lastcon2")
	WebElement lastname;
	
	@FindBy(id="con4_lkwgt")
	WebElement SearchaccName;
	
	@FindBy(name="save")
	WebElement save;
	
	@FindBy(xpath="//a[text()='Create New View']")
	WebElement createNewView;
	
	@FindBy(id="fname")
	WebElement viewName;
	
	@FindBy(id="devname")
	WebElement viewUniqueName;
	
	@FindBy(xpath="//select[@name='fcf']/option[@selected='selected']")
	WebElement newViewCreated;
	
	@FindBy(id="hotlist_mode")
	WebElement dropdown;
	
	@FindBy(xpath="//h3[text()='Recent Contacts']")
	WebElement header;
	
	@FindBy(id="searchFrame")
	WebElement searchFrame;
	
	@FindBy(id="lksrch")
	WebElement enterIntoSearch;
	
	@FindBy(id="resultsFrame")
	WebElement resultFrame;
	
	@FindBy(name="go")
	WebElement go;
	
	@FindBy(xpath="//a[text()='Global Media']")
	WebElement globalMedia;
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void enterLastname(String strLastname) {
		lastname.sendKeys(strLastname);
	}
	
	public void enterAccountname(String accName) {
		SearchaccName.sendKeys(accName);
	}
	
	public void enterCampaignname(String strAccname) {
		SearchaccName.click();
		String parentWindow = driver.getWindowHandle();
		String childWindow = null;
		for (String handle : driver.getWindowHandles())
			childWindow = handle;

		driver.switchTo().window(childWindow);

		explicitwait(5, searchFrame);
		driver.switchTo().frame(searchFrame);
		enterIntoSearch.sendKeys(strAccname);
		go.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(resultFrame);
		globalMedia.click();
		driver.switchTo().window(parentWindow);
	}
	
	public void clickSave() {
		save.click();
	}
	
	public void clickCreateNewView() {
		createNewView.click();
	}
	
	public void enterViewName(String vname) {
		viewName.sendKeys(vname);
	}
	
	public void enterViewUniqueName(String uniqueVname) {
		viewUniqueName.click();
		viewUniqueName.clear();
		viewUniqueName.sendKeys(uniqueVname);
	}
	
	public void checkNewViewCreatedDisplayed(String viewNameExpected) {
		String viewNameActual = newViewCreated.getText();
		validateText(viewNameActual, viewNameExpected);
	}
	
	public void selectRecentlyCreatedFromDropdown() {
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByValue("2");
	}
	
	public void validateRecentContacts() {
		String expected="Recent Contacts";
		String actual = header.getText();
		validateText(actual, expected);
	}
	
	@FindBy(name="fcf")
	WebElement contactsDropdown;
	
	@FindBy(xpath="//a[contains(text(),'Gonzalez')]")
	WebElement contactGonzalez;
	
	@FindBy(xpath="//div[@class='errorMsg'][1]")
	WebElement errorMsg;
	
	@FindBy(name="cancel")
	WebElement cancel;
	
	public void selectMyContactsfromDropdown() {
		Select dropdown = new Select(contactsDropdown);
		dropdown.selectByValue("00BDm0000046TSC");
	}
	
	public void selectAllContactsfromDropdown() {
		Select dropdown = new Select(contactsDropdown);
		dropdown.selectByValue("00BDm0000046TNQ");
	}
	
	public void clickContactGonzalez() {
		contactGonzalez.click();
	}
	
	public void validateErrorMsg(String errorExpected) {
		String errorActual = errorMsg.getText();
		validateText(errorActual, errorExpected);
	}
	
	public void clickCancel() {
		cancel.click();
	}
}
