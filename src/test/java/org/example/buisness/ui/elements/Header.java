package org.example.buisness.ui.elements;

import org.example.buisness.ui.utils.WaitUtil;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.example.buisness.ui.utils.Constants.*;

public class Header {
    private final WebDriver webDriver;
    public Header() {
        this.webDriver = Browser.getDriver();
    }
    public void logOut() {
        WaitUtil.waitUntilElementVisible(HEADER_LOGGED_IN_LOCATOR);
        WebElement userProfileName = webDriver.findElement(HEADER_LOGGED_IN_LOCATOR);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(userProfileName).build().perform();
        WaitUtil.waitUntilElementVisible(HEADER_LOG_OUT_BUTTON_LOCATOR);
        WebElement logOutButton = webDriver.findElement(HEADER_LOG_OUT_BUTTON_LOCATOR);
        logOutButton.click();
        WaitUtil.waitUntilElementVisible(LOGIN_PAGE_LOCATOR);

    }
}
