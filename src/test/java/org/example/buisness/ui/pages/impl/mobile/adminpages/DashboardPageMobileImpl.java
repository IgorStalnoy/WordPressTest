package org.example.buisness.ui.pages.impl.mobile.adminpages;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.DashboardPage;
import org.example.buisness.ui.pages.impl.mobile.AdminPageMobileImpl;
import org.openqa.selenium.WebDriver;

public class DashboardPageMobileImpl extends AdminPageMobileImpl implements DashboardPage {
    @Override
    public boolean isPageEqualsHighlightedOnSideMenu() {
        return false;
    }

    @Override
    public void logOut() {

    }

    @Override
    public boolean isProfileDataEqualsUsersData(String firstName, String lastName) {
        return false;
    }

    @Override
    public boolean isMenuDisplayedOnSideMenu() {
        return false;
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
