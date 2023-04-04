package testng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testng.base.BasePage;

public class MyProfilePage extends BasePage {

	public MyProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']")
	WebElement editProfile;
	
	@FindBy(id="contactInfoContentId")
	WebElement iframeEditConatc;
	
	@FindBy(id="aboutTab")
	WebElement aboutTab;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAll;
	
	@FindBy(id="tailBreadcrumbNode")
	WebElement displayedUsername;
	
	@FindBy(id="publisherAttachTextPost")
	WebElement postLink;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement iframePost;
	
	@FindBy(tagName="body")
	WebElement shareAnUpadte;
	
	@FindBy(id="publishersharebutton")
	WebElement shareButton;
	
	@FindBy(id="hoverItem121")
	WebElement author;
	
	@FindBy(xpath="//p[contains(text(),'Framework')]")
	WebElement postDisplayed;
	
	@FindBy(id="spillovermenu0D5Dm00000HG1RP")
	WebElement postDropdown;
	
	@FindBy(xpath="//a[text()='Delete']")
	WebElement delete;
	
	@FindBy(id="simpleDialog1button0")
	WebElement okButton;	

	@FindBy(id="publisherAttachContentPost")
	WebElement file;
	
	@FindBy(id="chatterUploadFileAction")
	WebElement uploadFileFromComputer;
	
	@FindBy(id="chatterFile")
	WebElement chooseFile;
	
	@FindBy(id="publishersharebutton")
	WebElement share;
	
	@FindBy(id="photoSection")
	WebElement photoSection;
	
	
	public void clickEditProfile() {
		explicitwait(15, editProfile);
		editProfile.click();
		driver.switchTo().frame(iframeEditConatc);
	}
	
	public void clickAboutTab() {
		aboutTab.click();
	}
	
	public void updtaeLastname(String strLastname) {
		lastname.clear();
		lastname.sendKeys(strLastname);
	}

	public void clickSaveAll() {
		saveAll.click();
		driver.switchTo().parentFrame();
	}
	
	public void validateDispalyedUsername(String expected) {
		String actaul = displayedUsername.getText();
		Assert.assertEquals(actaul, expected);
	}
	
	public void enterAnUpdateToShare(String strMsg) {
		shareAnUpadte.sendKeys(strMsg);
		driver.switchTo().parentFrame();
	}

	public void clickPostLink() {
		postLink.click();
		driver.switchTo().frame(iframePost);
	}
	
	public void clickShare() {
		shareButton.click();
		
	}
	
	public void validateAuthor(String authorExpected) {
		String authorActual = author.getText();
		Assert.assertEquals(authorActual, authorExpected);
	}
	
	public void validatePostDisplayed(String postExpected) {
		explicitwait(5, postDisplayed);
		String postActual = postDisplayed.getText();
		Assert.assertEquals(postActual, postExpected);
		
	}
	
	
	public void clickPostDropdown() {
		postDropdown.click();
	}
	
	public void clickDelete() {
		delete.click();
	}
	
	public void clickOkPopup() {
		explicitwait(5, okButton);
		okButton.click();
	}
	
	public void clickFile() {
		explicitwait(5, file);
		file.click();
	}
	
	public void clickUploadFileFromComputer() {
		explicitwait(25, uploadFileFromComputer);
		uploadFileFromComputer.click();
	}
	
	public void chooseFile(String filePath) {
		explicitwait(25, chooseFile);
		chooseFile.sendKeys(filePath);
	}
	
	public void shareFile() {
		share.click();
	}
	
	public void hoverPhotoSection() {
		Actions action = new Actions(driver);
		action.moveToElement(photoSection).build().perform();		
	}
	
	@FindBy(id="uploadLink")
	WebElement addPhoto;
	
	@FindBy(id="uploadPhotoContentId")
	WebElement iframeUploadPhoto;
	
	@FindBy(id="j_id0:uploadFileForm:uploadInputFile")
	WebElement choosePhoto;
	
	@FindBy(id="j_id0:uploadFileForm:uploadBtn")
	WebElement save;
	
	@FindBy(id="j_id0:j_id7:save")
	WebElement savePhoto;
	
	public void clickAddPhoto() {
		explicitwait(10, addPhoto);
		addPhoto.click();
		explicitwait(10, iframeUploadPhoto);
		driver.switchTo().frame(iframeUploadPhoto);
	}
	
	public void choosePhoto() {
		choosePhoto.sendKeys("C:\\Users\\Prabhu\\Desktop\\God.jpg");
	}
	
	
	public void clickSave() {
		save.click();
	}
	
	public void clickSaveAgain(){
		
		explicitwait(30, savePhoto);
		savePhoto.click();
	}

}

