package tests;

import base.BaseTest;
import utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {

        driver.get(
                ConfigReader.getBaseUrl() + "/login"
        );

        loginPage = new LoginPage(driver);

        System.out.println("\n========================================");
        System.out.println("Opening Login Page");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("========================================");
    }


    // =========================================================
    // TEST 1 - VERIFY LOGIN PAGE
    // =========================================================

    @Test
    public void verifyLoginPage() {

        String testName = "Verify Login Page";

        try {

            System.out.println("START: " + testName);

            boolean urlCorrect =
                    driver.getCurrentUrl().contains("/login");

            Assert.assertTrue(
                    urlCorrect,
                    "Login page URL is incorrect"
            );

            System.out.println("PASS : " + testName);
            System.out.println("Reason : Login page opened successfully.");

        } catch (AssertionError e) {

            System.out.println("FAIL : " + testName);
            System.out.println("Reason : Login page did not open correctly.");
            System.out.println("Error : " + e.getMessage());

            throw e;

        } catch (Exception e) {

            System.out.println("FAIL : " + testName);
            System.out.println("Reason : Unexpected Selenium error.");
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

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

            System.out.println("\nSTART: " + testName);

            // Email
            System.out.println("Checking Email field...");

            boolean email =
                    loginPage.isEmailDisplayed();

            if (email) {
                System.out.println("PASS : Email field");
            } else {
                System.out.println("FAIL : Email field");
            }


            // Password
            System.out.println("Checking Password field...");

            boolean password =
                    loginPage.isPasswordDisplayed();

            if (password) {
                System.out.println("PASS : Password field");
            } else {
                System.out.println("FAIL : Password field");
            }


            // Login button
            System.out.println("Checking Login button...");

            boolean loginButton =
                    loginPage.isLoginButtonDisplayed();

            if (loginButton) {
                System.out.println("PASS : Login button");
            } else {
                System.out.println("FAIL : Login button");
            }


            System.out.println("----------------------------------------");

            Assert.assertTrue(
                    email,
                    "Email field is not displayed"
            );

            Assert.assertTrue(
                    password,
                    "Password field is not displayed"
            );

            Assert.assertTrue(
                    loginButton,
                    "Login button is not displayed"
            );

            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : All login fields and button are displayed."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println("Reason : One or more login elements are missing.");
            System.out.println("Error : " + e.getMessage());

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println("Reason : Selenium encountered an unexpected error.");
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // TEST 3 - VALID LOGIN
    // =========================================================

    @Test
    public void verifyValidLogin() {

        String testName = "Valid Login";

        try {

            System.out.println("\nSTART: " + testName);

            String validEmail = "YOUR_VALID_EMAIL";
            String validPassword = "YOUR_VALID_PASSWORD";

            System.out.println("Entering valid email...");

            loginPage.enterEmail(validEmail);

            System.out.println("PASS : Email entered");


            System.out.println("Entering valid password...");

            loginPage.enterPassword(validPassword);

            System.out.println("PASS : Password entered");


            System.out.println("Clicking Login button...");

            loginPage.clickLoginButton();

            System.out.println("PASS : Login button clicked");


            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Valid login credentials were submitted successfully."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println("Reason : Login assertion failed.");
            System.out.println("Error : " + e.getMessage());

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println("Reason : Unable to perform valid login.");
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // TEST 4 - INVALID EMAIL
    // =========================================================

    @Test
    public void verifyInvalidEmail() {

        String testName = "Invalid Email Login";

        try {

            System.out.println("\nSTART: " + testName);

            loginPage.enterEmail("invalidemail");

            System.out.println("PASS : Invalid email entered");

            loginPage.enterPassword("Password@123");

            System.out.println("PASS : Password entered");

            loginPage.clickLoginButton();

            System.out.println("PASS : Login button clicked");

            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Invalid email test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Unable to execute invalid email test."
            );
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // TEST 5 - EMPTY EMAIL
    // =========================================================

    @Test
    public void verifyEmptyEmail() {

        String testName = "Empty Email Login";

        try {

            System.out.println("\nSTART: " + testName);

            loginPage.enterEmail("");

            System.out.println("PASS : Empty email entered");

            loginPage.enterPassword("Password@123");

            System.out.println("PASS : Password entered");

            loginPage.clickLoginButton();

            System.out.println("PASS : Login button clicked");

            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Empty email validation test executed."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Unable to execute empty email test."
            );
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // TEST 6 - EMPTY PASSWORD
    // =========================================================

    @Test
    public void verifyEmptyPassword() {

        String testName = "Empty Password Login";

        try {

            System.out.println("\nSTART: " + testName);

            loginPage.enterEmail("test@example.com");

            System.out.println("PASS : Email entered");

            loginPage.enterPassword("");

            System.out.println("PASS : Empty password entered");

            loginPage.clickLoginButton();

            System.out.println("PASS : Login button clicked");

            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Empty password validation test executed."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Unable to execute empty password test."
            );
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // TEST 7 - WRONG PASSWORD
    // =========================================================

    @Test
    public void verifyWrongPassword() {

        String testName = "Wrong Password Login";

        try {

            System.out.println("\nSTART: " + testName);

            loginPage.enterEmail("test@example.com");

            System.out.println("PASS : Email entered");

            loginPage.enterPassword("WrongPassword@999");

            System.out.println("PASS : Wrong password entered");

            loginPage.clickLoginButton();

            System.out.println("PASS : Login button clicked");

            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Wrong password test executed successfully."
            );

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Unable to execute wrong password test."
            );
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }


    // =========================================================
    // TEST 8 - VERIFY REGISTER LINK
    // =========================================================

    @Test
    public void verifyRegisterLink() {

        String testName = "Verify Register Link";

        try {

            System.out.println("\nSTART: " + testName);

            boolean result =
                    loginPage.isRegisterLinkDisplayed();

            Assert.assertTrue(
                    result,
                    "Register link is not displayed"
            );

            System.out.println("----------------------------------------");
            System.out.println("PASS : " + testName);
            System.out.println(
                    "Reason : Register link is displayed successfully."
            );

        } catch (AssertionError e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Register link is not displayed."
            );
            System.out.println("Error : " + e.getMessage());

            throw e;

        } catch (Exception e) {

            System.out.println("----------------------------------------");
            System.out.println("FAIL : " + testName);
            System.out.println(
                    "Reason : Selenium encountered an unexpected error."
            );
            System.out.println("Error : " + e.getClass().getSimpleName());
            System.out.println("Details : " + e.getMessage());

            throw e;
        }
    }
}