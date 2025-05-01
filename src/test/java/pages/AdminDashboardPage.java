package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDashboardPage extends PageBase {
	private WebDriver driver;

	private String linkHome = "//nav[@class='navbar']/a[text()='home']";
	private String linkProducts = "//nav[@class='navbar']/a[text()='products']";
	private String linkOrders = "//nav[@class='navbar']/a[text()='orders']";
	private String linkAdmins = "//nav[@class='navbar']/a[text()='admins']";
	private String linkUsers = "//nav[@class='navbar']/a[text()='users']";
	private String linkMessages = "//nav[@class='navbar']/a[text()='messages']";

	public AdminDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickHomeLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkHome)));
		homeLink.click();

		logger.info("Clicked on Home link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickProductsLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkProducts)));
		productsLink.click();

		logger.info("Clicked on Products link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickOrdersLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ordersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkOrders)));
		ordersLink.click();

		logger.info("Clicked on Orders link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickAdminsLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkAdmins)));
		adminsLink.click();

		logger.info("Clicked on Admins link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickUsersLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkUsers)));
		usersLink.click();

		logger.info("Clicked on Users link.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickMessagesLink() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement messagesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkMessages)));
		messagesLink.click();

		logger.info("Clicked on Messages link.");
		logger.info(ENDED + getCurrentMethodName());
	}
}
