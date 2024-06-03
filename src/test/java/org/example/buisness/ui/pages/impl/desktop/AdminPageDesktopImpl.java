package org.example.buisness.ui.pages.impl.desktop;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;

public abstract class AdminPageDesktopImpl extends PageDesktopImpl {


    private Header header;
    private SideMenu sideMenu;

    public AdminPageDesktopImpl(Header header, SideMenu sideMenu) {
        super();
        this.header = header;
        this.sideMenu = sideMenu;
    }

    public AdminPageDesktopImpl() {
    }

    public Header header() {
        return header;
    }

    public SideMenu sideMenu() {
        return sideMenu;
    }

    public void logOut() {
        header().logOut();
        setUserLoggedIn(false);
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setSideMenu(SideMenu sideMenu) {
        this.sideMenu = sideMenu;
    }

    public boolean isProfileDataEqualsUsersData(String firstName, String lastName) {
        return header.getLoggedUserDisplayName().equals(firstName + " " + lastName);
    }

}
