package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import pages.*;

public class AdminOrderTest extends BaseTest {

	@Test
	public void verifyAdminOrderDetails() {
		driver.get("http://localhost/Food-Ordering-System/home.php");

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		AdminOrdersPage adminOrdersPage = new AdminOrdersPage(driver);

		adminLoginPage.loginAsAdmin("pehan", "pehan");
		adminDashboardPage.clickOrdersLink();

		assertEquals(adminOrdersPage.getUserId(), "1", "User ID mismatch!");
		System.out.println("✔ User ID assertion passed");

		assertEquals(adminOrdersPage.getPlacedOn(), "2025-04-29", "Placed on mismatch!");
		System.out.println("✔ Placed on assertion passed");

		assertEquals(adminOrdersPage.getName(), "pehan", "Name mismatch!");
		System.out.println("✔ Name assertion passed");

		assertEquals(adminOrdersPage.getEmail(), "pehan@pehan.com", "Email mismatch!");
		System.out.println("✔ Email assertion passed");

		assertEquals(adminOrdersPage.getNumber(), "415646165", "Number mismatch!");
		System.out.println("✔ Number assertion passed");

		assertEquals(adminOrdersPage.getAddress(), "gfdgfdg, fgdg, gfdgfdg, fdgfdg, fdgfdg, fdgfdg, fdgfd - 546416", "Address mismatch!");
		System.out.println("✔ Address assertion passed");

		assertEquals(adminOrdersPage.getTotalProducts(), "Kottu (1000 x 1) -", "Total products mismatch!");
		System.out.println("✔ Total products assertion passed");

		assertEquals(adminOrdersPage.getTotalPrice(), "$1000/-", "Total price mismatch!");
		System.out.println("✔ Total price assertion passed");

		assertEquals(adminOrdersPage.getPaymentMethod(), "cash on delivery", "Payment method mismatch!");
		System.out.println("✔ Payment method assertion passed");

		assertEquals(adminOrdersPage.getSelectedOrderStatus(), "pending", "Order status mismatch!");
		System.out.println("✔ Order status assertion passed");
	}

	@Test
	public void verifyOrderStatusUpdate() throws InterruptedException {
		driver.get("http://localhost/Food-Ordering-System/home.php");

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		AdminOrdersPage adminOrdersPage = new AdminOrdersPage(driver);

		adminLoginPage.loginAsAdmin("pehan", "pehan");
		adminDashboardPage.clickOrdersLink();
		adminOrdersPage.selectOrderStatus("completed");
		adminOrdersPage.clickUpdateButton();

		assertEquals(adminOrdersPage.getUserId(), "1", "User ID mismatch!");
		System.out.println("✔ User ID assertion passed");

		assertEquals(adminOrdersPage.getPlacedOn(), "2025-04-29", "Placed on mismatch!");
		System.out.println("✔ Placed on assertion passed");

		assertEquals(adminOrdersPage.getName(), "pehan", "Name mismatch!");
		System.out.println("✔ Name assertion passed");

		assertEquals(adminOrdersPage.getEmail(), "pehan@pehan.com", "Email mismatch!");
		System.out.println("✔ Email assertion passed");

		assertEquals(adminOrdersPage.getNumber(), "415646165", "Number mismatch!");
		System.out.println("✔ Number assertion passed");

		assertEquals(adminOrdersPage.getAddress(), "gfdgfdg, fgdg, gfdgfdg, fdgfdg, fdgfdg, fdgfdg, fdgfd - 546416", "Address mismatch!");
		System.out.println("✔ Address assertion passed");

		assertEquals(adminOrdersPage.getTotalProducts(), "Kottu (1000 x 1) -", "Total products mismatch!");
		System.out.println("✔ Total products assertion passed");

		assertEquals(adminOrdersPage.getTotalPrice(), "$1000/-", "Total price mismatch!");
		System.out.println("✔ Total price assertion passed");

		assertEquals(adminOrdersPage.getPaymentMethod(), "cash on delivery", "Payment method mismatch!");
		System.out.println("✔ Payment method assertion passed");

		assertEquals(adminOrdersPage.getSelectedOrderStatus(), "completed", "Order status mismatch!");
		System.out.println("✔ Order status assertion passed");

		System.out.println("✔ Order status updated to 'completed' successfully");
	}
}
