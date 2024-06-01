package org.example.buisness.ui.elements;

import org.example.buisness.ui.utils.WaitUtil;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.example.buisness.ui.pages.impl.desktop.LoginPageDesktopImpl.LOGIN_PAGE_LOCATOR;

public class Header extends Element {
    public static final By HEADER_LOGGED_IN_LOCATOR = By.xpath("//*[contains(text(),'Howdy, ')]");
    public static final By HEADER_LOG_OUT_BUTTON_LOCATOR = By.xpath("//li/a[contains(text(),'Log Out')]");
    private final WebDriver webDriver;
    public Header() {
        this.webDriver = Browser.getDriver();
    }
    public void logOut() {
        getLogger().debug("Wait for the user profile icon is displayed");
        WaitUtil.waitUntilElementVisible(HEADER_LOGGED_IN_LOCATOR);
        WebElement userProfileName = webDriver.findElement(HEADER_LOGGED_IN_LOCATOR);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(userProfileName).build().perform();
        getLogger().debug("Wait for the log out button is displayed");
        WaitUtil.waitUntilElementVisible(HEADER_LOG_OUT_BUTTON_LOCATOR);
        WebElement logOutButton = webDriver.findElement(HEADER_LOG_OUT_BUTTON_LOCATOR);
        getLogger().info("Clicking on the log out button");
        logOutButton.click();
        getLogger().debug("Wait for the login page is opened");
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_LOCATOR);
    }
}
