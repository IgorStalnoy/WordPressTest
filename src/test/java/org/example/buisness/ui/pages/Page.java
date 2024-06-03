package org.example.buisness.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public interface Page {

    WebDriver getWebDriver();

    boolean isDisplayed();

    void openPage();

    boolean isUserLoggedIn();

    void setUserLoggedIn(boolean userLoggedIn);

    Logger getLogger();

}
