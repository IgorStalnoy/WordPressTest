package org.example.buisness.ui.pages;

public interface DashboardPage extends Page {
    boolean isPageEqualsHighlightedOnSideMenu();
    void logOut();
    boolean isProfileDataEqualsUsersData(String firstName, String lastName);
    boolean isMenuDisplayedOnSideMenu();

}
