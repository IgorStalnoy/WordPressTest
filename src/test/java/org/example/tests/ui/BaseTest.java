package org.example.tests.ui;

import org.apache.log4j.Logger;
import org.example.buisness.ui.pages.*;
import org.example.buisness.ui.pages.impl.desktop.LoginPageDesktopImpl;
import org.example.buisness.ui.pages.impl.desktop.MainPageDesktopImpl;
import org.example.buisness.ui.pages.impl.desktop.adminpages.*;
import org.example.buisness.ui.pages.impl.mobile.LoginPageMobileImpl;
import org.example.buisness.ui.pages.impl.mobile.MainPageMobileImpl;
import org.example.buisness.ui.pages.impl.mobile.adminpages.*;
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
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public CommentsPage commentsPage;
    public MainPage mainPage;
    public MediaPage mediaPage;
    public PagesPage pagesPage;
    public PostsPage postsPage;
    public UsersPage usersPage;

    @BeforeEach
    public void driverInitialize(TestInfo testInfo) {
        webDriver = Browser.getDriver();
        String testName = testInfo.getDisplayName().substring(0,testInfo.getDisplayName().length() - 2);
        logger.info("Starting test case \"" + testName + "\"");
        initPages();
    }

    @AfterEach
    public void cleanUp(TestInfo testInfo) {
        Browser.close();
        String testName = testInfo.getDisplayName().substring(0, testInfo.getDisplayName().length() - 2);
        logger.info("Test case \"" + testName + "\" finished\n");
    }
    public void initPages() {
        initMediaPage();
        initPostsPage();
        initCommentsPage();
        initMainPage();
        initDashboardPage();
        initLoginPage();
        initPagesPage();
        initUsersPage();
    }
    private void initCommentsPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            commentsPage = new CommentsPageDesktopImpl();
        } else {
            commentsPage = new CommentsPageMobileImpl();
        }
    }
    private void initDashboardPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            dashboardPage = new DashboardPageDesktopImpl();
        } else {
            dashboardPage = new DashboardPageMobileImpl();
        }
    }
    private void initLoginPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            loginPage = new LoginPageDesktopImpl();
        } else {
            loginPage = new LoginPageMobileImpl();
        }
    }
    private void initUsersPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            usersPage = new UsersPageDesktopImpl();
        } else {
            usersPage = new UsersPageMobileImpl();
        }
    }
    private void initMainPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            mainPage = new MainPageDesktopImpl();
        } else {
            mainPage = new MainPageMobileImpl();
        }
    }
    private void initMediaPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            mediaPage = new MediaPageDesktopImpl();
        } else {
            mediaPage = new MediaPageMobileImpl();
        }
    }
    private void initPagesPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            pagesPage = new PagesPageDesktopImpl();
        } else {
            pagesPage = new PagesPageMobileImpl();
        }
    }
    private void initPostsPage() {
        if(Browser.getDeviceType().equals(DevicesEnum.DESKTOP)) {
            postsPage = new PostsPageDesktopImpl();
        } else {
            postsPage = new PostsPageMobileImpl();
        }
    }

}
