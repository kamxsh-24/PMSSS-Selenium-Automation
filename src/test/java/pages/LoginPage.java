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

    private By loginButton =
            By.id("login-button");


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // =========================================================
    // VERIFY EMAIL FIELD
    // =========================================================

    public boolean isEmailDisplayed() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(email)
                );

        return element.isDisplayed();
    }


    // =========================================================
    // VERIFY PASSWORD FIELD
    // =========================================================

    public boolean isPasswordDisplayed() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(password)
                );

        return element.isDisplayed();
    }


    // =========================================================
    // VERIFY LOGIN BUTTON
    // =========================================================

    public boolean isLoginButtonDisplayed() {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(loginButton)
                );

        return element.isDisplayed();
    }


    // =========================================================
    // ENTER EMAIL
    // =========================================================

    public void enterEmail(String emailAddress) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(email)
                );

        element.clear();
        element.sendKeys(emailAddress);
    }


    // =========================================================
    // ENTER PASSWORD
    // =========================================================

    public void enterPassword(String passwordValue) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(password)
                );

        element.clear();
        element.sendKeys(passwordValue);
    }


    // =========================================================
    // CLICK LOGIN BUTTON
    // =========================================================

    public void clickLoginButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    // =========================================================
    // CLICK REGISTER LINKED DISPLAYED
    // =========================================================

    public boolean isRegisterLinkDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@href='/register']")
                )
        ).isDisplayed();
    }
}