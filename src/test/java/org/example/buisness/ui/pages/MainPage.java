package org.example.buisness.ui.pages;


import org.openqa.selenium.WebElement;

import java.util.List;


public interface MainPage extends Page {
    List<WebElement> getPageElementsList();

    void openPageByName(String pageName);

    List<WebElement> getPostsElementsList();

    void openPostByName(String pageName);
}
