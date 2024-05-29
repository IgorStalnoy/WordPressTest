package org.example.buisness.ui.utils;

import org.apache.log4j.Logger;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {

    private static final Logger logger = Logger.getLogger(WaitUtil.class.getName());
    private static final int DEFAULT_FLUENT_WAIT_TIMEOUT = 5;
    private static final int DEFAULT_FLUENT_WAIT_POLLING = 2;

    public static void waitUntilElementVisible(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver()).
                withTimeout(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_TIMEOUT)).
                pollingEvery(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_POLLING));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            logger.trace("Expected element was found");
        } catch (TimeoutException | NoSuchElementException ex) {
            logger.warn("Expected element was not found");
        }
    }

    public static List<WebElement> getWebElementsAfterFluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver()).
                withTimeout(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_TIMEOUT)).
                pollingEvery(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_POLLING));
        List<WebElement> webElements = null;
        try {
            webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            logger.trace("Expected element was found");
        } catch (TimeoutException | NoSuchElementException ex) {
            logger.warn("No such elements were found");
        }
        return webElements;
    }
}
