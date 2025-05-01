package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrdersPage extends PageBase {

	private String nameXPath = "//div[@class='box']/p[contains(text(),'name :')]/span";
	private String emailValue = "//div[@class='box']/p[normalize-space(text())='email :']/span";
	private String numberValue = "//div[@class='box']/p[normalize-space(text())='number :']/span";
	private String addressValue = "//div[@class='box']/p[normalize-space(text())='address :']/span";
	private String paymentMethodValue = "//div[@class='box']/p[normalize-space(text())='payment method :']/span";

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getName() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameXPath)));
		String name = nameElement.getText();

		logger.info("Retrieved name: " + name);
		logger.info(ENDED + getCurrentMethodName());

		return name;
	}

	public String getEmail() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailValue)));
		String email = emailElement.getText();

		logger.info("Retrieved email: " + email);
		logger.info(ENDED + getCurrentMethodName());

		return email;
	}

	public String getNumber() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement numberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberValue)));
		String number = numberElement.getText();

		logger.info("Retrieved number: " + number);
		logger.info(ENDED + getCurrentMethodName());

		return number;
	}

	public String getAddress() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressValue)));
		String address = addressElement.getText();

		logger.info("Retrieved address: " + address);
		logger.info(ENDED + getCurrentMethodName());

		return address;
	}

	public String getPaymentMethod() {
		logger.info(STARTED + getCurrentMethodName());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement paymentMethodElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paymentMethodValue)));
		String paymentMethod = paymentMethodElement.getText();

		logger.info("Retrieved payment method: " + paymentMethod);
		logger.info(ENDED + getCurrentMethodName());

		return paymentMethod;
	}
}
