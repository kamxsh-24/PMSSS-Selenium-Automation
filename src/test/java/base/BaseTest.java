package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.out.println("========== SETUP STARTED ==========");

        driver = new ChromeDriver();

        System.out.println("Chrome started");

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(20));

        String baseUrl = ConfigReader.getBaseUrl();

        System.out.println("Opening URL: " + baseUrl);

        driver.get(baseUrl);

        System.out.println("PMSSS application opened");

        System.out.println("========== SETUP COMPLETED ==========");
    }

    @AfterMethod
    public void tearDown() {

        System.out.println("========== CLOSING BROWSER ==========");

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser closed");
    }
}