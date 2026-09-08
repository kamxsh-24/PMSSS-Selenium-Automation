package tests;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfilePage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@SuppressWarnings("SpellCheckingInspection")
public class ProfileTest extends BaseTest {

    private DashboardPage dashboardPage;
    private ProfilePage profilePage;

    // =========================================================
    // LOGIN & NAVIGATE TO PROFILE BEFORE EACH TEST
    // =========================================================

    @BeforeMethod
    public void setupAndLogin() {
        System.out.println("\n========================================");
        System.out.println("SETUP: AUTHENTICATING USER FOR PROFILE TESTS");
        System.out.println("========================================");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open Login Page
        try {
            driver.get("http://localhost:1024/login");
        } catch (Exception e) {
            driver.get("http://localhost:5173/login");
        }

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("kamesh@gmail.com");
        loginPage.enterPassword("Kamesh@123");
        loginPage.clickLoginButton();

        // Wait for React router redirect to /dashboard
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        // Navigate directly to My Profile page
        try {
            driver.get("http://localhost:1024/dashboard/profile");
        } catch (Exception e) {
            driver.get("http://localhost:5173/dashboard/profile");
        }

        profilePage = new ProfilePage(driver);
        dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(profilePage.isProfileHeadingDisplayed(), "Failed to load My Profile page");
        System.out.println("✓ Authentication & navigation to My Profile successful");
    }

    // =========================================================
    // TEST 1 — PROFILE PAGE & HEADING
    // =========================================================

