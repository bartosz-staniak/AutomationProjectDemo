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


public class MailComposeEmptyAdresseeTest {
	
	WebDriver driver;
	String addressee = "";
	String subject = "test";
	String mailBody = "test, test, test";
	String attachement = "C:\\Attachment\\location\\attachment\\protest.txt";
	
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
				return drive.findElement(By.id("NoReceipientError")).isDisplayed();
			}
		});
		
		assertTrue(login.getTooltip().getText().toLowerCase().contains("Receipient missing"));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
