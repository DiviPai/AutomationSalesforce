package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testng.base.BasePage;

public class DeveloperConsolePage extends BasePage{

	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Developer Console']")
	WebElement developerConsole;
	
	public void clickDeveloperConsole() {
		developerConsole.click();
		String parentHandle = driver.getWindowHandle();
		String childHandle = null;
		
		for(String handle: driver.getWindowHandles()) {
			childHandle = handle;
			System.out.println(handle);
		}
		driver.switchTo().window(childHandle);
		driver.close();
		driver.switchTo().window(parentHandle);
		
	}
	
}
