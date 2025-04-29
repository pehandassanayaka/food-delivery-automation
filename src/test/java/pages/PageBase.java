package pages;

import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

/**
 * Class to be extended by all Page Objects Model (POM) classes.
 *
 * Contains common methods to be used by every page.
 *
 * @author ejunior
 */
public class PageBase {

	protected WebDriver driver;  // accessible to child classes
	protected final Logger logger = Logger.getLogger(getClass().getName());

	protected static final String STARTED = "STARTED: ";
	protected static final String ENDED = "ENDED: ";

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get the page title
	 *
	 * @return the title of the current page
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/**
	 * Utility method to get the current method name for logging
	 *
	 * @return method name
	 */
	protected String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
}
