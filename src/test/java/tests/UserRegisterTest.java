package tests;

import org.testng.annotations.Test;
import pages.*;

public class UserRegisterTest extends BaseTest {

    @Test
    public void RegisterUserWithValidCredentials() throws InterruptedException {
        driver.get("http://localhost/Food-Ordering-System/home.php");

        // Initialize the Home Page
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);


        UserRegister userRegisterPage = new UserRegister(driver);

        homePage.clickUserButton();
        homePage.clickLoginLink();
        homePage.clickRegisterLink();

        // Perform user Contact
        userRegisterPage.enterName("UserReg1");
        userRegisterPage.enterEmail("user1@user1.com");
        userRegisterPage.enterNumber("3");
        userRegisterPage.enterPassword("UserR1");
        userRegisterPage.enterConfirmPassword("UserR1");

        userRegisterPage.clickRegisterButton();
    }
}
