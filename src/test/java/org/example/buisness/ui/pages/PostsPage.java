package org.example.buisness.ui.pages;

import org.example.buisness.ui.entities.Post;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface PostsPage extends Page {

    boolean isPageEqualsHighlightedOnSideMenu();

    List<Post> getTableElementsList();

    Post getLastTableElement();

    List<WebElement> getTableElementsByTitle(String titleName);
    void clickOnAddNewButton();
    boolean isPostEditingPageDisplayed();
    void fillInTestTextInNewPostTitle(String text);
    void fillInTestTextInNewPostBody(String text);
    void publishPost();
    void updatePost();
    void returnToPostsPage();
    boolean isPostExist(String postTitle);
    void openPostEditingPage(String titleName);
    void deletePost();
    boolean isMenuDisplayedOnSideMenu();

}
