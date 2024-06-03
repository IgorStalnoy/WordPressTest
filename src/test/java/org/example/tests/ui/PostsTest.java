package org.example.tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostsTest extends BaseTest {

    public static final String NEW_POST_TITLE_TEXT = "Igor autotest new post title";
    public static final String NEW_POST_BODY_TEXT = "Igor autotest new post body";
    public static final String UPDATED_POST_TITLE_TEXT = "Igor autotest updated post title";
    public static final String UPDATED_POST_BODY_TEXT = "Igor autotest updated post body";

    @BeforeEach
    public void loginByAdmin() {
        loginPage.loginByAdmin();
    }

    @Test
    @Order(1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test verifies post can be added")
    public void testPostCanBeAdded() {
        postsPage.openPage();
        postsPage.clickOnAddNewButton();
        Assertions.assertTrue(postsPage.isPostEditingPageDisplayed(), "Create new post page not displayed after click on Add New button");
        postsPage.fillInTestTextInNewPostTitle(NEW_POST_TITLE_TEXT);
        postsPage.fillInTestTextInNewPostBody(NEW_POST_BODY_TEXT);
        postsPage.publishPost();
        postsPage.returnToPostsPage();
        Assertions.assertTrue(postsPage.isDisplayed(), "Posts page is not displayed after return from add new post page");
        Assertions.assertTrue(postsPage.isPostExist(NEW_POST_TITLE_TEXT), "New post not displayed in the posts table");
    }

    @Test
    @Order(2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test verifies post can be updated")
    public void testPostCanBeUpdated() {
        postsPage.openPage();
        postsPage.openPostEditingPage(NEW_POST_TITLE_TEXT);
        Assertions.assertTrue(postsPage.isPostEditingPageDisplayed(), "Update post page not displayed after click on Add New button");
        postsPage.fillInTestTextInNewPostTitle(UPDATED_POST_TITLE_TEXT);
        postsPage.fillInTestTextInNewPostBody(UPDATED_POST_BODY_TEXT);
        postsPage.updatePost();
        postsPage.returnToPostsPage();
        Assertions.assertTrue(postsPage.isDisplayed(), "Posts page is not displayed after return from update post page");
        Assertions.assertTrue(postsPage.isPostExist(UPDATED_POST_TITLE_TEXT), "Updated post not displayed in the posts table");
    }

    @Test
    @Order(3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test verifies post can be deleted")
    public void testPostCanBeDeleted() {
        postsPage.openPage();
        postsPage.openPostEditingPage(UPDATED_POST_TITLE_TEXT);
        Assertions.assertTrue(postsPage.isPostEditingPageDisplayed(), "Update post page not displayed after click on Add New button");
        postsPage.deletePost();
        Assertions.assertTrue(postsPage.isDisplayed(), "Posts page is not displayed after post delete");
        Assertions.assertFalse(postsPage.isPostExist(UPDATED_POST_TITLE_TEXT), "Updated post not displayed in the posts table");
    }
}
