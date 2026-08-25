package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // ACCOUNT INFO - SECTION 1
    // =========================================================

    private By fullName =
            By.id("reg-fullname");

    private By email =
            By.id("reg-email");

    private By password =
            By.id("reg-password");

    private By confirmPassword =
            By.id("reg-confirm");

    private By nextButton =
            By.id("reg-button");


    // =========================================================
    // PERSONAL & ACADEMIC INFO - SECTION 2
    // =========================================================

    private By phone =
            By.id("reg-phone");

    private By dateOfBirth =
            By.id("reg-dob");

    private By institution =
            By.id("reg-institution");

    private By course =
            By.id("reg-course");

    private By year =
            By.id("reg-year");

    private By backButton =
            By.xpath("//button[@type='button' and normalize-space()='Back']");

    private By registerButton =
            By.id("register-btn");


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public RegisterPage(WebDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );
    }


    // =========================================================
    // SECTION 1 - DISPLAY CHECK
    // =========================================================

    public boolean isFullNameDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(fullName)
        ).isDisplayed();
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


    // =========================================================
    // SECTION 1 - ENTER DATA
    // =========================================================

    public void enterFullName(String name) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(fullName)
                );

        element.clear();
        element.sendKeys(name);
    }

    public void enterEmail(String emailAddress) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(email)
                );

        element.clear();
        element.sendKeys(emailAddress);
    }

    public void enterPassword(String passwordValue) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(password)
                );

        element.clear();
        element.sendKeys(passwordValue);
    }

    public void enterConfirmPassword(String passwordValue) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(confirmPassword)
                );

        element.clear();
        element.sendKeys(passwordValue);
    }


    // =========================================================
    // NEXT BUTTON
    // =========================================================

    public void clickNextButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(nextButton)
        ).click();
    }


    // =========================================================
    // SECTION 2 - DISPLAY CHECK
    // =========================================================

    public boolean isPhoneDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(phone)
        ).isDisplayed();
    }

    public boolean isDateOfBirthDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dateOfBirth)
        ).isDisplayed();
    }

    public boolean isInstitutionDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(institution)
        ).isDisplayed();
    }

    public boolean isCourseDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(course)
        ).isDisplayed();
    }

    public boolean isYearDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(year)
        ).isDisplayed();
    }

    public boolean isBackButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(backButton)
        ).isDisplayed();
    }

    public boolean isRegisterButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(registerButton)
        ).isDisplayed();
    }


    // =========================================================
    // SECTION 2 - ENTER DATA
    // =========================================================

    public void enterPhone(String phoneNumber) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(phone)
                );

        element.clear();
        element.sendKeys(phoneNumber);
    }

    public void enterDateOfBirth(String dob) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(dateOfBirth)
                );

        element.clear();
        element.sendKeys(dob);
    }

    public void enterInstitution(String institutionName) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(institution)
                );

        element.clear();
        element.sendKeys(institutionName);
    }

    public void enterCourse(String courseName) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(course)
                );

        element.clear();
        element.sendKeys(courseName);
    }


    // =========================================================
    // BACK BUTTON
    // =========================================================

    public void clickBackButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(backButton)
        ).click();
    }


    // =========================================================
    // REGISTER BUTTON
    // =========================================================

    public void clickRegisterButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(registerButton)
        ).click();
    }


    // =========================================================
    // CHECK ELEMENT EXISTENCE
    // =========================================================

    public boolean isElementDisplayed(By locator) {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}