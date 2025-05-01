package tests;

import org.testng.annotations.Test;
import pages.ContactUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegister;

public class ContactUserTest extends BaseTest{

    @Test
    public void ContactUserWithValidCredentials() throws InterruptedException {
        driver.get("http://localhost/Food-Ordering-System/home.php");

        // Initialize the Home Page
        HomePage homePage = new HomePage(driver);

        ContactUserPage userContactPage = new ContactUserPage(driver);

        homePage.clickUserButton();

        homePage.clickUserContactLink();

        // Perform user Contact
        userContactPage.enterName("Nethmini");
        userContactPage.enterNumber("3");
        userContactPage.enterEmail("nethu@nethu.com");
        userContactPage.enterMessage("user register1");
        userContactPage.clickSendMessageButton();
    }
}
