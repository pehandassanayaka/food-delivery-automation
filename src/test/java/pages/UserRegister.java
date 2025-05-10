package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegister extends PageBase{
    private WebDriver driver;


    private String inputName = "//input[@name='name']";
    private String inputEmail = "//input[@name='email']";
    private String inputNumber = "//input[@name='number']";
    private String inputPassword = "//input[@name='pass']";
    private String inputConfirmPassword = "//input[@name='cpass']";
    private String btnRegister = "//input[@value='register now']";

    public UserRegister(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public void enterName(String name) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputName)).sendKeys(name);
        logger.info("Entered name: " + name);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterEmail(String email) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputEmail)).sendKeys(email);
        logger.info("Entered email: " + email);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterNumber(String number) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputNumber)).sendKeys(number);
        logger.info("Entered number: " + number);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterPassword(String password) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputPassword)).sendKeys(password);
        logger.info("Entered password.");
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterConfirmPassword(String confirmpassword) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputConfirmPassword)).sendKeys(confirmpassword);
        logger.info("Entered Confirm password.");
        logger.info(ENDED + getCurrentMethodName());
    }

    public void clickRegisterButton() {
        logger.info(STARTED + getCurrentMethodName());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnRegister)));
        driver.findElement(By.xpath(btnRegister)).click();
        logger.info("Clicked on Login Now button.");
        logger.info(ENDED + getCurrentMethodName());
    }

    public void userRegisterWithCredentials(String name, String email, String number, String password , String confirmpassword) {
        logger.info(STARTED + getCurrentMethodName());

        // ✅ Wait for the 'name' input to appear (registration form loaded)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputName)));

        enterName(name);
        enterNumber(number);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmpassword);
        clickRegisterButton();

        logger.info("Performed register with credentials.");
        logger.info(ENDED + getCurrentMethodName());
    }


}
