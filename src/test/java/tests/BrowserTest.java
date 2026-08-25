package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        System.out.println("========================================");
        System.out.println("TEST: Verify PMSSS Home Page");
        System.out.println("========================================");

        try {

            // Get current URL
            String currentUrl = driver.getCurrentUrl();

            System.out.println("Current URL: " + currentUrl);

            // Get page title
            String title = driver.getTitle();

            System.out.println("Page Title: " + title);

            // Verify URL
            Assert.assertTrue(
                    currentUrl.contains("localhost:1024"),
                    "PMSSS Home Page URL is incorrect"
            );

            System.out.println("✅ PASS: Home Page URL");

            // Verify title
            Assert.assertNotNull(
                    title,
                    "Page title is null"
            );

            System.out.println("✅ PASS: Page Title");

            // Verify title contains PMSS
            Assert.assertTrue(
                    title.contains("PMSS"),
                    "Page title does not contain PMSS"
            );

            System.out.println("✅ PASS: PMSSS Page Title");

            System.out.println("----------------------------------------");
            System.out.println("✅ TEST PASSED");
            System.out.println("Reason: PMSSS home page opened successfully.");
            System.out.println("----------------------------------------");

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ TEST FAILED");
            System.out.println("Reason: Assertion failed.");
            System.out.println("Error: " + e.getMessage());
            System.out.println("----------------------------------------");

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ TEST FAILED");
            System.out.println("Reason: Unexpected Selenium error.");
            System.out.println("Error Type: " + e.getClass().getSimpleName());
            System.out.println("Details: " + e.getMessage());
            System.out.println("----------------------------------------");

            throw e;
        }
    }
}