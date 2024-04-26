package org.example.buisness.ui.pages;

import org.example.buisness.ui.pages.adminpages.DashboardPage;
import org.example.buisness.ui.utils.WaitUtil;
import static org.example.buisness.ui.utils.Constants.*;

public class LoginPage extends Page {

    @Override
    public boolean isDisplayed() {
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_LOCATOR);
        return getWebDriver().findElements(LOGIN_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getWebDriver().get(LOGIN_PAGE_URL);
    }
    private void clickOnLoginButton() {
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_LOG_IN_BUTTON_LOCATOR);
        getWebDriver().findElement(LOGIN_PAGE_LOG_IN_BUTTON_LOCATOR).click();
    }

    public void logInWithValidCredentials() {
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_USERNAME_FIELD_LOCATOR);
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_PASSWORD_FIELD_LOCATOR);
        getWebDriver().findElement(LOGIN_PAGE_USERNAME_FIELD_LOCATOR).sendKeys(LOGIN_USERNAME);
        getWebDriver().findElement(LOGIN_PAGE_PASSWORD_FIELD_LOCATOR).sendKeys(LOGIN_PASSWORD);
        clickOnLoginButton();
        setUserLoggedIn(true);
    }

    public void logInWithInvalidCredentials() {
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_USERNAME_FIELD_LOCATOR);
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_PASSWORD_FIELD_LOCATOR);
        getWebDriver().findElement(LOGIN_PAGE_USERNAME_FIELD_LOCATOR).sendKeys("Invalid username");
        getWebDriver().findElement(LOGIN_PAGE_PASSWORD_FIELD_LOCATOR).sendKeys("Invalid password");
        clickOnLoginButton();
    }
    public boolean isUserLoggedInSuccessful() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.isDisplayed();
        return getWebDriver().findElements(HEADER_LOGGED_IN_LOCATOR).size() == 1;
    }

    public boolean isInvalidCredsErrorDisplayed() {
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_INVALID_CREDS_ERROR_LOCATOR);
        return getWebDriver().findElements(LOGIN_PAGE_INVALID_CREDS_ERROR_LOCATOR).size() == 1;
    }
}
