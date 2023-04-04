package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testng.base.BasePage;

public class UserMenuDropdownPage extends BasePage {

	public UserMenuDropdownPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@title='Home Tab']")
	WebElement homeTab;
	
	@FindBy(id="userNavLabel")
	WebElement userMenuDropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(id="userNav-menuItems")
	WebElement userMenuDropDownList;
	
	@FindBy(xpath="//a[text()='My Profile']")
	WebElement myProfile;
	
	@FindBy(xpath="//a[text()='My Settings']")
	WebElement mySettings;
	
	@FindBy(xpath="//a[text()='Accounts']")
	WebElement accountsTab;
	
	@FindBy(xpath="//a[text()='Opportunities']")
	WebElement opportunutiestab;
	
	@FindBy(xpath="//a[text()='Leads']")
	WebElement leadsTab;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsTab;
	
	public void lookForHomeTab() {
		explicitwait(10,homeTab);
	}
	
	public void clickHomeTab() {
		explicitwait(10,homeTab);
		homeTab.click();	
	}
	
	public void ValidateUsername(String expected) {
		explicitwait(5, homeTab);
		String actual = userMenuDropdown.getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void clickUserMenuDropdown() {
		explicitwait(10,userMenuDropdown);
		userMenuDropdown.click();
	}
	
	public void clickLogout() {
		explicitwait(5, logout);
		logout.click();
	}
	
	public void validateUserMenuDropdown(String listExpected) {
		String listActual = userMenuDropDownList.getText();
		
		validateText(listActual, listExpected);
	}
	
	public void clickMyProfile() {
		myProfile.click();
	}
	
	public void clickMySettings() throws InterruptedException {
		mySettings.click();
		Thread.sleep(5000);
	}
	
	@FindBy(id="tryLexDialogX")
	WebElement closepopup;
	
	public void clickAccountsTab() {
		explicitwait(5, accountsTab);
		accountsTab.click();
		closePopup(closepopup);
	}
	
	public void clickOpportunitiesTab() {
		explicitwait(5, opportunutiestab);
		opportunutiestab.click();
		closePopup(closepopup);
	}
	
	public void clickLeadsTab() {
		explicitwait(25, leadsTab);
		leadsTab.click();
		explicitwait(5, closepopup);
		closePopup(closepopup);
	}
	
	public void clickLeadsTabAgain() {
		explicitwait(25, leadsTab);
		leadsTab.click();
	}
	
	public void clickContactsTab() {
		explicitwait(5, contactsTab);
		contactsTab.click();
		closePopup(closepopup);
	}
}
