package org.example.buisness.ui.pages.impl.mobile.adminpages;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.MediaPage;
import org.example.buisness.ui.pages.impl.mobile.AdminPageMobileImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MediaPageMobileImpl extends AdminPageMobileImpl implements MediaPage {
    @Override
    public boolean isPageEqualsHighlightedOnSideMenu() {
        return false;
    }

    @Override
    public List<WebElement> getTableElementsList() {
        return null;
    }

    @Override
    public WebElement getLastTableElement() {
        return null;
    }

    @Override
    public List<WebElement> getTableElementsByTitle(String titleName) {
        return null;
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
