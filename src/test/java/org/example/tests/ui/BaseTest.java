package org.example.tests.ui;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.DashboardPage;
import org.example.buisness.ui.pages.LoginPage;
import org.example.buisness.ui.pages.impl.desktop.LoginPageDesktopImpl;
import org.example.buisness.ui.pages.impl.desktop.adminpages.DashboardPageDesktopImpl;
import org.example.buisness.ui.webdriver.Browser;
import org.example.buisness.ui.webdriver.DevicesEnum;
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
    public LoginPage loginPageDesktopImpl;
    public DashboardPage dashboardPage;

    @BeforeEach
    public void driverInitialize(TestInfo testInfo) {
        webDriver = Browser.getDriver();
        String testName = testInfo.getDisplayName().substring(0,testInfo.getDisplayName().length() - 2);
        logger.info("Starting test case \"" + testName + "\"");
    }

    @BeforeEach
    public void initLoginPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            this.loginPageDesktopImpl = new LoginPageDesktopImpl();
        }
    }
    public void initDashboardPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            this.dashboardPage = new DashboardPageDesktopImpl();
        }
    }


    @AfterEach
    public void cleanUp(TestInfo testInfo) {
        Browser.close();
        String testName = testInfo.getDisplayName().substring(0,testInfo.getDisplayName().length() - 2);
        logger.info("Test case \"" + testName + "\" finished\n");
    }
}
