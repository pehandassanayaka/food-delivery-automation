package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class MenuTest extends BaseTest {

	@Test
	public void testMenuItemsDisplayedCorrectly() {
		MenuPage menuPage = new MenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);

		driver.get("http://localhost/Food-Ordering-System/home.php");

		loginPage.loginWithCredentials("pehan@pehan.com", "pehan");

		homePage.clickMenuLink();

		List<String> menuItems = menuPage.getAllMenuItemNames();

		// Assertions on menu items
		Assert.assertTrue(menuItems.contains("Kottu"), "Kottu is not displayed on the menu.");
		System.out.println("✅ Assertion Passed: Kottu is displayed on the menu.");

		Assert.assertTrue(menuItems.contains("Fried Rice"), "Fried Rice is not displayed on the menu.");
		System.out.println("✅ Assertion Passed: Fried Rice is displayed on the menu.");

		Assert.assertTrue(menuItems.contains("Lava Brownies"), "Lava Brownies is not displayed on the menu.");
		System.out.println("✅ Assertion Passed: Lava Brownies is displayed on the menu.");

		Assert.assertTrue(menuItems.contains("Faluda"), "Faluda is not displayed on the menu.");
		System.out.println("✅ Assertion Passed: Faluda is displayed on the menu.");
	}
}
