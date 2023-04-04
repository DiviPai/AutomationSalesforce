package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testng.base.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement login;
	
	@FindBy(id="error")
	WebElement error;
	
	@FindBy(id="rememberUn")
	WebElement rememberMe;
	
	@FindBy(id="forgot_password_link")
	WebElement forgotYourPassword;
	
	@FindBy(id="un")
	WebElement usernameToResetYourPassword;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(xpath="//p[contains(text(),'sent you an email')]")
	WebElement checkYourEmail;
	
	@FindBy(id="idcard-identity")
	WebElement savedEmail;
		
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	public void enterUsername(String strUsername) {
		username.sendKeys(strUsername);
	}
	
	public void enterPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	public void clickLogIn() {
		login.click();
	}
	
	public String getErrorMsg() {
		String errMsg = error.getText();
		return errMsg;
	}
	
	public void clickRememberMeCheckBox() {
		rememberMe.click();
	}
	
	public void clickForgotYourPassword() {
		forgotYourPassword.click();
	}
	
	
	public void enterUsernameToResetYourPassword(String strUsername) {
		usernameToResetYourPassword.sendKeys(strUsername);
	}

	public void clickContinueButton() {
		continueButton.click();
	}
	
	public void validateEmailSent(String strExpected) {
		String textActual= checkYourEmail.getText();
		System.out.println(textActual);
		System.out.println(strExpected);
		Assert.assertEquals(textActual, strExpected);
	}
	
	public void validateDisplayedUserName(String strExpected) {
		String usernameSaved = savedEmail.getText();
		Assert.assertEquals(usernameSaved, strExpected);
	}
}
