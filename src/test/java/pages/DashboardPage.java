package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // =========================================================
    // PAGE & HEADER LOCATORS
    // =========================================================

    private By dashboardHeading =
            By.xpath("//h1[normalize-space()='Dashboard']");

    private By welcomeSubheading =
            By.xpath("//p[contains(normalize-space(),'Welcome back')]");

    private By welcomeStudentName =
            By.xpath("//p[contains(normalize-space(),'Welcome back')]/span");

    private By searchInput =
            By.xpath("//input[@placeholder='Search here...']");

    private By mobileMenuButton =
            By.xpath("//button[@aria-label='Toggle navigation menu']");

    private By themeToggle =
            By.id("theme-toggle-btn");

    private By notificationButton =
            By.id("header-notification-btn");

    private By notificationRedBadge =
            By.xpath(
                    "//button[@id='header-notification-btn']" +
                            "/span[contains(@class,'bg-red-500')]"
            );

    private By profileMenuButton =
            By.id("header-profile-menu-btn");


    // =========================================================
    // PROFILE DROPDOWN LOCATORS
    // =========================================================

    private By profileDropdownContainer =
            By.xpath(
                    "//button[@id='header-profile-menu-btn']" +
                            "/following-sibling::div"
            );

    private By profileDropdownMyProfileLink =
            By.xpath(
                    "//a[@href='/dashboard/profile' " +
                            "and contains(normalize-space(.),'My Profile')]"
            );

    private By profileDropdownMyApplicationLink =
            By.xpath(
                    "//a[@href='/dashboard/application' " +
                            "and contains(normalize-space(.),'My Application')]"
            );

    private By profileDropdownTrackStatusLink =
            By.xpath(
                    "//a[@href='/dashboard/status' " +
                            "and contains(normalize-space(.),'Track Status')]"
            );

    private By profileDropdownLogoutButton =
            By.id("profile-dropdown-logout-btn");


    // =========================================================
    // SIDEBAR LOCATORS
    // =========================================================

    private By sidebarAside =
            By.xpath("//aside[@aria-label='Sidebar']");

    private By sidebarDashboardLink =
            By.xpath(
                    "//aside[@aria-label='Sidebar']" +
                            "//a[@href='/dashboard']"
            );

    private By sidebarMyProfileLink =
            By.xpath(
                    "//aside[@aria-label='Sidebar']" +
                            "//a[@href='/dashboard/profile']"
            );

    private By sidebarMyApplicationLink =
            By.xpath(
                    "//aside[@aria-label='Sidebar']" +
                            "//a[@href='/dashboard/application']"
            );

    private By sidebarTrackStatusLink =
            By.xpath(
                    "//aside[@aria-label='Sidebar']" +
                            "//a[@href='/dashboard/status']"
            );

    private By sidebarLogoutButton =
            By.xpath(
                    "//aside[@aria-label='Sidebar']" +
                            "//button[contains(normalize-space(.),'Logout')]"
            );


    // =========================================================
    // NOTIFICATION LOCATORS
    // =========================================================

    private By notificationDropdownContainer =
            By.xpath(
                    "//button[@id='header-notification-btn']" +
                            "/following-sibling::div"
            );

    private By markAllReadButton =
            By.xpath(
                    "//button[contains(normalize-space(.),'Mark all read')]"
            );

    private By singleMarkReadButton =
            By.xpath(
                    "//button[@title='Mark as read' " +
                            "or normalize-space()='Mark read']"
            );

    private By dropdownViewAllNotificationsLink =
            By.xpath(
                    "//div[contains(@class,'absolute')]" +
                            "//a[@href='/dashboard/status']"
            );


    // =========================================================
    // WELCOME BANNER
    // =========================================================

    private By welcomeBannerHeading =
            By.xpath(
                    "//h2[contains(@class,'font-bold') " +
                            "and contains(normalize-space(.),'!')]"
            );

    private By welcomeBannerContinueBtn =
            By.xpath(
                    "//a[@href='/dashboard/application' " +
                            "and contains(normalize-space(.),'Continue Application')]"
            );


    // =========================================================
    // SUMMARY CARDS
    // =========================================================

    private By summaryAppIdValue =
            By.xpath(
                    "//p[normalize-space()='Application ID']" +
                            "/following-sibling::p"
            );

    private By summaryAppStatusValue =
            By.xpath(
                    "//p[normalize-space()='Application Status']" +
                            "/following-sibling::div/span" +
                            "[contains(@class,'font-semibold')]"
            );

    private By summaryProfileCompletionValue =
            By.xpath(
                    "//p[normalize-space()='Profile Completion']" +
                            "/following-sibling::span"
            );

    private By summaryUploadedDocsValue =
            By.xpath(
                    "//p[normalize-space()='Documents Uploaded']" +
                            "/following-sibling::div/span"
            );


    // =========================================================
    // APPLICATION PROGRESS
    // =========================================================

    private By progressTrackerHeading =
            By.xpath(
                    "//h2[normalize-space()='Application Progress']"
            );

    private By stepRegistration =
            By.xpath(
                    "//*[self::span or self::p]" +
                            "[normalize-space()='Registration']"
            );

    private By stepProfile =
            By.xpath(
                    "//*[self::span or self::p]" +
                            "[normalize-space()='Profile']"
            );

    private By stepDocuments =
            By.xpath(
                    "//*[self::span or self::p]" +
                            "[normalize-space()='Documents']"
            );

    private By stepInstituteVerification =
            By.xpath(
                    "//*[self::span or self::p]" +
                            "[normalize-space()='Institute Verification']"
            );

    private By stepOfficerVerification =
            By.xpath(
                    "//*[self::span or self::p]" +
                            "[normalize-space()='Officer Verification']"
            );

    private By stepFinalDecision =
            By.xpath(
                    "//*[self::span or self::p]" +
                            "[normalize-space()='Final Decision']"
            );


    // =========================================================
    // SECTION LOCATORS
    // =========================================================

    private By recentActivityHeading =
            By.xpath(
                    "//h3[normalize-space()='Recent Activity']"
            );

    private By recentActivityViewAllLink =
            By.xpath(
                    "//a[@href='/dashboard/status' " +
                            "and contains(normalize-space(.),'View All Activity')]"
            );

    private By importantNotificationsHeading =
            By.xpath(
                    "//h3[normalize-space()='Important Notifications']"
            );

    private By importantNotificationsMarkReadBtn =
            By.xpath(
                    "//h3[normalize-space()='Important Notifications']" +
                            "/following-sibling::button"
            );

    private By importantNotificationsViewAllLink =
            By.xpath(
                    "//a[@href='/dashboard/status' " +
                            "and contains(normalize-space(.),'View All Notifications')]"
            );

    private By myDocumentsHeading =
            By.xpath(
                    "//h3[normalize-space()='My Documents']"
            );

    private By docsUploadedTab =
            By.xpath(
                    "//button[contains(normalize-space(.),'Uploaded')]"
            );

    private By docsPendingTab =
            By.xpath(
                    "//button[contains(normalize-space(.),'Pending')]"
            );

    private By docsRejectedTab =
            By.xpath(
                    "//button[contains(normalize-space(.),'Rejected')]"
            );

    private By docsUploadNewButton =
            By.xpath(
                    "//a[@href='/dashboard/profile' " +
                            "and normalize-space()='Upload New']"
            );


    // =========================================================
    // QUICK ACTION LOCATORS
    // =========================================================

    private By quickActionCompleteProfile =
            By.xpath(
                    "//a[@href='/dashboard/profile' " +
                            "and .//h4[normalize-space()='Complete Profile']]"
            );

    private By quickActionUploadDocuments =
            By.xpath(
                    "//a[@href='/dashboard/documents' " +
                            "and .//h4[normalize-space()='Upload Documents']]"
            );

    private By quickActionViewApplication =
            By.xpath(
                    "//a[@href='/dashboard/application' " +
                            "and .//h4[normalize-space()='View Application']]"
            );

    private By quickActionCheckStatus =
            By.xpath(
                    "//a[@href='/dashboard/status' " +
                            "and .//h4[normalize-space()='Check Application Status']]"
            );


    // =========================================================
    // AWARD LETTER
    // =========================================================

    private By awardLetterNoticeBanner =
            By.xpath(
                    "//p[contains(normalize-space(.)," +
                            "'Congratulations! Your scholarship application has been approved.')]"
            );

    private By awardLetterButton =
            By.xpath(
                    "//button[contains(normalize-space(.),'Award Letter')]"
            );


    // =========================================================
    // AI ASSISTANT
    // =========================================================

    private By chatbotWidgetButton =
            By.xpath(
                    "//button[@aria-label='Open support chat']"
            );


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public DashboardPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }


    // =========================================================
    // GENERIC HELPERS
    // =========================================================

    private boolean isDisplayed(By locator) {

        try {

            WebElement element =
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    locator
                            )
                    );

            return element.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    private void safeClick(By locator) {

        WebElement element =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                locator
                        )
                );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            locator
                    )
            );

            element.click();

        } catch (ElementClickInterceptedException e) {

            System.out.println(
                    "Normal click intercepted. Using JavaScript click."
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    element
            );
        }
    }

    public void clickProfileMyProfileLink() {
        clickProfileMenu();
        safeClick(profileDropdownMyProfileLink);
    }

    // =========================================================
    // PAGE & HEADER METHODS
    // =========================================================

    public boolean isDashboardHeadingDisplayed() {
        return isDisplayed(dashboardHeading);
    }

    public boolean isWelcomeSubheadingDisplayed() {
        return isDisplayed(welcomeSubheading);
    }

    public boolean isWelcomeStudentNameDisplayed() {
        return isDisplayed(welcomeStudentName);
    }

    public boolean isSearchInputDisplayed() {
        return isDisplayed(searchInput);
    }

    public boolean isMobileMenuDisplayed() {
        return isDisplayed(mobileMenuButton);
    }

    public boolean isThemeToggleDisplayed() {
        return isDisplayed(themeToggle);
    }

    public void clickThemeToggle() {

        safeClick(themeToggle);

        System.out.println("Theme toggle clicked");
    }

    public boolean isNotificationButtonDisplayed() {
        return isDisplayed(notificationButton);
    }

    public void clickNotificationButton() {

        safeClick(notificationButton);

        System.out.println("Notification button clicked");
    }

    public boolean isNotificationBadgeDisplayed() {
        return isDisplayed(notificationRedBadge);
    }

    public boolean isProfileMenuDisplayed() {
        return isDisplayed(profileMenuButton);
    }

    public void clickProfileMenu() {

        safeClick(profileMenuButton);

        System.out.println("Profile menu clicked");
    }


    // =========================================================
    // PROFILE DROPDOWN METHODS
    // =========================================================

    public boolean isProfileDropdownDisplayed() {

        return
                isDisplayed(profileDropdownMyProfileLink)
                        ||
                        isDisplayed(profileDropdownMyApplicationLink)
                        ||
                        isDisplayed(profileDropdownTrackStatusLink);
    }

    public boolean isMyProfileLinkDisplayed() {
        return isDisplayed(profileDropdownMyProfileLink);
    }

    public boolean isMyApplicationLinkDisplayed() {
        return isDisplayed(profileDropdownMyApplicationLink);
    }

    public boolean isTrackStatusLinkDisplayed() {
        return isDisplayed(profileDropdownTrackStatusLink);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(profileDropdownLogoutButton);
    }


    // =========================================================
    // SIDEBAR METHODS
    // =========================================================

    public boolean isSidebarDisplayed() {
        return isDisplayed(sidebarAside);
    }

    public boolean isSidebarDashboardLinkDisplayed() {
        return isDisplayed(sidebarDashboardLink);
    }

    public boolean isSidebarMyProfileLinkDisplayed() {
        return isDisplayed(sidebarMyProfileLink);
    }

    public boolean isSidebarMyApplicationLinkDisplayed() {
        return isDisplayed(sidebarMyApplicationLink);
    }

    public boolean isSidebarTrackStatusLinkDisplayed() {
        return isDisplayed(sidebarTrackStatusLink);
    }

    public boolean isSidebarLogoutDisplayed() {
        return isDisplayed(sidebarLogoutButton);
    }


    // =========================================================
    // NOTIFICATION METHODS
    // =========================================================

    public boolean isNotificationDropdownDisplayed() {

        return
                isDisplayed(notificationDropdownContainer)
                        ||
                        isDisplayed(markAllReadButton);
    }

    public boolean isMarkAllReadDisplayed() {
        return isDisplayed(markAllReadButton);
    }

    public boolean isSingleMarkReadDisplayed() {
        return isDisplayed(singleMarkReadButton);
    }

    public boolean isViewAllNotificationsDisplayed() {
        return isDisplayed(dropdownViewAllNotificationsLink);
    }

    public void clickMarkAllRead() {

        if (isDisplayed(markAllReadButton)) {

            safeClick(markAllReadButton);

            System.out.println(
                    "Mark all read clicked"
            );
        }
    }


    // =========================================================
    // WELCOME BANNER METHODS
    // =========================================================

    public boolean isWelcomeBannerDisplayed() {
        return isDisplayed(welcomeBannerHeading);
    }

    public boolean isContinueApplicationDisplayed() {
        return isDisplayed(welcomeBannerContinueBtn);
    }


    // =========================================================
    // SUMMARY CARD METHODS
    // =========================================================

    public boolean isApplicationIdDisplayed() {
        return isDisplayed(summaryAppIdValue);
    }

    public boolean isApplicationStatusDisplayed() {
        return isDisplayed(summaryAppStatusValue);
    }

    public boolean isProfileCompletionDisplayed() {
        return isDisplayed(summaryProfileCompletionValue);
    }

    public boolean isDocumentsUploadedDisplayed() {
        return isDisplayed(summaryUploadedDocsValue);
    }


    // =========================================================
    // APPLICATION PROGRESS METHODS
    // =========================================================

    public boolean isApplicationProgressDisplayed() {
        return isDisplayed(progressTrackerHeading);
    }

    public boolean isRegistrationStepDisplayed() {
        return isDisplayed(stepRegistration);
    }

    public boolean isProfileStepDisplayed() {
        return isDisplayed(stepProfile);
    }

    public boolean isDocumentsStepDisplayed() {
        return isDisplayed(stepDocuments);
    }

    public boolean isInstituteVerificationStepDisplayed() {
        return isDisplayed(stepInstituteVerification);
    }

    public boolean isOfficerVerificationStepDisplayed() {
        return isDisplayed(stepOfficerVerification);
    }

    public boolean isFinalDecisionStepDisplayed() {
        return isDisplayed(stepFinalDecision);
    }


    // =========================================================
    // SECTION METHODS
    // =========================================================

    public boolean isRecentActivityDisplayed() {
        return isDisplayed(recentActivityHeading);
    }

    public boolean isRecentActivityViewAllDisplayed() {
        return isDisplayed(recentActivityViewAllLink);
    }

    public boolean isImportantNotificationsDisplayed() {
        return isDisplayed(importantNotificationsHeading);
    }

    public boolean isImportantNotificationsMarkReadDisplayed() {
        return isDisplayed(
                importantNotificationsMarkReadBtn
        );
    }

    public boolean isImportantNotificationsViewAllDisplayed() {
        return isDisplayed(
                importantNotificationsViewAllLink
        );
    }

    public boolean isMyDocumentsDisplayed() {
        return isDisplayed(myDocumentsHeading);
    }


    // =========================================================
    // DOCUMENT METHODS
    // =========================================================

    public boolean isUploadedTabDisplayed() {
        return isDisplayed(docsUploadedTab);
    }

    public boolean isPendingTabDisplayed() {
        return isDisplayed(docsPendingTab);
    }

    public boolean isRejectedTabDisplayed() {
        return isDisplayed(docsRejectedTab);
    }

    public boolean isUploadNewDisplayed() {
        return isDisplayed(docsUploadNewButton);
    }


    // =========================================================
    // QUICK ACTION METHODS
    // =========================================================

    public boolean isCompleteProfileDisplayed() {
        return isDisplayed(quickActionCompleteProfile);
    }

    public boolean isUploadDocumentsDisplayed() {
        return isDisplayed(quickActionUploadDocuments);
    }

    public boolean isViewApplicationDisplayed() {
        return isDisplayed(quickActionViewApplication);
    }

    public boolean isCheckStatusDisplayed() {
        return isDisplayed(quickActionCheckStatus);
    }


    // =========================================================
    // AWARD LETTER METHODS
    // =========================================================

    public boolean isAwardLetterNoticeDisplayed() {
        return isDisplayed(awardLetterNoticeBanner);
    }

    public boolean isAwardLetterButtonDisplayed() {
        return isDisplayed(awardLetterButton);
    }

    public void clickAwardLetter() {

        if (isDisplayed(awardLetterButton)) {

            safeClick(awardLetterButton);

            System.out.println(
                    "Award Letter button clicked"
            );
        }
    }


    // =========================================================
    // CHATBOT METHODS
    // =========================================================

    public boolean isChatbotDisplayed() {
        return isDisplayed(chatbotWidgetButton);
    }

    public void clickChatbot() {

        if (isDisplayed(chatbotWidgetButton)) {

            safeClick(chatbotWidgetButton);

            System.out.println(
                    "AI Assistant clicked"
            );
        }
    }
}