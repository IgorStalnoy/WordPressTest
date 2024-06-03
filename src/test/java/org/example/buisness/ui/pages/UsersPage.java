package org.example.buisness.ui.pages;

import org.example.buisness.ui.entities.User;
import org.example.buisness.ui.entities.UsersRolesEnum;

public interface UsersPage extends Page {
    void openAddNewUserPage();

    boolean isAddNewUserPageDisplayed();

    String generateNewUserName(String baseName);

    void fillInNewUserFields(User newUser);

    User getNewUser(String name, String password, UsersRolesEnum role);
    String getRecommendedPassword();
    void createUser();
    void logOut();
}
