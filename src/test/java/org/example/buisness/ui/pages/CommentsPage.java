package org.example.buisness.ui.pages;


import org.openqa.selenium.WebElement;

import java.util.List;

public interface CommentsPage extends Page {
    boolean isPageEqualsHighlightedOnSideMenu();

    List<WebElement> getTableElementsList();

    WebElement getLastTableElement();

    List<WebElement> getTableElementsByPostTitle(String titleName);
    boolean isMenuDisplayedOnSideMenu();
}
