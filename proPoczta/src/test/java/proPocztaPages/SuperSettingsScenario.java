package proPocztaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuperSettingsScenario extends SuperLoginScenario {

	@FindBy(className = "mail_graphics")
	private WebElement mailIcon;
	
	public SuperSettingsScenario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SuperSettingsScenario(WebDriver driver, String name, String password) {
		super(driver, name, password);
		// TODO Auto-generated constructor stub
	}
	
	public void enterMail() {
		mailIcon.click();
	}
}
