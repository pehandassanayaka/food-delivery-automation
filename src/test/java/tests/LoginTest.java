package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		driver.get("http://localhost/Food-Ordering-System/home.php");

		// Initialize the Home Page
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);

		homePage.clickUserButton();

		homePage.clickLoginLink();

		// Perform login
		loginPage.enterEmail("pehan@pehan.com");

		loginPage.enterPassword("pehan");

		loginPage.clickLoginNowButton();
	}
}
