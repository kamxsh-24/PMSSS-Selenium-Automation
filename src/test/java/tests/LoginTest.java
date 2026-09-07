package tests;

import base.BaseTest;
import utils.ConfigReader;
import pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    // =========================================================
    // OPEN LOGIN PAGE BEFORE EVERY TEST
    // =========================================================

    @BeforeMethod
    public void openLoginPage() {

        driver.get(
                ConfigReader.getBaseUrl() + "/login"
        );

        loginPage = new LoginPage(driver);

        System.out.println();
        System.out.println("========================================");
        System.out.println("Opening Login Page");
        System.out.println("URL : " + driver.getCurrentUrl());
        System.out.println("========================================");
    }


    // =========================================================
    // TEST 1 - VERIFY LOGIN PAGE
    // =========================================================

    @Test
    public void verifyLoginPage() {

        String testName = "Verify Login Page";

        try {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("/login"),
                    "Login URL is incorrect"
            );

            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Login page opened successfully."
            );

        } catch (AssertionError e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Login page URL is incorrect."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Unable to open login page."
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
    // TEST 2 - VERIFY LOGIN FIELDS
    // =========================================================

    @Test
    public void verifyLoginFields() {

        String testName = "Verify Login Fields";

        try {

            boolean email =
                    loginPage.isEmailDisplayed();

            if (email) {
                System.out.println(
                        "✅ PASS : Email field displayed"
                );
            } else {
                System.out.println(
                        "❌ FAIL : Email field not displayed"
                );
            }


            boolean password =
                    loginPage.isPasswordDisplayed();

            if (password) {
                System.out.println(
                        "✅ PASS : Password field displayed"
                );
            } else {
                System.out.println(
                        "❌ FAIL : Password field not displayed"
                );
            }


            Assert.assertTrue(
                    email,
                    "Email field is not displayed"
            );

            Assert.assertTrue(
                    password,
                    "Password field is not displayed"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Email and Password fields are displayed."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Login field validation failed."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
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
    // TEST 3 - VALID LOGIN
    // =========================================================

    @Test
    public void validLogin() {

        String testName = "Valid Login";

        try {

            System.out.println("Entering valid email...");

            loginPage.enterEmail(
                    "YOUR_VALID_EMAIL@gmail.com"
            );

            System.out.println(
                    "   ✓ Valid email entered"
            );


            System.out.println("Entering valid password...");

            loginPage.enterPassword(
                    "YOUR_VALID_PASSWORD"
            );

            System.out.println(
                    "   ✓ Valid password entered"
            );


            System.out.println("Clicking Sign In...");

            loginPage.clickLoginButton();

            System.out.println(
                    "   ✓ Sign In button clicked"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Valid login credentials were submitted successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Valid login could not be completed."
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
    // TEST 4 - INVALID EMAIL
    // =========================================================

    @Test
    public void invalidEmail() {

        String testName = "Invalid Email";

        try {

            loginPage.enterEmail(
                    "invalid-email"
            );

            System.out.println(
                    "   ✓ Invalid email entered"
            );


            loginPage.enterPassword(
                    "Password@123"
            );

            System.out.println(
                    "   ✓ Password entered"
            );


            loginPage.clickLoginButton();

            System.out.println(
                    "   ✓ Sign In button clicked"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Invalid email test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Invalid email test could not be executed."
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
    // TEST 5 - INVALID PASSWORD
    // =========================================================

    @Test
    public void invalidPassword() {

        String testName = "Invalid Password";

        try {

            loginPage.enterEmail(
                    "YOUR_VALID_EMAIL@gmail.com"
            );

            System.out.println(
                    "   ✓ Valid email entered"
            );


            loginPage.enterPassword(
                    "WrongPassword@999"
            );

            System.out.println(
                    "   ✓ Invalid password entered"
            );


            loginPage.clickLoginButton();

            System.out.println(
                    "   ✓ Sign In button clicked"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Invalid password test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Invalid password test could not be executed."
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
    // TEST 6 - EMPTY EMAIL
    // =========================================================

    @Test
    public void emptyEmail() {

        String testName = "Empty Email";

        try {

            loginPage.enterEmail("");

            System.out.println(
                    "   ✓ Email left empty"
            );


            loginPage.enterPassword(
                    "Password@123"
            );

            System.out.println(
                    "   ✓ Password entered"
            );


            loginPage.clickLoginButton();

            System.out.println(
                    "   ✓ Sign In button clicked"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Empty email test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Empty email test could not be executed."
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
    // TEST 7 - EMPTY PASSWORD
    // =========================================================

    @Test
    public void emptyPassword() {

        String testName = "Empty Password";

        try {

            loginPage.enterEmail(
                    "YOUR_VALID_EMAIL@gmail.com"
            );

            System.out.println(
                    "   ✓ Email entered"
            );


            loginPage.enterPassword("");

            System.out.println(
                    "   ✓ Password left empty"
            );


            loginPage.clickLoginButton();

            System.out.println(
                    "   ✓ Sign In button clicked"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Empty password test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Empty password test could not be executed."
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
    // TEST 8 - BOTH EMAIL AND PASSWORD EMPTY
    // =========================================================

    @Test
    public void bothFieldsEmpty() {

        String testName = "Both Fields Empty";

        try {

            loginPage.enterEmail("");

            System.out.println(
                    "   ✓ Email left empty"
            );


            loginPage.enterPassword("");

            System.out.println(
                    "   ✓ Password left empty"
            );


            loginPage.clickLoginButton();

            System.out.println(
                    "   ✓ Sign In button clicked"
            );


            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Empty email and password test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Empty fields test could not be executed."
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
    // TEST 9 - SHOW PASSWORD
    // =========================================================

    @Test
    public void verifyShowPassword() {

        String testName = "Verify Show Password";

        try {

            loginPage.enterPassword(
                    "Password@123"
            );

            boolean result =
                    loginPage.isShowPasswordButtonDisplayed();

            Assert.assertTrue(
                    result,
                    "Show Password button is not displayed"
            );

            loginPage.clickShowPassword();

            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Show Password button is displayed and clickable."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Show Password button validation failed."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Show Password button could not be tested."
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
    // TEST 10 - REGISTER LINK
    // =========================================================

    @Test
    public void verifyRegisterLink() {

        String testName = "Verify Register Link";

        try {

            boolean result =
                    loginPage.isRegisterLinkDisplayed();

            Assert.assertTrue(
                    result,
                    "Register link is not displayed"
            );

            System.out.println("----------------------------------------");
            System.out.println("✅ PASS : " + testName);
            System.out.println(
                    "Reason : Register link is displayed successfully."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Register link validation failed."
            );
            System.out.println(
                    "Error : " + e.getMessage()
            );

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("❌ FAIL : " + testName);
            System.out.println(
                    "Reason : Register link could not be tested."
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
}