package testng.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public void takeScreenshot(String testcase) {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(date);
		
		String strPath = "C:\\Users\\Prabhu\\eclipse-workspace\\TestNGFramework\\SalesforceScreenshot\\TestCase"+testcase+timeStamp+".jpeg";
		
		File destfile = new File(strPath);
		
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
	}
	
	public void validateTitle(String expectedTitle) throws InterruptedException {
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void validateErrMsg(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}
	
	public void closeWindow() {
		driver.close();
	}
	
}
