package org.example.tests.ui;


import org.example.buisness.ui.pages.LoginPage;
import org.example.buisness.ui.pages.adminpages.DashboardPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogInTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeEach
    public void initLoginPage() {
        this.loginPage = new LoginPage();
    }

    @Test
    public void testLogInWithValidCredentials() {
        loginPage.openPage();
        loginPage.logInWithValidCredentials();
        Assertions.assertTrue(loginPage.isUserLoggedInSuccessful(), "User was not logged in after login with valid credentials");
    }

    @Test
    public void testLogInWithInvalidCredentials() {
        loginPage.openPage();
        loginPage.logInWithInvalidCredentials();
        Assertions.assertTrue(loginPage.isDisplayed(), "Login page is not displayed after login with invalid creds");
    }

    @Test
    public void testCheckForErrorMessageLogInWithInvalidCredentials() {
        loginPage.openPage();
        loginPage.logInWithInvalidCredentials();
        Assertions.assertTrue(loginPage.isInvalidCredsErrorDisplayed(), "Error message is not displayed after login with invalid creds");
    }

    @Test
    public void testUserRedirectedOnDashboardAfterLogIn() {
        loginPage.openPage();
        loginPage.logInWithValidCredentials();
        this.dashboardPage = new DashboardPage();
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
    }

    @Test
    public void testDashboardPageHighlightedOnSideMenuAfterLogIn() {
        loginPage.openPage();
        loginPage.logInWithValidCredentials();
        this.dashboardPage = new DashboardPage();
        Assertions.assertTrue(dashboardPage.isPageEqualsHighlightedOnSideMenu(), "Dashboard page was not highlighted after user logged in");
    }

    @Test
    public void testLoginPageDisplayedAfterLogout() {
        loginPage.openPage();
        loginPage.logInWithValidCredentials();
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
