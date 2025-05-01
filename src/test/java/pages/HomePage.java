package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends PageBase {
	private WebDriver driver;

	private String btnUser = "//div[@id='user-btn']";
	private String linkLogin = "//a[@href='login.php']";
	private String linkUserContact = "//a[@href='contact.php']";
	private String linkRegisterNow = "//a[@href='register.php']";
	private String linkOrders = "//nav[@class='navbar']/a[text()='orders']";
	private String menuLink = "//nav[@class='navbar']/a[text()='menu']";
	private String adminPortalLink = "//nav[@class='navbar']/a[text()='admin portal']";

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

	public void clickUserContactLink() {
		logger.info(STARTED + getCurrentMethodName());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for loader image to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector("img[src='images/loader.gif']")));

		// Wait for the register link to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkUserContact)));

		// Optional: Scroll to make sure it's visible
		((org.openqa.selenium.JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(linkUserContact)));

		// Click the element
		driver.findElement(By.xpath(linkUserContact)).click();

		logger.info("Clicked on User Register link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickRegisterLink() {
		logger.info(STARTED + getCurrentMethodName());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(
				By.cssSelector("img[src='images/loader.gif']")));

		// Wait until the register link is clickable
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkRegisterNow)));

		// Scroll into view to avoid interception by overlays
		((org.openqa.selenium.JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(linkRegisterNow)));

		driver.findElement(By.xpath(linkRegisterNow)).click();
		logger.info("Clicked on Register link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickOrdersLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		WebElement ordersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkOrders)));
		ordersLink.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		logger.info("Clicked on 'Orders' link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickMenuLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		WebElement menuElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(menuLink)));
		menuElement.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		logger.info("Clicked on Menu link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickAdminPortalLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));

		WebElement adminPortalElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(adminPortalLink)));
		adminPortalElement.click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));

		logger.info("Clicked on Admin Portal link.");
		logger.info(ENDED + getCurrentMethodName());
	}
}
