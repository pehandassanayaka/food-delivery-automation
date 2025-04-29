package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase {
	private WebDriver driver;

	private String btnUser = "//div[@id='user-btn']";
	private String linkLogin = "//a[@href='login.php']";

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickUserButton() {
		logger.info(STARTED + getCurrentMethodName());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnUser)));
		driver.findElement(By.xpath(btnUser)).click();
		logger.info("Clicked on User button.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickLoginLink() {
		logger.info(STARTED + getCurrentMethodName());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkLogin)));
		driver.findElement(By.xpath(linkLogin)).click();
		logger.info("Clicked on Login link.");
		logger.info(ENDED + getCurrentMethodName());
	}
}
