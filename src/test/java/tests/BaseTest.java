package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    // Declare WebDriver instance
    protected WebDriver driver;

    // This method will run before each test class in the suite
    @BeforeTest
    public void setUp() {
        // Initialize WebDriver instance (ChromeDriver in this case)
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the window
    }

    // This method will run after each test class in the suite
    @AfterTest
    public void tearDown() {
        // Quit the WebDriver instance after the tests are finished
        if (driver != null) {
            driver.quit();
        }
    }
}
