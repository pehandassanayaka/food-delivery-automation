package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.PageBase;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

/**
 * Example of Page Object Model (POM) of the Google home page.
 * 
 * All elements of the page that will be used must be instantiated with their respectives xpath. 
 * 
 * @author ejunior
 *
 */
public class GoogleHomePage extends PageBase {
	private WebDriver driver;
	
	private String contactName = "//input[@name='name']";
	private String btnSearch = "//input[@name='btnK']";

	/**
	 * Constructor of the page. Initialize the Page Factory objects. 
	 * 
	 * @param driver
	 */
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Performs a simple google search and return the next page.
	 * 
	 * @param query
	 */
	public GoogleResultsPage searchFor(String query) {
		SeleniumUtils.waitForElement(driver, txtSearch).sendKeys(query);
		SeleniumUtils.waitForElementToBeClickable(driver, btnSearch).click();
		
		return new GoogleResultsPage(driver);
	}


	public void enterContactName(String nameValue) {
		WebElement nameField = driver.findElement(By.xpath(contactName));
		nameField.click();
		nameField.clear(); // Optional: Clear any pre-filled text
		nameField.sendKeys(nameValue);
	}

}
