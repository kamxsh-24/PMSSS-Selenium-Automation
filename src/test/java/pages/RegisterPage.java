package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By fullName = By.id("reg-fullname");
    private By email = By.id("reg-email");
    private By password = By.id("reg-password");
    private By confirmPassword = By.id("reg-confirm");
    private By nextButton = By.id("reg-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isFullNameDisplayed() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(fullName)
        );
        return element.isDisplayed();
    }

    public boolean isEmailDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        ).isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        ).isDisplayed();
    }

    public boolean isConfirmPasswordDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmPassword)
        ).isDisplayed();
    }

    public void enterFullName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullName))
                .sendKeys(name);
    }

    public void enterEmail(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys(emailAddress);
    }

    public void enterPassword(String passwordValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys(passwordValue);
    }

    public void enterConfirmPassword(String passwordValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword))
                .sendKeys(passwordValue);
    }
}