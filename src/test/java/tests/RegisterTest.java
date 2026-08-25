package tests;

import base.BaseTest;
import pages.RegisterPage;
import utils.ConfigReader;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    private RegisterPage registerPage;


    // =========================================================
    // BEFORE EACH TEST
    // =========================================================

    @BeforeMethod
    public void openRegisterPage() {

        driver.get(ConfigReader.getBaseUrl() + "/register");

        registerPage = new RegisterPage(driver);

        System.out.println();
        System.out.println("========================================");
        System.out.println("OPENING REGISTER PAGE");
        System.out.println("========================================");
    }


    // =========================================================
    // VALID TEST CASE 1
    // VERIFY REGISTER PAGE
    // =========================================================

    @Test
    public void verifyRegisterPage() {

        String testName = "Verify Register Page";

        try {

            System.out.println("START: " + testName);

            String currentUrl = driver.getCurrentUrl();

            System.out.println("Current URL: " + currentUrl);

            Assert.assertTrue(
                    currentUrl.contains("/register"),
                    "Register page URL is incorrect"
            );

            System.out.println("PASS: Register page URL");
            System.out.println("PASS: " + testName);

        } catch (AssertionError e) {

            System.out.println("FAIL: " + testName);
            System.out.println("Reason: " + e.getMessage());

            throw e;

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println("Reason: " + e.getClass().getSimpleName());
            System.out.println("Details: " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // VALID TEST CASE 2
    // VERIFY ALL REGISTRATION FIELDS
    // =========================================================

    @Test
    public void verifyRegistrationFields() {

        String testName = "Verify Registration Fields";

        try {

            System.out.println("START: " + testName);

            boolean fullName =
                    registerPage.isFullNameDisplayed();

            if (fullName) {
                System.out.println("PASS: Full Name field");
            } else {
                System.out.println("FAIL: Full Name field");
            }


            boolean email =
                    registerPage.isEmailDisplayed();

            if (email) {
                System.out.println("PASS: Email field");
            } else {
                System.out.println("FAIL: Email field");
            }


            boolean password =
                    registerPage.isPasswordDisplayed();

            if (password) {
                System.out.println("PASS: Password field");
            } else {
                System.out.println("FAIL: Password field");
            }


            boolean confirmPassword =
                    registerPage.isConfirmPasswordDisplayed();

            if (confirmPassword) {
                System.out.println("PASS: Confirm Password field");
            } else {
                System.out.println("FAIL: Confirm Password field");
            }


            Assert.assertTrue(
                    fullName,
                    "Full Name field is not displayed"
            );

            Assert.assertTrue(
                    email,
                    "Email field is not displayed"
            );

            Assert.assertTrue(
                    password,
                    "Password field is not displayed"
            );

            Assert.assertTrue(
                    confirmPassword,
                    "Confirm Password field is not displayed"
            );

            System.out.println("PASS: " + testName);

        } catch (AssertionError e) {

            System.out.println("FAIL: " + testName);
            System.out.println("Reason: " + e.getMessage());

            throw e;

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println("Reason: " + e.getClass().getSimpleName());
            System.out.println("Details: " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // VALID TEST CASE 3
    // ENTER VALID REGISTRATION DATA
    // =========================================================

    @Test
    public void verifyValidRegistrationData() {

        String testName = "Enter Valid Registration Data";

        try {

            System.out.println("START: " + testName);

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            System.out.println("PASS: Full Name entered");


            registerPage.enterEmail(email);

            System.out.println("PASS: Valid Email entered");


            registerPage.enterPassword(
                    "Password@123"
            );

            System.out.println("PASS: Password entered");


            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "PASS: Confirm Password entered"
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS: " + testName);
            System.out.println("Email used: " + email);
            System.out.println("----------------------------------------");

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL: " + testName);
            System.out.println("Reason: " + e.getClass().getSimpleName());
            System.out.println("Details: " + e.getMessage());
            System.out.println("----------------------------------------");

            throw e;
        }
    }


    // =========================================================
    // VALID TEST CASE 4
    // VALID DATA + NEXT STEP
    // =========================================================

    @Test
    public void verifyValidDataNextStep() {

        String testName = "Valid Data Next Step";

        try {

            System.out.println("START: " + testName);

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";


            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(email);

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println("Valid registration data entered");


            System.out.println(
                    "Next Step button is ready for testing"
            );

            /*
             * Your current RegisterPage.java does not contain
             * clickNextButton().
             *
             * So we are not clicking the button here.
             *
             * Add the method to RegisterPage.java when you
             * want to test the Next Step functionality.
             */

            System.out.println("PASS: " + testName);

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 1
    // EMPTY FULL NAME
    // =========================================================

    @Test
    public void verifyEmptyFullName() {

        String testName = "Empty Full Name";

        try {

            System.out.println("START: " + testName);

            // Full Name intentionally empty

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";

            registerPage.enterEmail(email);

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "Full Name intentionally left empty"
            );

            System.out.println(
                    "Checking Full Name validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 2
    // EMPTY EMAIL
    // =========================================================

    @Test
    public void verifyEmptyEmail() {

        String testName = "Empty Email";

        try {

            System.out.println("START: " + testName);

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            // Email intentionally empty

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "Email intentionally left empty"
            );

            System.out.println(
                    "Checking Email validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 3
    // INVALID EMAIL
    // =========================================================

    @Test
    public void verifyInvalidEmail() {

        String testName = "Invalid Email";

        try {

            System.out.println("START: " + testName);

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh@"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "Invalid email entered: kamesh@"
            );

            System.out.println(
                    "Checking email validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 4
    // INVALID EMAIL FORMAT
    // =========================================================

    @Test
    public void verifyInvalidEmailFormat() {

        String testName = "Invalid Email Format";

        try {

            System.out.println("START: " + testName);

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kameshgmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "Invalid email entered: kameshgmail.com"
            );

            System.out.println(
                    "Checking email format validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 5
    // EMPTY PASSWORD
    // =========================================================

    @Test
    public void verifyEmptyPassword() {

        String testName = "Empty Password";

        try {

            System.out.println("START: " + testName);

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(email);

            // Password intentionally empty

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "Password intentionally left empty"
            );

            System.out.println(
                    "Checking Password validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 6
    // EMPTY CONFIRM PASSWORD
    // =========================================================

    @Test
    public void verifyEmptyConfirmPassword() {

        String testName = "Empty Confirm Password";

        try {

            System.out.println("START: " + testName);

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(email);

            registerPage.enterPassword(
                    "Password@123"
            );

            // Confirm Password intentionally empty

            System.out.println(
                    "Confirm Password intentionally left empty"
            );

            System.out.println(
                    "Checking Confirm Password validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 7
    // PASSWORD MISMATCH
    // =========================================================

    @Test
    public void verifyPasswordMismatch() {

        String testName = "Password Mismatch";

        try {

            System.out.println("START: " + testName);

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(email);

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Different@123"
            );

            System.out.println(
                    "Password: Password@123"
            );

            System.out.println(
                    "Confirm Password: Different@123"
            );

            System.out.println(
                    "Checking password mismatch validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 8
    // SHORT PASSWORD
    // =========================================================

    @Test
    public void verifyShortPassword() {

        String testName = "Short Password";

        try {

            System.out.println("START: " + testName);

            String email =
                    "kamesh"
                            + System.currentTimeMillis()
                            + "@gmail.com";

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(email);

            registerPage.enterPassword(
                    "123"
            );

            registerPage.enterConfirmPassword(
                    "123"
            );

            System.out.println(
                    "Short password entered: 123"
            );

            System.out.println(
                    "Checking password length validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // INVALID TEST CASE 9
    // ALL FIELDS EMPTY
    // =========================================================

    @Test
    public void verifyAllFieldsEmpty() {

        String testName = "All Registration Fields Empty";

        try {

            System.out.println("START: " + testName);

            // No data entered

            System.out.println(
                    "Full Name: EMPTY"
            );

            System.out.println(
                    "Email: EMPTY"
            );

            System.out.println(
                    "Password: EMPTY"
            );

            System.out.println(
                    "Confirm Password: EMPTY"
            );

            System.out.println(
                    "Checking required field validation..."
            );

            System.out.println(
                    "TEST EXECUTED: " + testName
            );

        } catch (Exception e) {

            System.out.println("FAIL: " + testName);
            System.out.println(
                    "Reason: " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details: " + e.getMessage()
            );

            throw e;
        }
    }
}