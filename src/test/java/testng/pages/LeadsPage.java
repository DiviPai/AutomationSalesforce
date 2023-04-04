package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testng.base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="fcf")
	WebElement leadsDropdown;
	
	@FindBy(name="go")
	WebElement go;
	
	@FindBy(name="new")
	WebElement newButton;
	
	@FindBy(id="name_lastlea2")
	WebElement lastNmae;
	
	@FindBy(id="lea3")
	WebElement company;
	
	@FindBy(name="save")
	WebElement save;
	
	@FindBy(xpath="//h2[contains(text(),'ABCDE')]")
	WebElement header;
	
	public void validateLeadsDropdown(String dropdownExpected) {
		String dropdownActual = leadsDropdown.getText();
		validateText(dropdownActual, dropdownExpected);
	}
	
	public void selectUnreadLeadsFromLeadsDropdown() {
		Select leads = new Select(leadsDropdown);
		leads.selectByValue("00BDm0000046TRH");
	}
	
	public void clickGo() {
		go.click();
	}

	public void selectTodaysLeadsFromLeadsDropdown() {
		Select leads = new Select(leadsDropdown);
		leads.selectByValue("00BDm0000046TRV");
	}
	
	public void enterlastName(String strLastName) {
		lastNmae.sendKeys(strLastName);
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void enterCompany(String strCompany) {
		company.sendKeys(strCompany);
	}
	
	public void clickSave() {
		save.click();
	}
	
	public void validateHeader(String headerExpected) {
		String headerActual = header.getText();
		validateText(headerActual, headerExpected);
	}
}
