package mailBoxTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proPocztaPages.SuperMailScenario;

import static org.junit.Assert.*;


public class SearchMailBySubjectTest {
	
	WebDriver driver;
	
	String about = "test";
	
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
		WebElement subject = login.SearchMessagesBySubject(about);
		assertTrue(subject.getText().contains(about));
	}
	
	@After
	public void close() {
		driver.close();
	}
}
