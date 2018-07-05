package proPocztaPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperMailScenario extends SuperSettingsScenario {

	Boolean isPresent;
	
	WebDriverWait wait = new WebDriverWait(getDriver(), 10);
	
	@FindBy(id = "WriteButton")
	private WebElement newMailButton;
	
	@FindBy(className = "newMail")
	private WebElement newMessages;
	
	@FindBy(className = "showMail")
	private WebElement newCompleteMessages;
	
	@FindBy(className = "BigButton")
	private WebElement IUnderstandButton;
	
	@FindBy(id = "SliderClose")
	private WebElement slidebarCloseButton;
	
	private WebElement DismissAdvertOnTheRight;
	
	private WebElement bottom;
	
	
	public SuperMailScenario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		enterMail();
	}

	public SuperMailScenario(WebDriver driver, String name, String password) {
		super(driver, name, password);
		// TODO Auto-generated constructor stub
		enterMail();
	}
	
	
	public void Compose() {
		
		/**
		 * Perhaps it is an overkill idea to use the sleep method,
		 * yet ads nature seems to be somewhat unpredictable and
		 * results in loss of focus, so that is why I chose it.
		 */
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new WebDriverWait(getDriver(), 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver drive) {
				return drive.findElement(By.id("NewMail-button"))
						.isEnabled();
				}
			});
		newMailButton.click();
	}
	
	public WebElement SearchMessagesBySender (String from) {
		List<WebElement> senders = getDriver().findElements
				(By.className("Name-of-sender"));
		for (WebElement sender : senders) {
			if (sender.getText().equals(from)) {
				
				try {
					sender.click();
				} catch (WebDriverException wde) {
					wde.printStackTrace();
				}
				
				return sender;
			}
		}
		return null;
	}
	
	public WebElement SearchMessagesBySubject (String about) {
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("SubjectOfMail")));
		
		List<WebElement> subjects = getDriver().findElements
				(By.className("SubjectOfMail"));
		for (WebElement subject : subjects) {
			if (subject.getText().contains(about)) {
				
				try {
					subject.click();
				} catch (WebDriverException wde) {
					wde.printStackTrace();
				}
				
				return subject;
			}
		}
		return null;
	}
	
	public WebElement SearchMessagesBy (String from, String about) {
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		try {
		while (isPresent = getDriver().findElements(By.id("RAdvertDismiss")).size() > 0) {
			clickCloseAd();
		}
		} catch (WebDriverException wde) {
			// do nothing as a workaround for the not visible Ad exception
			// and for another element would receive the click exception
		}
		
		/*
		try {
		bottom.click(); 
		} catch (WebDriverException wde) {
			// do nothing as a workaround for another element receiving click
		}
		*/
		
		List<WebElement> allMessages = getDriver().findElements
				(By.cssSelector(".showMail.show"));
		for (WebElement message : allMessages) {
			
			String contactText = "";
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("Name-of-sender")));
			
			isPresent = message.findElements(By.className("Name-of-sender")).size() > 0;
			if (isPresent) {
				WebElement contact = message.findElement(By.className("Name-of-sender"));
				contactText = contact.getText();
			}
			
			isPresent = message.findElements(By.className("myMessage")).size() > 0;
			if (isPresent) {
				WebElement contact = message.findElement(By.className("myMessage"));
				contactText = contact.getText();
			}
			
			WebElement subject = message.findElement(By.className("SubjectOfMail"));
			String subjectText = subject.getText();
			 
			if (contactText.toLowerCase().contains(from.toLowerCase()) 
					&& subjectText.toLowerCase().contains(about.toLowerCase())) {
				System.out.println(message.getText());

				message.click();
				
				return message;
			}
		}
		return null;
	}
	
	public WebElement isNewMessages() {
		return newMessages;
	}
	
	public void clickIUnderstand() {
		IUnderstandButton.click();
	}
	
	public void clickCloseSlidebar() {
		slidebarCloseButton.click();
	}
	
	public void clickCloseAd() {
		
		DismissAdvertOnTheRight.click();
		
	}

}
