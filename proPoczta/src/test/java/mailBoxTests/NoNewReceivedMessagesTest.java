/**
 * This test should be performed along with NewReceivedMessagesTest.
 * If both tests end with the same result, then something is broken.
 */

package mailBoxTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proPocztaPages.SuperMailScenario;

import static org.junit.Assert.*;


public class NoNewReceivedMessagesTest {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Path\\toFile\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void EnterEmailPage() {
		SuperMailScenario login = new SuperMailScenario(driver);
		
		try {
			Thread.sleep(5000); // Allowing the page to load
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertFalse(login.isNewMessages().isDisplayed());
	}
	
	@After
	public void close() {
		driver.close();
	}
}