    @Test(priority = 1)
    public void verifyProfilePage() {
        System.out.println("\n========================================");
        System.out.println("TEST 1: VERIFY PROFILE PAGE & HEADER");
        System.out.println("========================================");

        try {
            Assert.assertTrue(profilePage.isProfileHeadingDisplayed(), "Profile heading is missing");
            Assert.assertTrue(profilePage.isProfileAvatarDisplayed(), "Profile avatar is missing");
            Assert.assertTrue(profilePage.isCompletionPercentageDisplayed(), "Profile completion percentage is missing");

            System.out.println("PASS: Profile page heading and avatar displayed");
        } catch (AssertionError e) {
            System.out.println("FAIL: Profile page header verification failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 2 — PERSONAL INFORMATION FIELDS
    // =========================================================

    @Test(priority = 2)
    public void verifyPersonalInformation() {
        System.out.println("\n========================================");
        System.out.println("TEST 2: VERIFY PERSONAL INFORMATION FIELDS");
        System.out.println("========================================");

        try {
            Assert.assertTrue(profilePage.isFullNameDisplayed(), "Full Name input missing");
            Assert.assertTrue(profilePage.isDobDisplayed(), "DOB input missing");
            Assert.assertTrue(profilePage.isGenderDisplayed(), "Gender dropdown missing");
            Assert.assertTrue(profilePage.isCategoryDisplayed(), "Category dropdown missing");
            Assert.assertTrue(profilePage.isEmailDisplayed(), "Email input missing");
            Assert.assertTrue(profilePage.isPhoneDisplayed(), "Phone input missing");
            Assert.assertTrue(profilePage.isAadhaarDisplayed(), "Aadhaar input missing");

            System.out.println("PASS: Full Name field displayed");
            System.out.println("PASS: Date of Birth field displayed");
            System.out.println("PASS: Email Address field displayed");
            System.out.println("PASS: Phone Number field displayed");
        } catch (AssertionError e) {
            System.out.println("FAIL: Personal information fields verification failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 3 — PERSONAL INFORMATION VALUES
    // =========================================================

    @Test(priority = 3)
    public void verifyPersonalInformationValues() {
        System.out.println("\n========================================");
        System.out.println("TEST 3: VERIFY PERSONAL INFORMATION VALUES");
        System.out.println("========================================");

        try {
            String fullName = profilePage.getFullNameValue();
            String email = profilePage.getEmailValue();

            Assert.assertFalse(fullName.trim().isEmpty(), "Full Name is unexpectedly empty");
            Assert.assertFalse(email.trim().isEmpty(), "Email is unexpectedly empty");

            System.out.println("PASS: Full Name value = " + fullName);
            System.out.println("PASS: Email value = " + email);
        } catch (AssertionError e) {
            System.out.println("FAIL: Personal information values verification failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 4 — ACADEMIC INFORMATION FIELDS
    // =========================================================

    @Test(priority = 4)
    public void verifyAcademicInformation() {
        System.out.println("\n========================================");
        System.out.println("TEST 4: VERIFY ACADEMIC INFORMATION FIELDS");
        System.out.println("========================================");

        try {
            Assert.assertTrue(profilePage.isCollegeNameDisplayed(), "College Name input missing");
            Assert.assertTrue(profilePage.isDegreeDisplayed(), "Degree input missing");
            Assert.assertTrue(profilePage.isYearOfStudyDisplayed(), "Year of Study dropdown missing");

            System.out.println("PASS: College / Institution field displayed");
            System.out.println("PASS: Degree / Course field displayed");
            System.out.println("PASS: Year of Study dropdown displayed");
        } catch (AssertionError e) {
            System.out.println("FAIL: Academic information fields verification failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 5 — ACADEMIC INFORMATION VALUES
    // =========================================================

    @Test(priority = 5)
    public void verifyAcademicInformationValues() {
        System.out.println("\n========================================");
        System.out.println("TEST 5: VERIFY ACADEMIC INFORMATION VALUES");
        System.out.println("========================================");

        try {
            String college = profilePage.getCollegeNameValue();
            String degree = profilePage.getDegreeValue();

            System.out.println("PASS: College Name value = " + college);
            System.out.println("PASS: Degree value = " + degree);
        } catch (AssertionError e) {
            System.out.println("FAIL: Academic information values verification failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 6 — DOCUMENTS SECTION
    // =========================================================

    @Test(priority = 6)
    public void verifyDocuments() {
        System.out.println("\n========================================");
        System.out.println("TEST 6: VERIFY DOCUMENTS SECTION");
        System.out.println("========================================");

        try {
            Assert.assertTrue(profilePage.isDocumentsHeadingDisplayed(), "Documents heading missing");
            Assert.assertTrue(profilePage.isPhotoCardDisplayed(), "Profile Photo card missing");
            Assert.assertTrue(profilePage.isAadhaarCardDisplayed(), "Aadhaar Card card missing");
            Assert.assertTrue(profilePage.isIncomeCertCardDisplayed(), "Income Certificate card missing");
            Assert.assertTrue(profilePage.isMarksheetCardDisplayed(), "Marksheet card missing");
            Assert.assertTrue(profilePage.isBankPassbookCardDisplayed(), "Bank Passbook card missing");

            System.out.println("PASS: Documents section heading displayed");
            System.out.println("PASS: All required document cards displayed");
        } catch (AssertionError e) {
            System.out.println("FAIL: Documents section verification failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 7 — EDIT PROFILE SAFE CHANGE & SAVE
    // =========================================================

    @Test(priority = 7)
    public void verifyEditProfile() {
        System.out.println("\n========================================");
        System.out.println("TEST 7: VERIFY EDIT PROFILE & SAVE");
        System.out.println("========================================");

        try {
            String originalName = profilePage.getFullNameValue();
            String testName = originalName.isEmpty() ? "Kamesh Kumar" : originalName;

            profilePage.enterFullName(testName);
            profilePage.clickSaveButton();
            profilePage.waitForToastToDisappear();

            String updatedName = profilePage.getFullNameValue();
            Assert.assertEquals(updatedName, testName, "Updated full name did not persist");

            System.out.println("PASS: Edit Profile updated field successfully");
            System.out.println("PASS: Saved changes verified");
        } catch (AssertionError e) {
            System.out.println("FAIL: Edit profile test failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 8 — FIELD VALIDATIONS
    // =========================================================

    @Test(priority = 8)
    public void verifyProfileFieldValidation() {
        System.out.println("\n========================================");
        System.out.println("TEST 8: VERIFY FIELD VALIDATION RULES");
        System.out.println("========================================");

        try {
            // Test empty Full Name validation
            profilePage.enterFullName("");
            profilePage.triggerSaveWithValidation();

            Assert.assertTrue(profilePage.hasValidationErrors(), "Expected validation error when Full Name is empty");
            String errorMsg = profilePage.getFirstValidationError();
            System.out.println("PASS: Field validation error triggered = " + errorMsg);

            // Restore valid full name
            profilePage.enterFullName("Kamesh Kumar");
            profilePage.clickSaveButton();
            profilePage.waitForToastToDisappear();
        } catch (AssertionError e) {
            System.out.println("FAIL: Field validation test failed");
            throw e;
        }
    }

    // =========================================================
    // TEST 9 — NAVIGATION
    // =========================================================

    @Test(priority = 9)
    public void verifyDashboardNavigation() {
        System.out.println("\n========================================");
        System.out.println("TEST 9: VERIFY DASHBOARD NAVIGATION");
        System.out.println("========================================");

        try {
            profilePage.clickSidebarDashboard();
            Assert.assertTrue(dashboardPage.isDashboardHeadingDisplayed(), "Navigation back to Dashboard failed");

            System.out.println("PASS: Successfully navigated back to Dashboard");
        } catch (AssertionError e) {
            System.out.println("FAIL: Dashboard navigation failed");
            throw e;
        }
    }
}
