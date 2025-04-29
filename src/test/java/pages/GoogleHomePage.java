package pages;

import org.openqa.selenium.Keys;
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
	
	private String txtSearch = "//textarea[@name='q']";
	private String btnSearch = "//div[@class='FPdoLc lJ9FBc']//center//input[@name='btnK']";

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
		WebElement searchBox = SeleniumUtils.waitForElement(driver, txtSearch);
		searchBox.sendKeys(query);
		searchBox.sendKeys(Keys.ENTER); // Press Enter instead of clicking the button
		return new GoogleResultsPage(driver);
	}
}
