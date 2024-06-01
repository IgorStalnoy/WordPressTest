package org.example.tests.ui;


import io.qameta.allure.Description;
import org.example.buisness.ui.pages.impl.desktop.adminpages.DashboardPageDesktopImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.example.buisness.ui.pages.impl.desktop.LoginPageDesktopImpl.*;

public class LogInTest extends BaseTest {
    @Test
    @Description("Test verifies the user logged in successful")
    public void testLogInWithValidCredentials() {
        loginPageDesktopImpl.openPage();
        loginPageDesktopImpl.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        Assertions.assertTrue(loginPageDesktopImpl.isUserLoggedInSuccessful(), "User was not logged in after login with valid credentials");
    }
    @Test
    @Description("Failed test")
    public void failedTest() {
        loginPageDesktopImpl.openPage();
        Assertions.assertTrue(false, "Custom failed test");
    }

    @Test
    @Description("Test verifies login page remains after login with invalid credentials")
    public void testLogInWithInvalidCredentials() {
        loginPageDesktopImpl.openPage();
        loginPageDesktopImpl.logInWithCredentials(INVALID_USERNAME, INVALID_PASSWORD);
        Assertions.assertTrue(loginPageDesktopImpl.isDisplayed(), "Login page is not displayed after login with invalid creds");
    }

    @Test
    @Description("Test verifies the error massage appeared opened after login with invalid credentials")
    public void testCheckForErrorMessageLogInWithInvalidCredentials() {
        loginPageDesktopImpl.openPage();
        loginPageDesktopImpl.logInWithCredentials(INVALID_USERNAME, INVALID_PASSWORD);
        Assertions.assertTrue(loginPageDesktopImpl.isInvalidCredsErrorDisplayed(), "Error message is not displayed after login with invalid creds");
    }

    @Test
    @Description("Test verifies the dashboard page opened after login")
    public void testUserRedirectedOnDashboardAfterLogIn() {
        loginPageDesktopImpl.openPage();
        loginPageDesktopImpl.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        initDashboardPage();
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
    }

    @Test
    @Description("Test verifies the dashboard page highlighted on side menu after login")
    public void testDashboardPageHighlightedOnSideMenuAfterLogIn() {
        loginPageDesktopImpl.openPage();
        loginPageDesktopImpl.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        initDashboardPage();
        Assertions.assertTrue(dashboardPage.isPageEqualsHighlightedOnSideMenu(), "Dashboard page was not highlighted after user logged in");
    }

    @Test
    @Description("Test verifies the login page opened after user logout")
    public void testLoginPageDisplayedAfterLogout() {
        loginPageDesktopImpl.openPage();
        loginPageDesktopImpl.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        initDashboardPage();
        dashboardPage.logOut();
        Assertions.assertTrue(loginPageDesktopImpl.isDisplayed(), "Login page is not displayed after logout");
    }

    @AfterEach
    public void cleanPages() {
        if (this.loginPageDesktopImpl != null) {
            this.loginPageDesktopImpl = null;
        }
        if (this.dashboardPage != null) {
            this.dashboardPage = null;
        }
    }

}
