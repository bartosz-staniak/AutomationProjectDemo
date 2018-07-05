package loginTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import proPocztaPages.SuperLoginScenario;

import static org.junit.Assert.*;


public class LoginEmptyCredentialsTestCase {
	
	WebDriver driver;
	String name = "";
	String password = "";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Path\\toFile\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void EnterEmailPage() {
		SuperLoginScenario login = new SuperLoginScenario(driver, name, password);
		
		assertEquals("credentials missing", login.getErrorMessage().toLowerCase());
		
	}
	
	@After
	public void close() {
		driver.close();
	}
}
