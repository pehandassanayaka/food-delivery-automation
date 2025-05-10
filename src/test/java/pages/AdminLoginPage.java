package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage extends PageBase {
	private String inputUserName = "//input[@type='text' and @name='name' and contains(@placeholder, 'username')]";
	private String inputPassword = "//input[@type='password' and @name='pass' and contains(@placeholder, 'password')]";
	private String btnLoginNow = "//input[@type='submit' and @value='login now']";
	
	HomePage homePage = new HomePage(driver);

	public AdminLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterAdminUserName(String username) {
		logger.info(STARTED + getCurrentMethodName());

		WebElement userNameField = driver.findElement(By.xpath(inputUserName));
		userNameField.clear();
		userNameField.sendKeys(username);

		logger.info("Entered admin username: " + username);
		logger.info(ENDED + getCurrentMethodName());
	}

	public void enterAdminPassword(String password) {
		logger.info(STARTED + getCurrentMethodName());

		WebElement passwordField = driver.findElement(By.xpath(inputPassword));
		passwordField.clear();
		passwordField.sendKeys(password);

		logger.info("Entered admin password: " + password);
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickAdminLoginNow() {
		logger.info(STARTED + getCurrentMethodName());

		driver.findElement(By.xpath(btnLoginNow)).click();

		logger.info("Clicked on 'Admin Login Now' button.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void loginAsAdmin(String username, String password) {
		logger.info(STARTED + getCurrentMethodName());

		homePage.clickAdminPortalLink();
		enterAdminUserName(username);
		enterAdminPassword(password);
		clickAdminLoginNow();
		logger.info("Admin login attempted with username: " + username);
		logger.info(ENDED + getCurrentMethodName());
	}
}
