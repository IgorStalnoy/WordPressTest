package org.example.tests.ui;


import io.qameta.allure.Description;
import org.example.buisness.ui.pages.LoginPage;
import org.example.buisness.ui.pages.adminpages.DashboardPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.buisness.ui.pages.LoginPage.*;

public class LogInTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeEach
    public void initLoginPage() {
        this.loginPage = new LoginPage();
    }


    @Test
    @Description("Test verifies the user logged in successful")
    public void testLogInWithValidCredentials() {
        loginPage.openPage();
        loginPage.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        Assertions.assertTrue(loginPage.isUserLoggedInSuccessful(), "User was not logged in after login with valid credentials");
    }

    @Test
    @Description("Test verifies login page remains after login with invalid credentials")
    public void testLogInWithInvalidCredentials() {
        loginPage.openPage();
        loginPage.logInWithCredentials(INVALID_USERNAME, INVALID_PASSWORD);
        Assertions.assertTrue(loginPage.isDisplayed(), "Login page is not displayed after login with invalid creds");
    }

    @Test
    @Description("Test verifies the error massage appeared opened after login with invalid credentials")
    public void testCheckForErrorMessageLogInWithInvalidCredentials() {
        loginPage.openPage();
        loginPage.logInWithCredentials(INVALID_USERNAME, INVALID_PASSWORD);
        Assertions.assertTrue(loginPage.isInvalidCredsErrorDisplayed(), "Error message is not displayed after login with invalid creds");
    }

    @Test
    @Description("Test verifies the dashboard page opened after login")
    public void testUserRedirectedOnDashboardAfterLogIn() {
        loginPage.openPage();
        loginPage.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        this.dashboardPage = new DashboardPage();
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
    }

    @Test
    @Description("Test verifies the dashboard page highlighted on side menu after login")
    public void testDashboardPageHighlightedOnSideMenuAfterLogIn() {
        loginPage.openPage();
        loginPage.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        this.dashboardPage = new DashboardPage();
        Assertions.assertTrue(dashboardPage.isPageEqualsHighlightedOnSideMenu(), "Dashboard page was not highlighted after user logged in");
    }

    @Test
    @Description("Test verifies the login page opened after user logout")
    public void testLoginPageDisplayedAfterLogout() {
        loginPage.openPage();
        loginPage.logInWithCredentials(VALID_USERNAME, VALID_PASSWORD);
        this.dashboardPage = new DashboardPage();
        dashboardPage.logOut();
        Assertions.assertTrue(loginPage.isDisplayed(), "Login page is not displayed after logout");
    }

    @AfterEach
    public void cleanPages() {
        if (this.loginPage != null) {
            this.loginPage = null;
        }
        if (this.dashboardPage != null) {
            this.dashboardPage = null;
        }
    }

}
