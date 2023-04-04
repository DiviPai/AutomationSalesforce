package testng.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void explicitwait(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void closePopup(WebElement element) {
		explicitwait(10, element);
		element.click();
	}
	
	public void validateText(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public void closeAlert() {
		driver.switchTo().alert().accept();
	}
	
	
}
