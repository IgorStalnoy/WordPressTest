package org.example.tests.ui;

import org.apache.log4j.Logger;
import org.example.buisness.ui.webdriver.Browser;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

@ExtendWith(CustomListener.class)
public abstract class BaseTest {
    @Rule
    public TestName name = new TestName();
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    static WebDriver webDriver;

    @BeforeEach
    public void driverInitialize(TestInfo testInfo) {
        webDriver = Browser.getDriver();
        String testName = testInfo.getDisplayName().substring(0,testInfo.getDisplayName().length() - 2);
        logger.info("Starting test case \"" + testName + "\"");

    }

    @AfterEach
    public void cleanUp(TestInfo testInfo) {
        Browser.close();
        String testName = testInfo.getDisplayName().substring(0,testInfo.getDisplayName().length() - 2);
        logger.info("Test case \"" + testName + "\" finished\n");
    }
}
