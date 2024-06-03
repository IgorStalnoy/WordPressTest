package org.example.buisness.ui.pages.impl.mobile;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageMobileImpl extends AdminPageMobileImpl implements MainPage {
    @Override
    public List<WebElement> getPageElementsList() {
        return null;
    }

    @Override
    public void openPageByName(String pageName) {

    }

    @Override
    public List<WebElement> getPostsElementsList() {
        return null;
    }

    @Override
    public void openPostByName(String pageName) {

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
