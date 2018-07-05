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


public class MailComposeCancelTest {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Path\\toFile\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void ComposeCorrectMessage() {
		SuperComposeScenario login = new SuperComposeScenario(driver, true);
		
		
		
		new WebDriverWait(driver, 10)
		.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver drive) {
				return drive.findElement(By.id("acceptPopup")).isDisplayed();
			}
		});
		
		assertTrue(login.getConfirmationPopup().getText().contains("Mail not sent."));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
