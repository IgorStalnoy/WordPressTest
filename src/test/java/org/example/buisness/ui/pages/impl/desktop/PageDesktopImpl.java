package org.example.buisness.ui.pages.impl.desktop;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.Page;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.WebDriver;

public abstract class PageDesktopImpl implements Page {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final WebDriver webDriver;
    private boolean isUserLoggedIn;

    public PageDesktopImpl() {
        this.webDriver = Browser.getDriver();
        logger.trace("Init elements of the page");
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }

    public Logger getLogger() {
        return logger;
    }
}