package org.example.buisness.ui.pages.impl.mobile;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageMobileImpl extends PageMobileImpl implements LoginPage {
    @Override
    public void logInWithCredentials(String userName, String password) {

    }

    @Override
    public boolean isUserLoggedInSuccessful() {
        return false;
    }

    @Override
    public boolean isInvalidCredsErrorDisplayed() {
        return false;
    }

    @Override
    public void loginByAdmin() {

    }

    @Override
    public WebDriver getWebDriver() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public void openPage() {

    }

    @Override
    public boolean isUserLoggedIn() {
        return false;
    }

    @Override
    public void setUserLoggedIn(boolean userLoggedIn) {

    }

    @Override
    public Logger getLogger() {
        return null;
    }
}
