package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;

public class DashboardTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void loginBeforeDashboardTest() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);

        dashboardPage = new DashboardPage(driver);

        // Open login page
        driver.get(
                utils.ConfigReader.getBaseUrl() + "/login"
        );

        System.out.println("========================================");
        System.out.println("LOGIN BEFORE DASHBOARD TEST");
        System.out.println("========================================");

        // Login credentials
        loginPage.enterEmail("kamesh@gmail.com");
        loginPage.enterPassword("Kamesh@123");
        loginPage.clickLoginButton();

        // Wait until dashboard is loaded
        wait.until(
                ExpectedConditions.urlContains("/dashboard")
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[normalize-space()='Dashboard']")
                )
        );

        System.out.println("✅ Login successful");
        System.out.println("✅ Dashboard loaded");
    }


    @Test(priority = 1)
    public void verifyDashboardPage() {

        System.out.println("\n========================================");
        System.out.println("TEST 1: DASHBOARD PAGE");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isDashboardHeadingDisplayed(),
                "Dashboard heading is not displayed"
        );

        System.out.println("✅ PASS: Dashboard heading");
    }


    @Test(priority = 2)
    public void verifyWelcomeSection() {

        System.out.println("\n========================================");
        System.out.println("TEST 2: WELCOME SECTION");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isWelcomeSubheadingDisplayed(),
                "Welcome message is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isWelcomeStudentNameDisplayed(),
                "Student name is not displayed"
        );

        System.out.println("✅ PASS: Welcome section");
    }


    @Test(priority = 3)
    public void verifySearchInput() {

        System.out.println("\n========================================");
        System.out.println("TEST 3: SEARCH INPUT");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isSearchInputDisplayed(),
                "Search input is not displayed"
        );

        System.out.println("✅ PASS: Search input");
    }


    @Test(priority = 4)
    public void verifyThemeToggle() {

        System.out.println("\n========================================");
        System.out.println("TEST 4: THEME TOGGLE");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isThemeToggleDisplayed(),
                "Theme toggle is not displayed"
        );

        dashboardPage.clickThemeToggle();

        System.out.println("✅ PASS: Theme toggle clicked");
    }


    @Test(priority = 5)
    public void verifyProfileDropdown() {

        System.out.println("\n========================================");
        System.out.println("TEST 5: PROFILE DROPDOWN");
        System.out.println("========================================");

        dashboardPage.clickProfileMenu();

        Assert.assertTrue(
                dashboardPage.isProfileDropdownDisplayed(),
                "Profile dropdown is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isMyProfileLinkDisplayed(),
                "My Profile link is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isMyApplicationLinkDisplayed(),
                "My Application link is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isTrackStatusLinkDisplayed(),
                "Track Status link is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isLogoutButtonDisplayed(),
                "Logout button is not displayed"
        );

        System.out.println("✅ PASS: Profile dropdown");
    }


    @Test(priority = 6)
    public void verifyNotificationButton() {

        System.out.println("\n========================================");
        System.out.println("TEST 6: NOTIFICATION BUTTON");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isNotificationButtonDisplayed(),
                "Notification button is not displayed"
        );

        dashboardPage.clickNotificationButton();

        System.out.println("✅ PASS: Notification button");
    }


    @Test(priority = 7)
    public void verifyWelcomeBanner() {

        System.out.println("\n========================================");
        System.out.println("TEST 7: WELCOME BANNER");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isWelcomeBannerDisplayed(),
                "Welcome banner is not displayed"
        );

        System.out.println("✅ PASS: Welcome banner");
    }


    @Test(priority = 8)
    public void verifyApplicationSummary() {

        System.out.println("\n========================================");
        System.out.println("TEST 8: APPLICATION SUMMARY");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isApplicationIdDisplayed(),
                "Application ID is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isApplicationStatusDisplayed(),
                "Application status is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isProfileCompletionDisplayed(),
                "Profile completion is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isDocumentsUploadedDisplayed(),
                "Documents uploaded count is not displayed"
        );

        System.out.println("✅ PASS: Application summary");
    }


    @Test(priority = 9)
    public void verifyApplicationProgress() {

        System.out.println("\n========================================");
        System.out.println("TEST 9: APPLICATION PROGRESS");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isApplicationProgressDisplayed(),
                "Application Progress heading is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isRegistrationStepDisplayed(),
                "Registration step is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isProfileStepDisplayed(),
                "Profile step is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isDocumentsStepDisplayed(),
                "Documents step is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isInstituteVerificationStepDisplayed(),
                "Institute Verification step is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isOfficerVerificationStepDisplayed(),
                "Officer Verification step is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isFinalDecisionStepDisplayed(),
                "Final Decision step is not displayed"
        );

        System.out.println("✅ PASS: Application progress");
    }


    @Test(priority = 10)
    public void verifyRecentActivity() {

        System.out.println("\n========================================");
        System.out.println("TEST 10: RECENT ACTIVITY");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isRecentActivityDisplayed(),
                "Recent Activity is not displayed"
        );

        System.out.println("✅ PASS: Recent Activity");
    }


    @Test(priority = 11)
    public void verifyImportantNotifications() {

        System.out.println("\n========================================");
        System.out.println("TEST 11: IMPORTANT NOTIFICATIONS");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isImportantNotificationsDisplayed(),
                "Important Notifications is not displayed"
        );

        System.out.println("✅ PASS: Important Notifications");
    }


    @Test(priority = 12)
    public void verifyMyDocuments() {

        System.out.println("\n========================================");
        System.out.println("TEST 12: MY DOCUMENTS");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isMyDocumentsDisplayed(),
                "My Documents is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isUploadedTabDisplayed(),
                "Uploaded tab is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isPendingTabDisplayed(),
                "Pending tab is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isRejectedTabDisplayed(),
                "Rejected tab is not displayed"
        );

        System.out.println("✅ PASS: My Documents");
    }


    @Test(priority = 13)
    public void verifyQuickActions() {

        System.out.println("\n========================================");
        System.out.println("TEST 13: QUICK ACTIONS");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isCompleteProfileDisplayed(),
                "Complete Profile action is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isUploadDocumentsDisplayed(),
                "Upload Documents action is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isViewApplicationDisplayed(),
                "View Application action is not displayed"
        );

        Assert.assertTrue(
                dashboardPage.isCheckStatusDisplayed(),
                "Check Application Status action is not displayed"
        );

        System.out.println("✅ PASS: Quick Actions");
    }


    @Test(priority = 14)
    public void verifyChatbotWidget() {

        System.out.println("\n========================================");
        System.out.println("TEST 14: AI ASSISTANT");
        System.out.println("========================================");

        Assert.assertTrue(
                dashboardPage.isChatbotDisplayed(),
                "AI Assistant widget is not displayed"
        );

        System.out.println("✅ PASS: AI Assistant");
    }
}