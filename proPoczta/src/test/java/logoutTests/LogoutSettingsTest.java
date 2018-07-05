package logoutTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proPocztaPages.SuperSettingsScenario;

import static org.junit.Assert.*;


public class LogoutSettingsTest {
	
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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(login.getLogoutButton()));
		
		login.logout();
		
		assertTrue(driver.getTitle().toLowerCase().contains("sign in"));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
