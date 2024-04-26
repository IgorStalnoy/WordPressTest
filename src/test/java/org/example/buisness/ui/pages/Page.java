package org.example.buisness.ui.pages;

import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    private final WebDriver webDriver;
    private boolean isUserLoggedIn;

    public Page() {
        this.webDriver = Browser.getDriver();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public abstract boolean isDisplayed();

    public abstract void openPage();

    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }
}