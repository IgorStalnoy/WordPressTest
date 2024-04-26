package org.example.buisness.ui.utils;

import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {

    private static final int DEFAULT_FLUENT_WAIT_TIMEOUT = 5;
    private static final int DEFAULT_FLUENT_WAIT_POLLING = 2;

    public static void waitUntilElementVisible(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver()).
                withTimeout(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_TIMEOUT)).
                pollingEvery(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_POLLING)).
                ignoring(org.openqa.selenium.TimeoutException.class).
                ignoring(org.openqa.selenium.NoSuchElementException.class);
    }

    public static WebElement getWebElementAfterFluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver()).
                withTimeout(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_TIMEOUT)).
                pollingEvery(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_POLLING)).
                ignoring(org.openqa.selenium.TimeoutException.class).
                ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> getWebElementsAfterFluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(Browser.getDriver()).
                withTimeout(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_TIMEOUT)).
                pollingEvery(Duration.ofSeconds(DEFAULT_FLUENT_WAIT_POLLING)).
                ignoring(org.openqa.selenium.TimeoutException.class).
                ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
