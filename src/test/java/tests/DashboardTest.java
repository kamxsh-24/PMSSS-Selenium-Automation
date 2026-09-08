package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    // =========================================================
    // LOGIN CREDENTIALS
    // =========================================================

    private final String VALID_EMAIL = "YOUR_REGISTERED_EMAIL";
    private final String VALID_PASSWORD = "Password@123";


    // =========================================================
    // BEFORE EACH TEST
    // =========================================================

    @BeforeMethod
    public void loginBeforeTest() {

        System.out.println("\n========================================");
        System.out.println("STARTING DASHBOARD TEST");
        System.out.println("========================================");

        // Open Login page
        driver.get(
                utils.ConfigReader.getBaseUrl() + "/login"
        );

        System.out.println("Login page opened");

        loginPage = new LoginPage(driver);

        // Login
        loginPage.enterEmail(VALID_EMAIL);
        System.out.println("✓ Email entered");

        loginPage.enterPassword(VALID_PASSWORD);
        System.out.println("✓ Password entered");

        loginPage.clickSignIn();
        System.out.println("✓ Sign In button clicked");

        // Create Dashboard Page object
        dashboardPage = new DashboardPage(driver);

        System.out.println("Current URL: " + driver.getCurrentUrl());
    }


    // =========================================================
    // TEST 1 - VERIFY DASHBOARD PAGE
    // =========================================================

    @Test
    public void verifyDashboardPage() {

        String testName = "Verify Dashboard Page";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isDashboardDisplayed();

            Assert.assertTrue(
                    result,
                    "Dashboard page is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : Dashboard page opened successfully."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Dashboard page was not displayed."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Unexpected Selenium error."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 2 - VERIFY DASHBOARD HEADING
    // =========================================================

    @Test
    public void verifyDashboardHeading() {

        String testName = "Verify Dashboard Heading";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isDashboardHeadingDisplayed();

            Assert.assertTrue(
                    result,
                    "Dashboard heading is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : Dashboard heading is displayed."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Dashboard heading is missing."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Selenium error while checking heading."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 3 - VERIFY WELCOME MESSAGE
    // =========================================================

    @Test
    public void verifyWelcomeMessage() {

        String testName = "Verify Welcome Message";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isWelcomeMessageDisplayed();

            Assert.assertTrue(
                    result,
                    "Welcome message is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : Welcome message is displayed."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Welcome message is missing."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Selenium error while checking welcome message."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 4 - VERIFY APPLICATION PROGRESS
    // =========================================================

    @Test
    public void verifyApplicationProgress() {

        String testName = "Verify Application Progress";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isApplicationProgressDisplayed();

            Assert.assertTrue(
                    result,
                    "Application Progress section is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : Application Progress section is displayed."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Application Progress section is missing."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Selenium error while checking application progress."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 5 - VERIFY NOTIFICATIONS
    // =========================================================

    @Test
    public void verifyNotifications() {

        String testName = "Verify Notifications";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isNotificationsDisplayed();

            Assert.assertTrue(
                    result,
                    "Notifications section is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : Notifications section is displayed."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Notifications section is missing."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Selenium error while checking notifications."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 6 - VERIFY MY DOCUMENTS
    // =========================================================

    @Test
    public void verifyMyDocuments() {

        String testName = "Verify My Documents";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isMyDocumentsDisplayed();

            Assert.assertTrue(
                    result,
                    "My Documents section is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : My Documents section is displayed."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : My Documents section is missing."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Selenium error while checking documents."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 7 - VERIFY QUICK ACTIONS
    // =========================================================

    @Test
    public void verifyQuickActions() {

        String testName = "Verify Quick Actions";

        try {

            System.out.println("\n----------------------------------------");
            System.out.println("TEST: " + testName);

            boolean result =
                    dashboardPage.isQuickActionsDisplayed();

            Assert.assertTrue(
                    result,
                    "Quick Actions section is not displayed"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "   Reason : Quick Actions section is displayed."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Quick Actions section is missing."
            );
            System.out.println(
                    "   Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "   Reason : Selenium error while checking Quick Actions."
            );
            System.out.println(
                    "   Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "   Details : " + e.getMessage()
            );

            throw e;
        }
    }
}