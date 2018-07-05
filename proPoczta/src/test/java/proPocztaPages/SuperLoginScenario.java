package proPocztaPages;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperLoginScenario {
	
	private WebDriver driver;
	
	String name = "USERNAME GOES HERE";
	String password = "PASSWORD GOES HERE";
	
	private static String LOGIN_URL = "URL GOES HERE";
	
	private WebElement mainLogin;
	private WebElement mainPassword;
	
	@FindBy(xpath = "//*[@id=\"top\"]/div[3]/div[1]/div[2]/div/span")
	private WebElement closeButton;
	
	@FindBy(className = "loginButton")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"loginArea\"]/div[1]/div/div[1]/strong/span")
	private WebElement errorMessage;
	
	@FindBy(className = "logout")
	private WebElement logoutButton;
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	
	
	public SuperLoginScenario(WebDriver driver) {
		this.driver = driver;
		driver.get(LOGIN_URL);
		PageFactory.initElements(driver, this);
		this.login(name, password);
	}
	
	public SuperLoginScenario(WebDriver driver, String name, String password) {
		this.driver = driver;
		driver.get(LOGIN_URL);
		PageFactory.initElements(driver, this);
		this.name = name;
		this.password = password;
		this.login(name, password);
	}

	/**
	 * The following method logs into the webmail and logs out
	 * @param name, username used as logging in credential
	 * @param password, password used as logging in credential
	 */
	public void login(String name, String password) {
		mainLogin.sendKeys(name);
		mainPassword.sendKeys(password);
		closeButton.click(); // closes the pop-up window
		loginButton.click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void logout() {
		logoutButton.click();
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
}
