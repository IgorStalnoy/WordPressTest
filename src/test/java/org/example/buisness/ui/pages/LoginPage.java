package org.example.buisness.ui.pages;

import org.example.buisness.ui.pages.adminpages.DashboardPage;
import org.example.buisness.ui.utils.Configuration;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.buisness.ui.elements.Header.HEADER_LOGGED_IN_LOCATOR;
import static org.example.buisness.ui.utils.Constants.MAIN_URL;

public class LoginPage extends Page {
    public static final String VALID_USERNAME = Configuration.getUsername();
    public static final String VALID_PASSWORD = Configuration.getPassword();
    public static final String INVALID_USERNAME = MAIN_URL + "Invalid username";
    public static final String INVALID_PASSWORD = MAIN_URL + "Invalid password";
    public static final String LOGIN_PAGE_URL = MAIN_URL + "/wp-admin";
    public static final By LOGIN_PAGE_LOCATOR = By.xpath("//*[@id='loginform']");
    public static final By LOGIN_PAGE_USERNAME_FIELD_LOCATOR = By.xpath("//*[@id='user_login']");
    public static final By LOGIN_PAGE_PASSWORD_FIELD_LOCATOR = By.xpath("//*[@id='user_pass']");
    public static final By LOGIN_PAGE_REMEMBER_ME_CHECKBOX_LOCATOR = By.xpath("//*[@id='rememberme']");
    public static final By LOGIN_PAGE_LOG_IN_BUTTON_LOCATOR = By.xpath("//*[@id='wp-submit']");
    public static final By LOGIN_PAGE_INVALID_CREDS_ERROR_LOCATOR = By.xpath("//*[@id='login_error']");

    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_LOCATOR);
        return getWebDriver().findElements(LOGIN_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getLogger().info("Opening page " + this.getClass().getSimpleName());
        getWebDriver().get(LOGIN_PAGE_URL);
    }

    private void clickOnLoginButton() {
        getLogger().debug("Waiting for the login button to load");
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_LOG_IN_BUTTON_LOCATOR);
        getLogger().info("Clicking on the login button");
        getWebDriver().findElement(LOGIN_PAGE_LOG_IN_BUTTON_LOCATOR).click();
    }

    public void logInWithCredentials(String userName, String password) {
        getLogger().debug("Waiting for the credential fields loaded");
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_USERNAME_FIELD_LOCATOR);
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_PASSWORD_FIELD_LOCATOR);
        getLogger().info("Fill in the fields with credentials");
        getWebDriver().findElement(LOGIN_PAGE_USERNAME_FIELD_LOCATOR).sendKeys(userName);
        getWebDriver().findElement(LOGIN_PAGE_PASSWORD_FIELD_LOCATOR).sendKeys(password);
        clickOnLoginButton();
    }

    public boolean isUserLoggedInSuccessful() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDisplayed();
        return getWebDriver().findElements(HEADER_LOGGED_IN_LOCATOR).size() == 1;
    }

    public boolean isInvalidCredsErrorDisplayed() {
        getLogger().debug("Waiting for the invalid creds error displayed");
        List<WebElement> webElementList = WaitUtil.getWebElementsAfterFluentWait(LOGIN_PAGE_INVALID_CREDS_ERROR_LOCATOR);
        return webElementList.size() == 1;
    }
}
