package org.example.buisness.ui.pages.impl.mobile.adminpages;

import org.apache.log4j.Logger;
import org.example.buisness.ui.entities.User;
import org.example.buisness.ui.entities.UsersRolesEnum;
import org.example.buisness.ui.pages.UsersPage;
import org.example.buisness.ui.pages.impl.mobile.AdminPageMobileImpl;
import org.openqa.selenium.WebDriver;

public class UsersPageMobileImpl extends AdminPageMobileImpl implements UsersPage {
    @Override
    public WebDriver getWebDriver() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public void openPage() {

    }

    @Override
    public boolean isUserLoggedIn() {
        return false;
    }

    @Override
    public void setUserLoggedIn(boolean userLoggedIn) {

    }

    @Override
    public Logger getLogger() {
        return null;
    }


    @Override
    public void openAddNewUserPage() {

    }

    @Override
    public boolean isAddNewUserPageDisplayed() {
        return false;
    }

    @Override
    public String generateNewUserName(String baseName) {
        return null;
    }

    @Override
    public void fillInNewUserFields(User newUser) {

    }

    @Override
    public User getNewUser(String name, String password, UsersRolesEnum role) {
        return null;
    }

    @Override
    public String getRecommendedPassword() {
        return null;
    }

    @Override
    public void createUser() {

    }

    @Override
    public void logOut() {

    }
}
