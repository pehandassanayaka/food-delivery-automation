package tests;

import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminLoginTest extends BaseTest {

	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		driver.get("http://localhost/Food-Ordering-System/home.php");

		// Initialize the Admin Login Page
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

		// Perform admin login
		adminLoginPage.loginAsAdmin("pehan", "pehan");
	}
}
