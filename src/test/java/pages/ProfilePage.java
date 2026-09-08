package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // =========================================================
    // TOAST OVERLAY LOCATOR
    // =========================================================

    private final By toastNotification = By.cssSelector("#toast-container .toast-notification, .toast-enter");

    // =========================================================
    // SECTION TABS
    // =========================================================

    private final By personalTab = By.xpath("//button[contains(.,'Personal Details')]");
    private final By addressTab = By.xpath("//button[contains(.,'Address Info')]");
    private final By academicTab = By.xpath("//button[contains(.,'Academic Info')]");
    private final By familyTab = By.xpath("//button[contains(.,'Family & Income')]");
    private final By bankTab = By.xpath("//button[contains(.,'Bank Details')]");
    private final By documentsTab = By.xpath("//button[contains(.,'Documents')]");

    // =========================================================
    // HEADER & PROFILE SUMMARY LOCATORS
    // =========================================================

    private final By profileHeading = By.xpath("//h1[contains(@class,'font-bold')]");
    private final By profileAvatar = By.xpath("//img[@alt='preview'] | //div[contains(@class,'h-16 w-16')]");
    private final By userRoleSubtitle = By.xpath("//p[contains(text(),'Role: Student')]");
    private final By verificationBadge = By.xpath("//span[contains(text(),'Verified') or contains(text(),'Pending') or contains(text(),'Rejected')]");
    private final By completionPercentageText = By.xpath("//span[contains(@class,'text-[#1769FF]') and contains(text(),'%')]");

    // =========================================================
    // PERSONAL INFORMATION LOCATORS
    // =========================================================

    private final By fullNameInput = By.id("fullName");
    private final By dobInput = By.id("dob");
    private final By genderSelect = By.id("gender");
    private final By categorySelect = By.id("category");
    private final By bloodGroupInput = By.id("bloodGroup");
    private final By nationalityInput = By.id("nationality");
    private final By emailInput = By.id("email");
    private final By phoneInput = By.id("phone");
    private final By aadhaarInput = By.id("aadhaar");

    // =========================================================
    // ADDRESS INFORMATION LOCATORS
    // =========================================================

    private final By permanentAddressInput = By.id("permanentAddress");
    private final By currentAddressInput = By.id("currentAddress");
    private final By stateSelect = By.id("state");
    private final By districtInput = By.id("district");
    private final By pincodeInput = By.id("pincode");

    // =========================================================
    // ACADEMIC INFORMATION LOCATORS
    // =========================================================

    private final By collegeNameInput = By.id("collegeName");
    private final By universityNameInput = By.id("universityName");
    private final By degreeInput = By.id("degree");
    private final By departmentInput = By.id("department");
    private final By yearOfStudySelect = By.id("yearOfStudy");
    private final By rollNumberInput = By.id("rollNumber");
    private final By academicYearInput = By.id("academicYear");
    private final By cgpaInput = By.id("cgpa");

    // =========================================================
    // FAMILY & INCOME LOCATORS
    // =========================================================

    private final By fatherNameInput = By.id("fatherName");
    private final By motherNameInput = By.id("motherName");
    private final By parentOccupationInput = By.id("parentOccupation");
    private final By familyIncomeInput = By.id("familyIncome");

    // =========================================================
    // BANK DETAILS LOCATORS
    // =========================================================

    private final By accountHolderNameInput = By.id("accountHolderName");
    private final By bankNameInput = By.id("bankName");
    private final By branchNameInput = By.id("branchName");
    private final By accountNumberInput = By.id("accountNumber");
    private final By ifscCodeInput = By.id("ifscCode");

    // =========================================================
    // DOCUMENTS LOCATORS
    // =========================================================

    private final By documentsSectionHeading = By.xpath("//h3[contains(text(),'Documents & Photo Upload')]");
    private final By photoCard = By.xpath("//label[contains(text(),'Profile Photo')]/ancestor::div[1]");
    private final By aadhaarCard = By.xpath("//label[contains(text(),'Aadhaar Card')]/ancestor::div[1]");
    private final By incomeCertCard = By.xpath("//label[contains(text(),'Income Certificate')]/ancestor::div[1]");
    private final By marksheetCard = By.xpath("//label[contains(text(),'Marksheet')]/ancestor::div[1]");
    private final By bankPassbookCard = By.xpath("//label[contains(text(),'Bank Passbook')]/ancestor::div[1]");
    private final By casteCertCard = By.xpath("//label[contains(text(),'Caste/Community')]/ancestor::div[1]");
    private final By removeFileBtn = By.xpath("//button[@aria-label='Remove file']");
    private final By documentViewLinks = By.xpath("//a[contains(text(),'View Photo') or contains(text(),'View Document')]");

    // =========================================================
    // FORM ACTIONS & VALIDATION LOCATORS
    // =========================================================

    private final By saveProfileChangesBtn = By.xpath("//button[@type='submit' and contains(.,'Save Profile Changes')]");
    private final By requestDeleteBtn = By.xpath("//button[contains(.,'Request Profile Delete')]");
    private final By fieldErrorMessages = By.xpath("//p[contains(@class,'text-red-500')]");

    // =========================================================
    // NAVIGATION LINKS
    // =========================================================

    private final By sidebarDashboardLink = By.xpath("//aside[@aria-label='Sidebar']//a[@href='/dashboard']");
    private final By sidebarMyProfileLink = By.xpath("//aside[@aria-label='Sidebar']//a[@href='/dashboard/profile']");
    private final By sidebarMyApplicationLink = By.xpath("//aside[@aria-label='Sidebar']//a[@href='/dashboard/application']");
    private final By sidebarTrackStatusLink = By.xpath("//aside[@aria-label='Sidebar']//a[@href='/dashboard/status']");
    private final By headerProfileMenuBtn = By.id("header-profile-menu-btn");
    private final By headerLogoutBtn = By.id("profile-dropdown-logout-btn");

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================================================
    // REUSABLE HELPER METHODS & SYNCHRONIZATION
    // =========================================================

    public void waitForToastToDisappear() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            shortWait.until(ExpectedConditions.invisibilityOfElementLocated(toastNotification));
        } catch (Exception ignored) {
        }
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickSafely(By locator) {
        waitForToastToDisappear();
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        try {
            waitForClickable(locator).click();
        } catch (ElementClickInterceptedException e) {
            waitForToastToDisappear();
            try {
                waitForClickable(locator).click();
            } catch (Exception fallback) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        }
    }

    public String getFieldValue(By locator) {
        WebElement el = waitForVisible(locator);
        String val = el.getAttribute("value");
        return (val != null && !val.isEmpty()) ? val : el.getText();
    }

    public void setInputValue(By locator, String value) {
        WebElement el = waitForVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
        el.sendKeys(Keys.CONTROL + "a");
        el.sendKeys(Keys.DELETE);
        el.clear();
        if (value != null && !value.isEmpty()) {
            el.sendKeys(value);
        }
    }

    public void selectDropdownByText(By locator, String text) {
        WebElement el = waitForVisible(locator);
        Select select = new Select(el);
        select.selectByVisibleText(text);
    }

    // =========================================================
    // SECTION TAB SWITCHING
    // =========================================================

    public void clickPersonalTab() {
        clickSafely(personalTab);
    }

    public void clickAddressTab() {
        clickSafely(addressTab);
    }

    public void clickAcademicTab() {
        clickSafely(academicTab);
    }

    public void clickFamilyTab() {
        clickSafely(familyTab);
    }

    public void clickBankTab() {
        clickSafely(bankTab);
    }

    public void clickDocumentsTab() {
        clickSafely(documentsTab);
    }

    // =========================================================
    // SECTION 1 — PAGE & HEADING GETTERS
    // =========================================================

    public boolean isProfileHeadingDisplayed() {
        return isDisplayed(profileHeading);
    }

    public String getProfileHeadingText() {
        return getFieldValue(profileHeading);
    }

    public boolean isProfileAvatarDisplayed() {
        return isDisplayed(profileAvatar);
    }

    public boolean isVerificationBadgeDisplayed() {
        return isDisplayed(verificationBadge);
    }

    public boolean isCompletionPercentageDisplayed() {
        return isDisplayed(completionPercentageText);
    }

    // =========================================================
    // SECTION 2 — PERSONAL INFORMATION
    // =========================================================

    public boolean isFullNameDisplayed() {
        clickPersonalTab();
        return isDisplayed(fullNameInput);
    }

    public String getFullNameValue() {
        clickPersonalTab();
        return getFieldValue(fullNameInput);
    }

    public void enterFullName(String name) {
        clickPersonalTab();
        setInputValue(fullNameInput, name);
    }

    public boolean isDobDisplayed() {
        clickPersonalTab();
        return isDisplayed(dobInput);
    }

    public String getDobValue() {
        clickPersonalTab();
        return getFieldValue(dobInput);
    }

    public void enterDob(String dob) {
        clickPersonalTab();
        setInputValue(dobInput, dob);
    }

    public boolean isGenderDisplayed() {
        clickPersonalTab();
        return isDisplayed(genderSelect);
    }

    public boolean isCategoryDisplayed() {
        clickPersonalTab();
        return isDisplayed(categorySelect);
    }

    public boolean isEmailDisplayed() {
        clickPersonalTab();
        return isDisplayed(emailInput);
    }

    public String getEmailValue() {
        clickPersonalTab();
        return getFieldValue(emailInput);
    }

    public void enterEmail(String email) {
        clickPersonalTab();
        setInputValue(emailInput, email);
    }

    public boolean isPhoneDisplayed() {
        clickPersonalTab();
        return isDisplayed(phoneInput);
    }

    public String getPhoneValue() {
        clickPersonalTab();
        return getFieldValue(phoneInput);
    }

    public void enterPhone(String phone) {
        clickPersonalTab();
        setInputValue(phoneInput, phone);
    }

    public boolean isAadhaarDisplayed() {
        clickPersonalTab();
        return isDisplayed(aadhaarInput);
    }

    // =========================================================
    // SECTION 3 — ACADEMIC INFORMATION
    // =========================================================

    public boolean isCollegeNameDisplayed() {
        clickAcademicTab();
        return isDisplayed(collegeNameInput);
    }

    public String getCollegeNameValue() {
        clickAcademicTab();
        return getFieldValue(collegeNameInput);
    }

    public void enterCollegeName(String college) {
        clickAcademicTab();
        setInputValue(collegeNameInput, college);
    }

    public boolean isDegreeDisplayed() {
        clickAcademicTab();
        return isDisplayed(degreeInput);
    }

    public String getDegreeValue() {
        clickAcademicTab();
        return getFieldValue(degreeInput);
    }

    public void enterDegree(String degree) {
        clickAcademicTab();
        setInputValue(degreeInput, degree);
    }

    public boolean isYearOfStudyDisplayed() {
        clickAcademicTab();
        return isDisplayed(yearOfStudySelect);
    }

    public String getYearOfStudyValue() {
        clickAcademicTab();
        return getFieldValue(yearOfStudySelect);
    }

    // =========================================================
    // SECTION 4 — DOCUMENTS
    // =========================================================

    public boolean isDocumentsHeadingDisplayed() {
        clickDocumentsTab();
        return isDisplayed(documentsSectionHeading);
    }

    public boolean isPhotoCardDisplayed() {
        clickDocumentsTab();
        return isDisplayed(photoCard);
    }

    public boolean isAadhaarCardDisplayed() {
        clickDocumentsTab();
        return isDisplayed(aadhaarCard);
    }

    public boolean isIncomeCertCardDisplayed() {
        clickDocumentsTab();
        return isDisplayed(incomeCertCard);
    }

    public boolean isMarksheetCardDisplayed() {
        clickDocumentsTab();
        return isDisplayed(marksheetCard);
    }

    public boolean isBankPassbookCardDisplayed() {
        clickDocumentsTab();
        return isDisplayed(bankPassbookCard);
    }

    public boolean isCasteCertCardDisplayed() {
        clickDocumentsTab();
        return isDisplayed(casteCertCard);
    }

    public boolean isDocumentViewLinkDisplayed() {
        clickDocumentsTab();
        return isDisplayed(documentViewLinks);
    }

    // =========================================================
    // SECTION 5 & 6 — ACTIONS & VALIDATIONS
    // =========================================================

    public boolean isSaveButtonDisplayed() {
        return isDisplayed(saveProfileChangesBtn);
    }

    public void clickSaveButton() {
        safeClick(saveProfileChangesBtn);
    }

    public boolean hasValidationErrors() {
        try {
            List<WebElement> errors = driver.findElements(fieldErrorMessages);
            return !errors.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstValidationError() {
        try {
            WebElement error = waitForVisible(fieldErrorMessages);
            return error.getText();
        } catch (Exception e) {
            return "";
        }
    }

    // =========================================================
    // SECTION 7 — NAVIGATION LINKS
    // =========================================================

    public void clickSidebarDashboard() {
        safeClick(sidebarDashboardLink);
    }

    public void clickSidebarMyProfile() {
        safeClick(sidebarMyProfileLink);
    }

    public void clickSidebarMyApplication() {
        safeClick(sidebarMyApplicationLink);
    }

    public void clickSidebarTrackStatus() {
        safeClick(sidebarTrackStatusLink);
    }
}
