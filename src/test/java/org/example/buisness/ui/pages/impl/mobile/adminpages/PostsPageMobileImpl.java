package org.example.buisness.ui.pages.impl.mobile.adminpages;

import org.apache.log4j.Logger;
import org.example.buisness.ui.entities.Post;
import org.example.buisness.ui.pages.PostsPage;
import org.example.buisness.ui.pages.impl.mobile.AdminPageMobileImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostsPageMobileImpl extends AdminPageMobileImpl implements PostsPage {
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
    public boolean isPageEqualsHighlightedOnSideMenu() {
        return false;
    }

    @Override
    public List<Post> getTableElementsList() {
        return null;
    }

    @Override
    public Post getLastTableElement() {
        return null;
    }

    @Override
    public List<WebElement> getTableElementsByTitle(String titleName) {
        return null;
    }

    @Override
    public void clickOnAddNewButton() {

    }

    @Override
    public boolean isPostEditingPageDisplayed() {
        return false;
    }

    @Override
    public void fillInTestTextInNewPostTitle(String text) {

    }

    @Override
    public void fillInTestTextInNewPostBody(String text) {

    }


    @Override
    public void publishPost() {

    }

    @Override
    public void updatePost() {

    }

    @Override
    public void returnToPostsPage() {

    }

    @Override
    public boolean isPostExist(String postTitle) {
        return false;
    }

    @Override
    public void openPostEditingPage(String titleName) {

    }

    @Override
    public void deletePost() {

    }

    @Override
    public boolean isMenuDisplayedOnSideMenu() {
        return false;
    }


}
