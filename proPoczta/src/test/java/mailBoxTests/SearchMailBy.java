package mailBoxTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proPocztaPages.SuperMailScenario;

import static org.junit.Assert.*;


public class SearchMailBy {
	
	WebDriver driver;
	
	String from = "Me";
	String about = "Test";
	
	@Before
	public void setup() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Path\\toFile\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void EnterEmailPage() {
		SuperMailScenario login = new SuperMailScenario(driver);
		WebElement subject = login.SearchMessagesBy(from, about);
		assertTrue(subject.getText().toLowerCase().contains(about.toLowerCase()));
		assertTrue(subject.getText().toLowerCase().contains(from.toLowerCase()));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
