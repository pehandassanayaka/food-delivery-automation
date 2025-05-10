package tests;

import org.testng.annotations.Test;
import pages.*;

public class AdminAddMealTest extends BaseTest{

    @Test
    public void ContactUserWithValidCredentials() throws InterruptedException {
        driver.get("http://localhost/Food-Ordering-System/home.php");

        // Initialize the Home Page
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AdminDashboardPage adminhomepage = new AdminDashboardPage(driver);
        AdminAddMealPage addproductpage = new AdminAddMealPage(driver);

        adminLoginPage.loginAsAdmin("admin", "admin");
//        adminLoginPage.clickAdminLoginNow();
        adminhomepage.clickadminProductsLink();

        // Perform user Contact
        addproductpage.enterProductName("Fried Rice");
        addproductpage.enterProductPrice("2300");
        addproductpage.selectCategory("main dish");
        addproductpage.uploadPhoto("C:\\Users\\ASUS\\Desktop\\image\\Fried-Rice.png");
        addproductpage.clickAddProductButton();
    }
}
