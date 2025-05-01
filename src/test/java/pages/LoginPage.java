package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase {
	private String inputEmail = "//input[@type='email' and @name='email']";
	private String inputPassword = "//input[@type='password' and @name='pass']";
	private String btnLoginNow = "//input[@type='submit' and @value='login now']";

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void enterEmail(String email) {
		logger.info(STARTED + getCurrentMethodName());
		driver.findElement(By.xpath(inputEmail)).sendKeys(email);
		logger.info("Entered email: " + email);
		logger.info(ENDED + getCurrentMethodName());
	}

	public void enterPassword(String password) {
		logger.info(STARTED + getCurrentMethodName());
		driver.findElement(By.xpath(inputPassword)).sendKeys(password);
		logger.info("Entered password.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickLoginNowButton() {
		logger.info(STARTED + getCurrentMethodName());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnLoginNow)));
		driver.findElement(By.xpath(btnLoginNow)).click();
		logger.info("Clicked on Login Now button.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void loginWithCredentials(String email, String password) {
		logger.info(STARTED + getCurrentMethodName());
		enterEmail(email);
		enterPassword(password);
		clickLoginNowButton();
		logger.info("Performed login with email and password.");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		logger.info(ENDED + getCurrentMethodName());
	}
}
