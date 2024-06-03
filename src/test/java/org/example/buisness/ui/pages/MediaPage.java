package org.example.buisness.ui.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface MediaPage extends Page {
    boolean isPageEqualsHighlightedOnSideMenu();

    List<WebElement> getTableElementsList();

    WebElement getLastTableElement();

    List<WebElement> getTableElementsByTitle(String titleName);
    boolean isMenuDisplayedOnSideMenu();
}
