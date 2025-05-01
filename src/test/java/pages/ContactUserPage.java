package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUserPage extends PageBase{

    private WebDriver driver;


    private String inputName = "//input[@name='name']";
    private String inputNumber = "//input[@name='number']";
    private String inputEmail = "//input[@name='email']";
    private String inputMessage = "//textarea[@name='msg']";
    private String btnSendMessage = "//input[@value='send message']";

    public ContactUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public void enterName(String name) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputName)).sendKeys(name);
        logger.info("Entered name: " + name);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterNumber(String number) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputNumber)).sendKeys(number);
        logger.info("Entered number: " + number);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterEmail(String email) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputEmail)).sendKeys(email);
        logger.info("Entered email: " + email);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterMessage(String message) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputMessage)).sendKeys(message);
        logger.info("Entered message: " + message);
        logger.info(ENDED + getCurrentMethodName());
    }


    public void clickSendMessageButton() {
        logger.info(STARTED + getCurrentMethodName());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='images/loader.gif']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSendMessage)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnSendMessage)));

        try {
            driver.findElement(By.xpath(btnSendMessage)).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            logger.warning("Click intercepted, attempting JavaScript click as fallback.");
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(btnSendMessage)));
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", driver.findElement(By.xpath(btnSendMessage)));
        }

        logger.info("Clicked on Send Message button.");
        logger.info(ENDED + getCurrentMethodName());
    }


    public void userContactWithCredentials(String name, String number, String email, String message) {
        logger.info(STARTED + getCurrentMethodName());

        // ✅ Wait for the 'name' input to appear (registration form loaded)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputName)));

        enterName(name);
        enterNumber(number);
        enterEmail(email);
        enterMessage(message);
        clickSendMessageButton();

        logger.info("Performed register with credentials.");
        logger.info(ENDED + getCurrentMethodName());
    }


}
