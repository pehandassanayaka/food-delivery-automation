package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class AdminAddMealPage extends PageBase {
    private WebDriver driver;

    private String inputProductName = "//input[@name='name']";
    private String inputProductPrice = "//input[@name='price']";
    private String dropdownCategory = "//select[@name='category']";
    private String inputPhotoUpload = "//input[@type='image']";
    private String btnAddProduct = "//button[text()='add_product']";

    public AdminAddMealPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void enterProductName(String name) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputProductName)).sendKeys(name);
        logger.info("Entered product name: " + name);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void enterProductPrice(String price) {
        logger.info(STARTED + getCurrentMethodName());
        driver.findElement(By.xpath(inputProductPrice)).sendKeys(price);
        logger.info("Entered product price: " + price);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void selectCategory(String categoryName) {
        logger.info(STARTED + getCurrentMethodName());
        Select categoryDropdown = new Select(driver.findElement(By.xpath(dropdownCategory)));
        categoryDropdown.selectByVisibleText(categoryName);
        logger.info("Selected category: " + categoryName);
        logger.info(ENDED + getCurrentMethodName());
    }

    public void uploadPhoto(String photoPath) {
        logger.info(STARTED + getCurrentMethodName());
        File file = new File(photoPath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found at path: " + photoPath);
        }
        driver.findElement(By.xpath(inputPhotoUpload)).sendKeys(file.getAbsolutePath());
        logger.info("Uploaded photo from path: " + photoPath);
        logger.info(ENDED + getCurrentMethodName());
    }
    
    public void clickAddProductButton() {
        logger.info(STARTED + getCurrentMethodName());

        Duration Duration = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAddProduct)));

        try {
            driver.findElement(By.xpath(btnAddProduct)).click();
        } catch (ElementClickInterceptedException e) {
            logger.warning("Click intercepted. Using JavaScript click as fallback.");
            WebElement element = driver.findElement(By.xpath(btnAddProduct));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }

        logger.info("Clicked Add Product button.");
        logger.info(ENDED + getCurrentMethodName());
    }

    public void addMeal(String name, String price, String category, String photoPath) {
        logger.info(STARTED + getCurrentMethodName());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputProductName)));

        enterProductName(name);
        enterProductPrice(price);
        selectCategory(category);
        uploadPhoto(photoPath);
        clickAddProductButton();

        logger.info("Meal added successfully.");
        logger.info(ENDED + getCurrentMethodName());
    }
    
}
