package org.example.tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.buisness.ui.entities.User;
import org.example.buisness.ui.entities.UsersRolesEnum;
import org.example.buisness.ui.utils.Configuration;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRegistrationTest extends BaseTest {
    public static final String BASE_NEW_USER_NAME = "IgorTest";
    public static final String CONTRIBUTOR_USERNAME = Configuration.getProperties().getProperty("contributorusername");
    public static final String CONTRIBUTOR_PASSWORD = Configuration.getProperties().getProperty("contributorpassword");
    public static final String EDITOR_USERNAME = Configuration.getProperties().getProperty("editorusername");
    public static final String EDITOR_PASSWORD = Configuration.getProperties().getProperty("editorpassword");
    public static final String SUBSCRIBER_USERNAME = Configuration.getProperties().getProperty("subscriberusername");
    public static final String SUBSCRIBER_PASSWORD = Configuration.getProperties().getProperty("subscriberpassword");

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(1)
    @Description("Test verifies user with contributor role can register")
    public void testRegisterNewContributorUser() {
        loginPage.loginByAdmin();
        usersPage.openPage();
        Assertions.assertTrue(usersPage.isDisplayed(), "Users page not displayed after click on page button");
        usersPage.openAddNewUserPage();
        Assertions.assertTrue(usersPage.isAddNewUserPageDisplayed(), "New users page not displayed after click on the add new button");
        String newUserName = usersPage.generateNewUserName(BASE_NEW_USER_NAME);
        String newPassword = usersPage.getRecommendedPassword();
        User newUser = usersPage.getNewUser(newUserName, newPassword, UsersRolesEnum.CONTRIBUTOR);
        usersPage.fillInNewUserFields(newUser);
        usersPage.createUser();
        Assertions.assertTrue(usersPage.isDisplayed(), "Users page not displayed after new user creation");
        usersPage.logOut();
        Assertions.assertTrue(loginPage.isDisplayed(), "Login page is not displayed after logout");
        loginPage.logInWithCredentials(newUser.getUsername(), newUser.getPassword());
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
        Assertions.assertTrue(dashboardPage.isProfileDataEqualsUsersData(newUser.getFirstName(), newUser.getLastName()), "User profile data not equals as registered user");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(2)
    @Description("Test verifies user with editor role can register")
    public void testRegisterNewEditorUser() {
        loginPage.loginByAdmin();
        usersPage.openPage();
        Assertions.assertTrue(usersPage.isDisplayed(), "Users page not displayed after click on page button");
        usersPage.openAddNewUserPage();
        Assertions.assertTrue(usersPage.isAddNewUserPageDisplayed(), "New users page not displayed after click on the add new button");
        String newUserName = usersPage.generateNewUserName(BASE_NEW_USER_NAME);
        String newPassword = usersPage.getRecommendedPassword();
        User newUser = usersPage.getNewUser(newUserName, newPassword, UsersRolesEnum.EDITOR);
        usersPage.fillInNewUserFields(newUser);
        usersPage.createUser();
        Assertions.assertTrue(usersPage.isDisplayed(), "Users page not displayed after new user creation");
        usersPage.logOut();
        Assertions.assertTrue(loginPage.isDisplayed(), "Login page is not displayed after logout");
        loginPage.logInWithCredentials(newUser.getUsername(), newUser.getPassword());
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
        Assertions.assertTrue(dashboardPage.isProfileDataEqualsUsersData(newUser.getFirstName(), newUser.getLastName()), "User profile data not equals as registered user");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(3)
    @Description("Test verifies user with subscriber role can register")
    public void testRegisterNewSubscriberUser() {
        loginPage.loginByAdmin();
        usersPage.openPage();
        Assertions.assertTrue(usersPage.isDisplayed(), "Users page not displayed after click on page button");
        usersPage.openAddNewUserPage();
        Assertions.assertTrue(usersPage.isAddNewUserPageDisplayed(), "New users page not displayed after click on the add new button");
        String newUserName = usersPage.generateNewUserName(BASE_NEW_USER_NAME);
        String newPassword = usersPage.getRecommendedPassword();
        User newUser = usersPage.getNewUser(newUserName, newPassword, UsersRolesEnum.SUBSCRIBER);
        usersPage.fillInNewUserFields(newUser);
        usersPage.createUser();
        Assertions.assertTrue(usersPage.isDisplayed(), "Users page not displayed after new user creation");
        usersPage.logOut();
        Assertions.assertTrue(loginPage.isDisplayed(), "Login page is not displayed after logout");
        loginPage.logInWithCredentials(newUser.getUsername(), newUser.getPassword());
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
        Assertions.assertTrue(dashboardPage.isProfileDataEqualsUsersData(newUser.getFirstName(), newUser.getLastName()), "User profile data not equals as registered user");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(4)
    @Description("Test verifies user with contributor role view pages suitable with his permissions")
    public void testContributorUserPermissions() {
        loginPage.openPage();
        loginPage.logInWithCredentials(CONTRIBUTOR_USERNAME, CONTRIBUTOR_PASSWORD);
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
        Assertions.assertAll(
                () -> Assertions.assertTrue(dashboardPage.isMenuDisplayedOnSideMenu(), "Dashboard page is not displayed for with suitable permission"),
                () -> Assertions.assertTrue(postsPage.isMenuDisplayedOnSideMenu(), "Posts page page is not displayed for with suitable permission"),
                () -> Assertions.assertTrue(commentsPage.isMenuDisplayedOnSideMenu(), "Comments page page is not displayed for with suitable permission"),
                () -> Assertions.assertFalse(pagesPage.isMenuDisplayedOnSideMenu(), "Pages page page should not be displayed for user with suitable permission"),
                () -> Assertions.assertFalse(mediaPage.isMenuDisplayedOnSideMenu(), "Media page page should not be displayed for user with suitable permission")
        );
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(5)
    @Description("Test verifies user with editor role view pages suitable with his permissions")
    public void testEditorUserPermissions() {
        loginPage.openPage();
        loginPage.logInWithCredentials(EDITOR_USERNAME, EDITOR_PASSWORD);
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
        Assertions.assertAll(
                () -> Assertions.assertTrue(dashboardPage.isMenuDisplayedOnSideMenu(), "Dashboard page is not displayed for with suitable permission"),
                () -> Assertions.assertTrue(postsPage.isMenuDisplayedOnSideMenu(), "Posts page page is not displayed for with suitable permission"),
                () -> Assertions.assertTrue(commentsPage.isMenuDisplayedOnSideMenu(), "Comments page page is not displayed for with suitable permission"),
                () -> Assertions.assertTrue(pagesPage.isMenuDisplayedOnSideMenu(), "Pages page page should not be displayed for user with suitable permission"),
                () -> Assertions.assertTrue(mediaPage.isMenuDisplayedOnSideMenu(), "Media page page should not be displayed for user with suitable permission")
        );
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(6)
    @Description("Test verifies user with subscriber role view pages suitable with his permissions")
    public void testSubscriberUserPermissions() {
        loginPage.openPage();
        loginPage.logInWithCredentials(SUBSCRIBER_USERNAME, SUBSCRIBER_PASSWORD);
        Assertions.assertTrue(dashboardPage.isDisplayed(), "User was not redirected on the dashboard page after log in with valid credentials");
        Assertions.assertAll(
                () -> Assertions.assertTrue(dashboardPage.isMenuDisplayedOnSideMenu(), "Dashboard page is not displayed for with suitable permission"),
                () -> Assertions.assertFalse(postsPage.isMenuDisplayedOnSideMenu(), "Posts page page is not displayed for with suitable permission"),
                () -> Assertions.assertFalse(commentsPage.isMenuDisplayedOnSideMenu(), "Comments page page is not displayed for with suitable permission"),
                () -> Assertions.assertFalse(pagesPage.isMenuDisplayedOnSideMenu(), "Pages page page should not be displayed for user with suitable permission"),
                () -> Assertions.assertFalse(mediaPage.isMenuDisplayedOnSideMenu(), "Media page page should not be displayed for user with suitable permission")
        );
    }

}
