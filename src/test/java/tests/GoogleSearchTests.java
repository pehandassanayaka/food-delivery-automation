package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleResultsPage;

public class GoogleSearchTests extends BaseTest {

	@Test
	public void googleSearchTest() {
		driver.get("http://www.google.com");

		// Initialize the Google Home Page
		GoogleHomePage googleHomePage = new GoogleHomePage(driver);

		// Perform search using Enter key
		GoogleResultsPage googleResultsPage = googleHomePage.searchFor("Selenium with java");

		// Validate results
		assertTrue(googleResultsPage.getTitle().equals("Selenium with java - Google Search"));
		assertTrue(googleResultsPage.isResultPresent("Selenium with Java Tutorial"));
	}
}
