package org.example.buisness.ui.pages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;

public abstract class AdminPage extends Page {

    private Header header;
    private SideMenu sideMenu;

    public AdminPage(Header header, SideMenu sideMenu) {
        super();
        this.header = header;
        this.sideMenu = sideMenu;
    }

    public AdminPage() {
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
}
