package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // LOCATORS
    // =========================================================

    private By email =
            By.id("login-email");

    private By password =
            By.id("login-password");

    private By showPasswordButton =
            By.xpath("//button[@aria-label='Show password']");

    private By loginButton =
            By.id("login-btn");

    private By signUpLink =
            By.xpath("//a[@href='/register']");


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }


    // =========================================================
    // EMAIL
    // =========================================================

    public boolean isEmailDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        ).isDisplayed();
    }

    public void enterEmail(String emailAddress) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        );

        element.clear();
        element.sendKeys(emailAddress);
    }


    // =========================================================
    // PASSWORD
    // =========================================================

    public boolean isPasswordDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        ).isDisplayed();
    }

    public void enterPassword(String passwordValue) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        );

        element.clear();
        element.sendKeys(passwordValue);
    }


    // =========================================================
    // SHOW PASSWORD BUTTON
    // =========================================================

    public boolean isShowPasswordButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        showPasswordButton
                )
        ).isDisplayed();
    }

    public void clickShowPassword() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        showPasswordButton
                )
        ).click();
    }


    // =========================================================
    // LOGIN BUTTON
    // =========================================================

    public boolean isLoginButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginButton
                )
        ).isDisplayed();
    }

    public boolean isLoginButtonEnabled() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginButton
                )
        ).isEnabled();
    }

    public void clickLoginButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();
    }


    // =========================================================
    // SIGN UP LINK
    // =========================================================

    public boolean isRegisterLinkDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        signUpLink
                )
        ).isDisplayed();
    }

    public void clickRegisterLink() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        signUpLink
                )
        ).click();
    }

    public void clickSignIn() {

    }

    public void clickLogin() {
    }
}