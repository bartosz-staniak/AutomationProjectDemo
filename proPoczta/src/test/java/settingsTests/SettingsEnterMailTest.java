package settingsTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proPocztaPages.SuperSettingsScenario;

import static org.junit.Assert.*;


public class SettingsEnterMailTest {
	
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
		SuperSettingsScenario login = new SuperSettingsScenario(driver);
		login.enterMail();
		
		assertTrue(driver.getTitle().toLowerCase().contains("mail"));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
