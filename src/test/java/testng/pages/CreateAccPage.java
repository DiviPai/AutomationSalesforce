package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testng.base.BasePage;

public class CreateAccPage extends BasePage {

	public CreateAccPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "new")
	WebElement newButton;

	@FindBy(id = "acc2")
	WebElement accountName;

	@FindBy(id = "acc6")
	WebElement typeDropDown;

	@FindBy(id = "00NDm000005yMNq")
	WebElement customerPriorityDropdown;

	@FindBy(name = "save")
	WebElement save;

	@FindBy(xpath = "//h2[contains(text(),'Divya Pai')]")
	WebElement newAccName;

	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement createNewView;

	@FindBy(id = "fname")
	WebElement viewName;

	@FindBy(id = "devname")
	WebElement uniqueViewName;

	@FindBy(name = "fcf")
	WebElement viewDropDown;

	@FindBy(id = "hotlist_mode")
	WebElement dropdown;

	@FindBy(xpath = "//a[text()='Edit']")
	WebElement edit;

	@FindBy(id = "fcol1")
	WebElement fieldDropdown;

	@FindBy(id = "fop1")
	WebElement operatorDropdown;

	@FindBy(id = "fval1")
	WebElement value;

	@FindBy(xpath = "//a[text()='Merge Accounts']")
	WebElement mergeAccount;

	@FindBy(id = "srch")
	WebElement search;

	@FindBy(name = "srchbutton")
	WebElement searchButton;

	@FindBy(id = "cid0")
	WebElement checkBox1;

	@FindBy(id = "cid1")
	WebElement checkBox2;

	@FindBy(id="cid2")
	WebElement checkBox3;
	
	@FindBy(name = "goNext")
	WebElement goNext;

	public void clickNewButton() {
		explicitwait(10, newButton);
		newButton.click();
	}

	public void enterAccountName(String accName) {
		accountName.sendKeys(accName);
	}

	public void selectTechnologyPartnerFromTypeDropdwon() {
		Select type = new Select(typeDropDown);
		type.selectByVisibleText("Technology Partner");
	}

	public void selectHighFromCustomerPriorityDropdown() {
		Select customerPriority = new Select(customerPriorityDropdown);
		customerPriority.selectByValue("High");

	}

	public void clickSave() {
		save.click();
	}

	public void validateNewAccount(String accNameExpected) {
		explicitwait(10, newAccName);
		String accNameActaul = newAccName.getText();
		validateText(accNameActaul, accNameExpected);

	}
	
	@FindBy(xpath="//select[@name='fcf']/option[@selected='selected']")
	WebElement defaultView;

	public void validateNewView(String viewExpected) {
		explicitwait(10, viewDropDown);
//		String viewActual = viewDropDown.getText();
		String viewActual= defaultView.getText();
		validateText(viewActual, viewExpected);
	}

	public void clickCreateNewView() {
		createNewView.click();
	}

	public void enterViewName(String viewname) {
		viewName.clear();
		viewName.sendKeys(viewname);
	}

	public void enterUniqueViewName(String unique) {
		uniqueViewName.click();
		uniqueViewName.clear();
		uniqueViewName.sendKeys(unique);
	}

	public void selectViewFromDropdown(String viewname) {
		Select view = new Select(viewDropDown);
		view.selectByVisibleText(viewname);
	}

	public void clickEdit() {
		edit.click();
	}

	public void selectAccountNameFromFieldDropdown() {
		Select field = new Select(fieldDropdown);
		field.selectByValue("ACCOUNT.NAME");

	}

	public void selectContainsFromOperatorDropdown() {
		Select operator = new Select(operatorDropdown);
		operator.selectByValue("c");
	}

	public void enterValue(String strValue) {
		value.sendKeys(strValue);
	}

	public void clickMergeAccount() {
		mergeAccount.click();
	}

	public void enterIntoSeach(String accname) {
		explicitwait(5, search);
		search.sendKeys(accname);
	}

	public void clickFindAccounts() {
		searchButton.click();
	}

	public void clickFirstCheckBox() {
		explicitwait(10, checkBox1);
		checkBox1.click();
	}

	public void clickSecondCheckBox() {
		checkBox2.click();
	}
	
	public void uncheckThirdCheckBox() {
		checkBox3.click();
	}

	public void clickGoNext() {
		goNext.click();
	}

	@FindBy(xpath = "//h1[text()='Merge My Accounts']")
	WebElement headerMerge;

	@FindBy(xpath = "//h2[contains(text(),'Step 2')]")
	WebElement secondHeader;

	public void validateHeader(String headerExpected) {
		explicitwait(5, headerMerge);
		String headerActual = headerMerge.getText();
		validateText(headerActual, headerExpected);
	}

	public void validateSecondHeader(String secondHeaderExpected) {
		String secondHeaderActual = secondHeader.getText();
		validateText(secondHeaderActual, secondHeaderExpected);
	}

	public void selectRecentlyViwedFromDropdown() {
		closeAlert();
		explicitwait(5, dropdown);
		Select fromDropDown = new Select(dropdown);
		fromDropDown.selectByValue("3");
	}

	@FindBy(xpath="//a[contains(text(),'> 30 days')]")
	WebElement lastActivity;
	
	@FindBy(id="ext-comp-1042")
	WebElement fromDate;
	
	@FindBy(id="ext-comp-1045")
	WebElement todate;
	
	@FindBy(id="ext-gen63")
	WebElement runReport;
	
	public void enterFromDate(String date) {
		fromDate.sendKeys(date);
	}
	
	public void eneterToDate(String date) {
		todate.sendKeys(date);
	}
	
	public void clickLastActivity() {
		lastActivity.click();
	}
	
	public void clickRunReport() {
		runReport.click();
	}
}
