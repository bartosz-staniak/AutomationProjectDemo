package ComposeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proPocztaPages.SuperComposeScenario;

import static org.junit.Assert.*;


public class MailComposeEmptySubjectTest {
	
	WebDriver driver;
	String addressee = "RECEIPIENT GOES HERE";
	String subject = "";
	String mailBody = "test, test, test";
	String attachement = "C:\\Attachment\\Location\\Attachment\\protest.txt";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Path\\toFile\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void ComposeCorrectMessage() {
		SuperComposeScenario login = new SuperComposeScenario(driver,
				addressee, subject, mailBody, attachement);
		
		new WebDriverWait(driver, 10)
		.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver drive) {
				return drive.findElement(By.id("acceptPopup")).isDisplayed();
			}
		});
		
		assertTrue(login.getConfirmationPopup().getText().toLowerCase()
				.contains("header missing. send anway?"));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
