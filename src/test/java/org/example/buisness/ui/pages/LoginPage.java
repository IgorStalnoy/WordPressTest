package org.example.buisness.ui.pages;

public interface LoginPage extends Page {
    void logInWithCredentials(String userName, String password);
    boolean isUserLoggedInSuccessful();
    boolean isInvalidCredsErrorDisplayed();
    void loginByAdmin();
}
