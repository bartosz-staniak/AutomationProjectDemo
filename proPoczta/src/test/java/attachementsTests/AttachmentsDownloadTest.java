package attachementsTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proPocztaPages.SuperAttachmentsScenario;

import static org.junit.Assert.*;


public class AttachmentsDownloadTest {
	
	WebDriver driver;
	
	String from = "Me";
	String about = "testtest";
	
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
		SuperAttachmentsScenario login = new SuperAttachmentsScenario(driver, from, about);
		login.downloadAttachments();
	}
	
	@After
	public void close() {
		driver.close();
	}
}
