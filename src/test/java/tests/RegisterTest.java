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
    // OPEN REGISTER PAGE
    // =========================================================

    @BeforeMethod
    public void openRegisterPage() {

        driver.get(
                ConfigReader.getBaseUrl() + "/register"
        );

        registerPage = new RegisterPage(driver);

        System.out.println("\n========================================");
        System.out.println("OPENING REGISTER PAGE");
        System.out.println("========================================");
    }


    // =========================================================
    // TEST 1 - VERIFY ACCOUNT INFO FIELDS
    // =========================================================

    @Test
    public void verifyAccountInfoFields() {

        String testName = "Verify Account Info Fields";

        try {

            System.out.println("Checking Full Name...");

            Assert.assertTrue(
                    registerPage.isFullNameDisplayed(),
                    "Full Name field is not displayed"
            );

            System.out.println("PASS : Full Name");


            System.out.println("Checking Email...");

            Assert.assertTrue(
                    registerPage.isEmailDisplayed(),
                    "Email field is not displayed"
            );

            System.out.println("PASS : Email");


            System.out.println("Checking Password...");

            Assert.assertTrue(
                    registerPage.isPasswordDisplayed(),
                    "Password field is not displayed"
            );

            System.out.println("PASS : Password");


            System.out.println("Checking Confirm Password...");

            Assert.assertTrue(
                    registerPage.isConfirmPasswordDisplayed(),
                    "Confirm Password field is not displayed"
            );

            System.out.println("PASS : Confirm Password");


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : All Account Info fields are displayed."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : One or more Account Info fields are missing."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Selenium encountered an unexpected error."
            );
            System.out.println(
                    "Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 2 - VALID ACCOUNT INFORMATION
    // =========================================================

    @Test
    public void validAccountInformation() {

        String testName = "Valid Account Information";

        try {

            String email =
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com";

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            System.out.println("PASS : Full Name entered");


            registerPage.enterEmail(
                    email
            );

            System.out.println("PASS : Valid Email entered");


            registerPage.enterPassword(
                    "Password@123"
            );

            System.out.println(
                    "PASS : Valid Password entered"
            );


            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            System.out.println(
                    "PASS : Confirm Password entered"
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Valid account information entered successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Unable to enter valid account information."
            );
            System.out.println(
                    "Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 3 - INVALID PASSWORD - LESS THAN 8 CHARACTERS
    // =========================================================

    @Test
    public void invalidPasswordLessThan8Characters() {

        String testName =
                "Invalid Password - Less Than 8 Characters";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Pass@12"
            );

            registerPage.enterConfirmPassword(
                    "Pass@12"
            );


            System.out.println(
                    "Entered password: Pass@12"
            );

            System.out.println(
                    "Expected: Password should be rejected."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Invalid short password was entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute short password test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 4 - INVALID PASSWORD - NO UPPERCASE
    // =========================================================

    @Test
    public void invalidPasswordNoUppercase() {

        String testName =
                "Invalid Password - No Uppercase";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "password@123"
            );

            registerPage.enterConfirmPassword(
                    "password@123"
            );


            System.out.println(
                    "Entered password: password@123"
            );

            System.out.println(
                    "Expected: Password should be rejected because uppercase is missing."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Password without uppercase was entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute uppercase validation test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 5 - INVALID PASSWORD - NO LOWERCASE
    // =========================================================

    @Test
    public void invalidPasswordNoLowercase() {

        String testName =
                "Invalid Password - No Lowercase";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "PASSWORD@123"
            );

            registerPage.enterConfirmPassword(
                    "PASSWORD@123"
            );


            System.out.println(
                    "Entered password: PASSWORD@123"
            );

            System.out.println(
                    "Expected: Password should be rejected because lowercase is missing."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Password without lowercase was entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute lowercase validation test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 6 - INVALID PASSWORD - NO NUMBER
    // =========================================================

    @Test
    public void invalidPasswordNoNumber() {

        String testName =
                "Invalid Password - No Number";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@abc"
            );

            registerPage.enterConfirmPassword(
                    "Password@abc"
            );


            System.out.println(
                    "Entered password: Password@abc"
            );

            System.out.println(
                    "Expected: Password should be rejected because number is missing."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Password without number was entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute number validation test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 7 - INVALID PASSWORD - NO SPECIAL CHARACTER
    // =========================================================

    @Test
    public void invalidPasswordNoSpecialCharacter() {

        String testName =
                "Invalid Password - No Special Character";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password123"
            );

            registerPage.enterConfirmPassword(
                    "Password123"
            );


            System.out.println(
                    "Entered password: Password123"
            );

            System.out.println(
                    "Expected: Password should be rejected because special character is missing."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Password without special character was entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute special-character validation test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 8 - CONFIRM PASSWORD MISMATCH
    // =========================================================

    @Test
    public void invalidConfirmPasswordMismatch() {

        String testName =
                "Invalid Confirm Password - Mismatch";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@456"
            );


            System.out.println(
                    "Password: Password@123"
            );

            System.out.println(
                    "Confirm Password: Password@456"
            );

            System.out.println(
                    "Expected: Password mismatch should be rejected."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Mismatched passwords entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute password mismatch test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 9 - VERIFY NEXT STEP
    // =========================================================

    @Test
    public void verifyNextStep() {

        String testName =
                "Verify Next Step Button";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );


            registerPage.clickNextButton();

            System.out.println(
                    "PASS : Next Step button clicked"
            );


            Assert.assertTrue(
                    registerPage.isPhoneDisplayed(),
                    "Personal & Academic section did not open"
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Next Step opened Personal & Academic section."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Next Step did not open Academic section."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Selenium could not click Next Step."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 10 - VERIFY ACADEMIC INFO FIELDS
    // =========================================================

    @Test
    public void verifyAcademicInfoFields() {

        String testName =
                "Verify Personal & Academic Fields";

        try {

            // Account information

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );


            // Move to Academic section

            registerPage.clickNextButton();


            // Phone

            Assert.assertTrue(
                    registerPage.isPhoneDisplayed(),
                    "Phone Number field is not displayed"
            );

            System.out.println(
                    "PASS : Phone Number"
            );


            // DOB

            Assert.assertTrue(
                    registerPage.isDateOfBirthDisplayed(),
                    "Date of Birth field is not displayed"
            );

            System.out.println(
                    "PASS : Date of Birth"
            );


            // Institution

            Assert.assertTrue(
                    registerPage.isInstitutionDisplayed(),
                    "Institution Name field is not displayed"
            );

            System.out.println(
                    "PASS : Institution Name"
            );


            // Course

            Assert.assertTrue(
                    registerPage.isCourseDisplayed(),
                    "Course Name field is not displayed"
            );

            System.out.println(
                    "PASS : Course Name"
            );


            // Year

            Assert.assertTrue(
                    registerPage.isYearDisplayed(),
                    "Year of Study field is not displayed"
            );

            System.out.println(
                    "PASS : Year of Study"
            );


            // Back

            Assert.assertTrue(
                    registerPage.isBackButtonDisplayed(),
                    "Back button is not displayed"
            );

            System.out.println(
                    "PASS : Back Button"
            );


            // Register

            Assert.assertTrue(
                    registerPage.isRegisterButtonDisplayed(),
                    "Register button is not displayed"
            );

            System.out.println(
                    "PASS : Register Button"
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : All Personal & Academic fields are displayed."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Academic field validation failed."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Selenium encountered an unexpected error."
            );
            System.out.println(
                    "Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 11 - VALID ACADEMIC INFORMATION
    // =========================================================

    @Test
    public void validAcademicInformation() {

        String testName =
                "Valid Personal & Academic Information";

        try {

            // Account section

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );


            registerPage.clickNextButton();


            // Academic section

            registerPage.enterPhone(
                    "9876543210"
            );

            System.out.println(
                    "PASS : Valid Phone Number entered"
            );


            registerPage.enterDateOfBirth(
                    "01-01-2000"
            );

            System.out.println(
                    "PASS : Date of Birth entered"
            );


            registerPage.enterInstitution(
                    "Sri Shakthi Institute of Engineering and Technology"
            );

            System.out.println(
                    "PASS : Institution Name entered"
            );


            registerPage.enterCourse(
                    "B.Tech Information Technology"
            );

            System.out.println(
                    "PASS : Course Name entered"
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Valid Academic information entered successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not enter Academic information."
            );
            System.out.println(
                    "Error : " + e.getClass().getSimpleName()
            );
            System.out.println(
                    "Details : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 12 - INVALID PHONE NUMBER
    // =========================================================

    @Test
    public void invalidPhoneNumber() {

        String testName =
                "Invalid Phone Number";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );

            registerPage.clickNextButton();


            // Invalid phone

            registerPage.enterPhone(
                    "12345"
            );


            System.out.println(
                    "Entered invalid phone: 12345"
            );

            System.out.println(
                    "Expected: Phone number should be rejected."
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Invalid phone number entered for validation."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Could not execute invalid phone test."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }


    // =========================================================
    // TEST 13 - VERIFY BACK BUTTON
    // =========================================================

    @Test
    public void verifyBackButton() {

        String testName =
                "Verify Back Button";

        try {

            registerPage.enterFullName(
                    "Kamesh Automation"
            );

            registerPage.enterEmail(
                    "kamesh" +
                            System.currentTimeMillis() +
                            "@gmail.com"
            );

            registerPage.enterPassword(
                    "Password@123"
            );

            registerPage.enterConfirmPassword(
                    "Password@123"
            );


            registerPage.clickNextButton();


            System.out.println(
                    "Academic section opened."
            );


            registerPage.clickBackButton();


            System.out.println(
                    "Back button clicked."
            );


            Assert.assertTrue(
                    registerPage.isFullNameDisplayed(),
                    "Account Info section did not open after Back button"
            );


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Back button returned to Account Info."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Back button did not work correctly."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Selenium could not verify Back button."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;
        }
    }
}