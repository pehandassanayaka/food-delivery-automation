package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import pages.*;

public class OrderTest extends BaseTest {

	@Test
	public void placeOrderWithValidItems() throws InterruptedException {
		driver.get("http://localhost/Food-Ordering-System/home.php");

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		MenuPage menuPage = new MenuPage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		OrdersPage ordersPage = new OrdersPage(driver);

		loginPage.loginWithCredentials("pehan@pehan.com", "pehan");

		homePage.clickMenuLink();

		menuPage.clickAddToCartButton("Kottu");
		menuPage.clickAddToCartButton("Fried Rice");
		menuPage.clickAddToCartButton("Lava Brownies");
		menuPage.clickAddToCartButton("Faluda");

		menuPage.clickCartIcon();

		String cartTotalValue = cartPage.getCartTotalValue();
		assertEquals(cartTotalValue, "$4410", "Cart total value mismatch!");
		System.out.println("✔ Cart total value assertion passed");

		cartPage.clickProceedToCheckout();

		String grandTotalPrice = checkoutPage.getGrandTotalPrice();
		assertEquals(grandTotalPrice, "$4410", "Grand total price mismatch!");
		System.out.println("✔ Grand total price assertion passed");

		checkoutPage.selectPaymentMethod("cash on delivery");
		checkoutPage.clickPlaceOrderButton();

		String orderSuccessMessage = checkoutPage.getOrderSuccessMessage();
		assertEquals(orderSuccessMessage, "order placed successfully!", "Order success message mismatch!");
		System.out.println("✔ Order success message assertion passed");

		homePage.clickOrdersLink();

		String name = ordersPage.getName();
		String email = ordersPage.getEmail();
		String number = ordersPage.getNumber();
		String address = ordersPage.getAddress();
		String paymentMethod = ordersPage.getPaymentMethod();

		assertEquals(name, "pehan", "Name mismatch!");
		System.out.println("✔ Name assertion passed");

		assertEquals(email, "pehan@pehan.com", "Email mismatch!");
		System.out.println("✔ Email assertion passed");

		assertEquals(number, "415646165", "Number mismatch!");
		System.out.println("✔ Number assertion passed");

		assertEquals(address, "gfdgfdg, fgdg, gfdgfdg, fdgfdg, fdgfdg, fdgfdg, fdgfd - 546416", "Address mismatch!");
		System.out.println("✔ Address assertion passed");

		assertEquals(paymentMethod, "cash on delivery", "Payment method mismatch!");
		System.out.println("✔ Payment method assertion passed");
	}
}
