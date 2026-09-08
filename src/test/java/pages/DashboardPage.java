package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // DASHBOARD LOCATORS
    // =========================================================

    private By dashboardHeading =
            By.xpath("//h1[normalize-space()='Dashboard']");

    private By welcomeMessage =
            By.xpath("//p[contains(normalize-space(),'Welcome back')]");

    // Welcome Banner
    private By welcomeBanner =
            By.xpath("//*[contains(normalize-space(),'Welcome back')]");

    // Application related
    private By applicationProgress =
            By.xpath("//*[contains(normalize-space(),'Application Progress')]");

    // Notifications
    private By notifications =
            By.xpath("//*[contains(normalize-space(),'Notifications')]");

    private By importantNotifications =
            By.xpath("//*[contains(normalize-space(),'Important Notifications')]");

    // Documents
    private By documents =
            By.xpath("//*[contains(normalize-space(),'Documents')]");

    private By myDocuments =
            By.xpath("//*[contains(normalize-space(),'My Documents')]");

    // Quick Actions
    private By quickActions =
            By.xpath("//*[contains(normalize-space(),'Quick Actions')]");

    // Award Letter button
    private By awardLetterButton =
            By.xpath("//button[contains(normalize-space(),'Award Letter')]");

    // Downloading text
    private By downloadingText =
            By.xpath("//*[contains(normalize-space(),'Downloading...')]");

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // =========================================================
    // VERIFY DASHBOARD PAGE
    // =========================================================

    public boolean isDashboardDisplayed() {

        try {

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            dashboardHeading
                    )
            );

            return element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY DASHBOARD HEADING
    // =========================================================

    public boolean isDashboardHeadingDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            dashboardHeading
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY WELCOME MESSAGE
    // =========================================================

    public boolean isWelcomeMessageDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            welcomeMessage
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY WELCOME BANNER
    // =========================================================

    public boolean isWelcomeBannerDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            welcomeBanner
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY APPLICATION PROGRESS
    // =========================================================

    public boolean isApplicationProgressDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            applicationProgress
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY NOTIFICATIONS
    // =========================================================

    public boolean isNotificationsDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            notifications
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY IMPORTANT NOTIFICATIONS
    // =========================================================

    public boolean isImportantNotificationsDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            importantNotifications
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY DOCUMENTS
    // =========================================================

    public boolean isDocumentsDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            documents
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY MY DOCUMENTS
    // =========================================================

    public boolean isMyDocumentsDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            myDocuments
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY QUICK ACTIONS
    // =========================================================

    public boolean isQuickActionsDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            quickActions
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // VERIFY AWARD LETTER BUTTON
    // =========================================================

    public boolean isAwardLetterButtonDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            awardLetterButton
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // CLICK AWARD LETTER
    // =========================================================

    public void clickAwardLetter() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        awardLetterButton
                )
        ).click();
    }

    // =========================================================
    // VERIFY DOWNLOADING TEXT
    // =========================================================

    public boolean isDownloadingDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            downloadingText
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // GET CURRENT URL
    // =========================================================

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    // =========================================================
    // GET PAGE TITLE
    // =========================================================

    public String getPageTitle() {

        return driver.getTitle();
    }
}