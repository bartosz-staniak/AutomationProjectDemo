package proPocztaPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperAttachmentsScenario extends SuperMailScenario {

	private String from;
	private String about;
	
	@FindBy(className = "getAttachments")
	private WebElement downloadAttachmentButton;
	
	@FindBy(id = "get-all-attachments")
	private WebElement downlaodAllAttachmentsButton;
	
	public SuperAttachmentsScenario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public SuperAttachmentsScenario(WebDriver driver, String from, String about) {
		super(driver);
		this.from = from;
		this.about = about;
		SearchMessagesBy(this.from, this.about);
	}
	
	/**
	 * Not working
	 */
	public void clickDownloadAttachmentButton() {
		downloadAttachmentButton.click();
	}
	
	
	/**
	 * Working
	 */
	public void clickDownloadAllattachmentsButton() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(downlaodAllAttachmentsButton));
		downlaodAllAttachmentsButton.click();
	}
	
	
	/**
	 * Working
	 */
	public void downloadAttachments() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement>attachments = getDriver()
				.findElements(By.className("fileName"));
		for (WebElement attachment : attachments) {
			String attach = attachment.getText();
			System.out.println(attach);
			attachment.click();
		}
	}

}
