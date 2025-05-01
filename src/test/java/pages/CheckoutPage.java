package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PageBase {

	private String grandTotalPrice = "//p[@class='grand-total']/span[@class='price']";
	private String paymentMethodDropdown = "//select[@name='method' and contains(@class, 'box')]";
	private String paymentMethodOptionXpath = "//select[@name='method']//option[@value='%s']";
	private String btnPlaceOrder = "//input[@type='submit' and @value='place order']";
	private String orderSuccessMessage = "//div[@class='message']/span";

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getGrandTotalPrice() {
		logger.info(STARTED + getCurrentMethodName());
		WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(grandTotalPrice)));
		String priceText = priceElement.getText();
		logger.info("Grand total price: " + priceText);
		logger.info(ENDED + getCurrentMethodName());
		return priceText;
	}

	public void selectPaymentMethod(String method) {
		logger.info(STARTED + getCurrentMethodName());

		// Wait for the loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));

		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(paymentMethodDropdown)));
		Select select = new Select(dropdown);
		select.selectByValue(method.toLowerCase());

		logger.info("Selected payment method: " + method);
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickPlaceOrderButton() {
		logger.info(STARTED + getCurrentMethodName());

		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnPlaceOrder)));

		// Scroll the button into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		// Optionally wait a bit if there might be animations
		wait.until(ExpectedConditions.elementToBeClickable(button));

		button.click();

		logger.info("Clicked on Place Order button.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public String getOrderSuccessMessage() {
		logger.info(STARTED + getCurrentMethodName());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderSuccessMessage)));
		String message = messageElement.getText();

		logger.info("Order success message: " + message);
		logger.info(ENDED + getCurrentMethodName());
		return message;
	}
}
