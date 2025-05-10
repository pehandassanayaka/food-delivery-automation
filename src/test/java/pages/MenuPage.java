package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MenuPage extends PageBase {
	private String messageBox = "//div[@class='message']";
	private String cartIcon = "//a[@href='cart.php']/i[contains(@class, 'fa-shopping-cart')]";
	private String closeMessageIcon = "//div[@class='message']/i[contains(@class, 'fa-times')]";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public MenuPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickAddToCartButton(String itemName) {
		logger.info(STARTED + getCurrentMethodName());

		String formXpath = "//form[input[@name='name' and @value='" + itemName + "']]";
		String buttonXpath = formXpath + "//button[@type='submit']";

		WebElement formElement = driver.findElement(By.xpath(formXpath));
		WebElement addToCartButton = driver.findElement(By.xpath(buttonXpath));

		// Hover to make the button visible
		Actions actions = new Actions(driver);
		actions.moveToElement(formElement).perform();

		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

		addToCartButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		closeMessage();
		logger.info("Clicked add to cart button for item: " + itemName);
		logger.info(ENDED + getCurrentMethodName());
	}

	public String getMessageText() {
		logger.info(STARTED + getCurrentMethodName());
		WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messageBox)));
		String messageText = messageElement.getText();
		logger.info("Retrieved message text: " + messageText);
		logger.info(ENDED + getCurrentMethodName());
		return messageText;
	}

	public void clickCartIcon() {
		logger.info(STARTED + getCurrentMethodName());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cartIcon)));
		cartElement.click();
		logger.info("Clicked on Cart icon.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void closeMessage() {
		logger.info(STARTED + getCurrentMethodName());

		// Wait for loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));

		// Then wait until the close icon is clickable
		WebElement closeIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(closeMessageIcon)));
		closeIcon.click();

		logger.info("Closed the message popup.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public List<String> getAllMenuItemNames() {
		logger.info(STARTED + getCurrentMethodName());

		List<WebElement> nameElements = driver.findElements(By.cssSelector("form .name"));
		List<String> menuItemNames = new ArrayList<>();

		for (WebElement nameElement : nameElements) {
			String name = nameElement.getText().trim();
			menuItemNames.add(name);
			logger.info("Found menu item: " + name);
		}

		logger.info(ENDED + getCurrentMethodName());
		return menuItemNames;
	}
}
