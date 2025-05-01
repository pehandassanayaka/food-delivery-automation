package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends PageBase {
	private String btnProceedToCheckout = "//a[@href='checkout.php' and contains(text(), 'proceed to checkout')]";
	private String cartTotalValue = "//p[contains(text(), 'cart total')]/span";

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickProceedToCheckout() {
		logger.info(STARTED + getCurrentMethodName());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
		WebElement checkoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnProceedToCheckout)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkoutButton);
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		checkoutButton.click();
		logger.info("Clicked on Proceed to Checkout.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public String getCartTotalValue() {
		logger.info(STARTED + getCurrentMethodName());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartTotalValue)));
		String totalText = totalElement.getText();
		logger.info("Cart total value: " + totalText);
		logger.info(ENDED + getCurrentMethodName());
		return totalText;
	}
}
