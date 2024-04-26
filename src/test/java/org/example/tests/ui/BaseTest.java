package org.example.tests.ui;

import org.example.buisness.ui.webdriver.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    static WebDriver webDriver;

    @BeforeEach
    public void driverInitialize() {
        webDriver = Browser.getDriver();
    }

    @AfterEach
    public void cleanUp() {
        Browser.close();
    }
}
