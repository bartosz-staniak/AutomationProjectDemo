package proPocztaPages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperComposeScenario extends SuperMailScenario {

	String addressee = "EMAIL ADDRESS GOES HERE";
	String subject = "test";
	String mailBody = "test, test, test";
	String attachement = "C:\\Users\\User\\Downloads\\protest.txt";
	Boolean cancel = false;
	
	@FindBy(id = "newmailInput")
	private WebElement addressField;
	
	@FindBy(id = "newmailHead")
	private WebElement subjectField;
	
	@FindBy(className = "SIF")
	private WebElement setStandardInputField;
	
	@FindBy(id = "loadIt")
	private WebElement makeElementVisible;
	
	@FindBy(id = "SaveIt")
	private WebElement popupConfirmButtonSave;
	
	@FindBy(id = "EditIt")
	private WebElement messageField;
	
	private WebElement includeThisFile;
	
	@FindBy(xpath = "//*[@id=\"sendNewMail\"]/ul[1]/li[2]")
	private WebElement sendButton;
	
	@FindBy(id = "doNotSend")
	private WebElement dismissItButton;
	
	private WebElement acceptThisPopup;
	
	private WebElement isNotFilledError;
	
	private WebElement dismissThisPopup;
	
	public SuperComposeScenario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.addressee = addressee;
		this.subject = subject;
		this.mailBody = mailBody;
		this.attachement = attachement;
		this.cancel = cancel;
		Compose();
		SendMessage(addressee, subject, mailBody, attachement, cancel);
	}
	
	public SuperComposeScenario(WebDriver driver, Boolean cancel) {
		super(driver);
		
		this.addressee = addressee;
		this.subject = subject;
		this.mailBody = mailBody;
		this.attachement = attachement;
		this.cancel = cancel;
		Compose();
		SendMessage(addressee, subject, mailBody, attachement, cancel);
	}

	public SuperComposeScenario(WebDriver driver, String name, String password) {
		super(driver, name, password);
		// TODO Auto-generated constructor stub
		Compose();
	}
	
	public SuperComposeScenario(WebDriver driver, String addressee, String subject,
				String mailBody, String attachement) {
		super(driver);
		this.getDriver();
		this.addressee = addressee;
		this.subject = subject;
		this.mailBody = mailBody;
		this.attachement = attachement;
		this.cancel = cancel;
		Compose();
		SendMessage(addressee, subject, mailBody, attachement, cancel);
	}
	
	public void SendMessage(String addressee, String subject, String mailBody, String attachment,
					Boolean cancel) {
		
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		addressField.sendKeys(addressee);
		subjectField.sendKeys(subject);
			new WebDriverWait(getDriver(), 10).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver drive) {
					return drive.findElement(By.className("link3")).isDisplayed();
				}
			});
		setStandardInputField.click();
		makeElementVisible.click();
			new WebDriverWait(getDriver(), 10)
					.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver drive) {
							return drive.findElement(By.id("popupConfirmButtonSave")).isDisplayed();
						}
					});
			assertTrue(popupConfirmButtonSave.isDisplayed());
		popupConfirmButtonSave.click();
		messageField.sendKeys(mailBody);
		
		includeThisFile.sendKeys("C:\\Users\\User\\Downloads\\protest.txt");
		
		/**
		 * Sleeps in order to allow a pop-up to disappear.
		 */
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (!cancel) sendButton.click();
		if (cancel) dismissItButton.click();
		
	}
	
	public WebElement getConfirmationPopup() {
		return acceptThisPopup;
	}
	
	public void clickConfirmPopupButton() {
		popupConfirmButtonSave.click(); 
	}
	
	public WebElement getTooltip() {
		return isNotFilledError;
	}

}
