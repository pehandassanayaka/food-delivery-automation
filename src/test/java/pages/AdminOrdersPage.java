package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AdminOrdersPage extends PageBase {
	private WebDriver driver;
	private WebDriverWait wait;

	private String userId = "//div[@class='box']/p[contains(text(), 'user id')]/span";
	private String placedOn = "//div[@class='box']/p[contains(text(), 'placed on')]/span";
	private String name = "//div[@class='box']/p[contains(text(), 'name')]/span";
	private String email = "//div[@class='box']/p[contains(text(), 'email')]/span";
	private String number = "//div[@class='box']/p[contains(text(), 'number')]/span";
	private String address = "//div[@class='box']/p[contains(text(), 'address')]/span";
	private String totalProducts = "//div[@class='box']/p[contains(text(), 'total products')]/span";
	private String totalPrice = "//div[@class='box']/p[contains(text(), 'total price')]/span";
	private String paymentMethod = "//div[@class='box']/p[contains(text(), 'payment method')]/span";
	private String orderStatusDropdown = "//select[@name='payment_status' and contains(@class, 'drop-down')]";
	private String updateButton = "//input[@type='submit' and @value='update' and @name='update_payment']";
	private String deleteButton = "//a[contains(@href, 'placed_orders.php?delete=') and contains(@class, 'delete-btn')]";
	private String selecteOrderStatus = "//select[@name='payment_status']/option[@selected and @disabled]";

	public AdminOrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String getUserId() {
		WebElement element = waitForElement(By.xpath(userId));
		return element.getText();
	}

	public String getPlacedOn() {
		WebElement element = waitForElement(By.xpath(placedOn));
		return element.getText();
	}

	public String getName() {
		WebElement element = waitForElement(By.xpath(name));
		return element.getText();
	}

	public String getEmail() {
		WebElement element = waitForElement(By.xpath(email));
		return element.getText();
	}

	public String getNumber() {
		WebElement element = waitForElement(By.xpath(number));
		return element.getText();
	}

	public String getAddress() {
		WebElement element = waitForElement(By.xpath(address));
		return element.getText();
	}

	public String getTotalProducts() {
		WebElement element = waitForElement(By.xpath(totalProducts));
		return element.getText();
	}

	public String getTotalPrice() {
		WebElement element = waitForElement(By.xpath(totalPrice));
		return element.getText();
	}

	public String getPaymentMethod() {
		WebElement element = waitForElement(By.xpath(paymentMethod));
		return element.getText();
	}

	public void selectOrderStatus(String status) {
		logger.info(STARTED + getCurrentMethodName());
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(orderStatusDropdown)));
		Select select = new Select(dropdown);
		select.selectByValue(status.toLowerCase());

		logger.info("Selected order status: " + status);
		logger.info(ENDED + getCurrentMethodName());
	}

	public String getSelectedOrderStatus(){
		logger.info(STARTED + getCurrentMethodName());

		WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selecteOrderStatus)));
		String selectedStatus = selectedOption.getText().trim();

		logger.info("Selected order status: " + selectedStatus);
		logger.info(ENDED + getCurrentMethodName());
		return selectedStatus;
	}

	public void clickUpdateButton() {
		logger.info(STARTED + getCurrentMethodName());
		WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(updateButton)));
		updateBtn.click();

		logger.info("Clicked on Update button.");
		logger.info(ENDED + getCurrentMethodName());
	}

	public void clickDeleteButton() {
		logger.info(STARTED + getCurrentMethodName());

		WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteButton)));
		deleteBtn.click();

		logger.info("Clicked on Delete button.");
		logger.info(ENDED + getCurrentMethodName());
	}

	// Wait wrapper to reuse
	private WebElement waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}



}
