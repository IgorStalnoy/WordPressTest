package org.example.buisness.ui.pages.impl.desktop.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.entities.Post;
import org.example.buisness.ui.pages.PostsPage;
import org.example.buisness.ui.pages.impl.desktop.AdminPageDesktopImpl;
import org.example.buisness.ui.utils.WaitUtil;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

public class PostsPageDesktopImpl extends AdminPageDesktopImpl implements PostsPage {
    public static final By POSTS_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Posts')]");
    public static final By POSTS_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-list']/*");
    public static final By ADD_NEW_BUTTON_LOCATOR = By.xpath("//a[contains(text(),'Add New')][@class='page-title-action']");
    public static final By PUBLISH_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Publish')]");
    public static final By UPDATE_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Update')]");
    public static final By MOVE_TO_TRASH_BUTTON_LOCATOR = By.xpath("//button[contains(text(),'Move to trash')]");
    public static final By VIEW_POSTS_BUTTON_LOCATOR = By.xpath("//a[@aria-label='View Posts']");
    public static final By CREATE_NEW_POST_PAGE_LOCATOR = By.xpath("//*[contains(text(),'Add title')]");
    public static final By NEW_POST_TITLE_LOCATOR = By.xpath("//h1[@aria-label='Add title']");
    public static final By NEW_POST_BODY_LOCATOR = By.xpath("//p[@data-title='Paragraph']");
    public static final String POSTS_TABLE_ELEMENTS_BY_TITLE_PATTERN = "//*[contains(text(),'%s')]/../../..";
    public static final String POST_TITLE_PATTERN = "//*[@id='the-list']/*[%d]/*[contains(@class, 'title')]";
    public static final String POST_AUTHOR_PATTERN = "//*[@id='the-list']/*[%d]/*[contains(@class, 'author')]";
    public static final String POST_CATEGORY_PATTERN = "//*[@id='the-list']/*[%d]/*[contains(@class, 'categories')]";
    public static final String POST_TAG_PATTERN = "//*[@id='the-list']/*[%d]/*[contains(@class, 'tag')]";
    public static final String POST_COMMENT_PATTERN = "//*[@id='the-list']/*[%d]/*[contains(@class, 'comment')]";
    public static final String OPEN_POST_PATTERN = "//*[@id='the-list']/*/*[contains(@class,'title')]//a[contains(text(),'%s')]";
    public static final String POST_DATE_PATTERN = "//*[@id='the-list']/*[%d]/*[contains(@class, 'date')]";
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.POSTS;

    public PostsPageDesktopImpl() {
        super(new Header(), new SideMenu());
    }

    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(POSTS_PAGE_LOCATOR);
        return getWebDriver().findElements(POSTS_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getLogger().info("Opening page " + SIDE_MENU_ELEMENT.getValue());
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }

    @Override
    public boolean isPageEqualsHighlightedOnSideMenu() {
        return sideMenu().isCurrentPageEqualsHighlightedOnSideMenu(SIDE_MENU_ELEMENT);
    }

    @Override
    public Post getLastTableElement() {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table last element");
        return getTableElementsList().get(0);
    }

    @Override
    public List<WebElement> getTableElementsByTitle(String titleName) {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table elements by title");
        return getWebDriver().findElements(By.xpath(String.format(POSTS_TABLE_ELEMENTS_BY_TITLE_PATTERN, titleName)));
    }

    @Override
    public void clickOnAddNewButton() {
        getLogger().info("Click on Add new button");
        WaitUtil.waitUntilElementVisible(ADD_NEW_BUTTON_LOCATOR);
        WebElement addNewButton = Browser.getDriver().findElement(ADD_NEW_BUTTON_LOCATOR);
        addNewButton.click();
    }

    @Override
    public boolean isPostEditingPageDisplayed() {
        getLogger().debug("Waiting for the post editing page to load");
        WaitUtil.waitUntilElementVisible(CREATE_NEW_POST_PAGE_LOCATOR);
        return Browser.getDriver().findElements(CREATE_NEW_POST_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void fillInTestTextInNewPostTitle(String text) {
        Browser.getDriver().switchTo().defaultContent();
        WebElement frame = Browser.getDriver().findElement(By.tagName("iFrame"));
        Browser.getDriver().switchTo().frame(frame);
        getLogger().debug("Waiting for the title text area to load");
        WaitUtil.waitUntilElementVisible(NEW_POST_TITLE_LOCATOR);
        WebElement titleTextArea = Browser.getDriver().findElement(NEW_POST_TITLE_LOCATOR);
        titleTextArea.click();
        titleTextArea.clear();
        getLogger().info("Fill in " + text + " in title text area");
        titleTextArea.sendKeys(text);
    }

    @Override
    public void fillInTestTextInNewPostBody(String text) {
        WebElement webElement = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'is-root-container')]"));
        webElement.click();
        getLogger().debug("Waiting for the body text area to load");
        WaitUtil.waitUntilElementVisible(NEW_POST_BODY_LOCATOR);
        WebElement bodyTextArea = Browser.getDriver().findElement(NEW_POST_BODY_LOCATOR);
        bodyTextArea.click();
        bodyTextArea.sendKeys(Keys.CONTROL + "a");
        bodyTextArea.clear();
        getLogger().info("Fill in " + text + " in body text area");
        bodyTextArea.sendKeys(text);
    }

    @Override
    public void publishPost() {
        Browser.getDriver().switchTo().defaultContent();
        getLogger().debug("Waiting for the publish button to load");
        WaitUtil.waitUntilElementVisible(PUBLISH_BUTTON_LOCATOR);
        WebElement publishButton = Browser.getDriver().findElement(PUBLISH_BUTTON_LOCATOR);
        getLogger().info("Click on the publish button");
        publishButton.click();
    }

    @Override
    public void updatePost() {
        Browser.getDriver().switchTo().defaultContent();
        getLogger().debug("Waiting for the update button to load");
        WaitUtil.waitUntilElementVisible(UPDATE_BUTTON_LOCATOR);
        WebElement updateButton = Browser.getDriver().findElement(UPDATE_BUTTON_LOCATOR);
        getLogger().info("Click on the update button");
        updateButton.click();
    }

    @Override
    public void returnToPostsPage() {
        WaitUtil.waitUntilElementVisible(UPDATE_BUTTON_LOCATOR);
        getLogger().debug("Waiting for the view posts button to load");
        WaitUtil.waitUntilElementVisible(VIEW_POSTS_BUTTON_LOCATOR);
        WebElement viewPostsButton = Browser.getDriver().findElement(VIEW_POSTS_BUTTON_LOCATOR);
        getLogger().info("Click on the view posts button");
        viewPostsButton.click();
    }

    @Override
    public boolean isPostExist(String postTitle) {
        getLogger().debug("Verifying for the posts is exist");
        List<Post> postsList = getTableElementsList();
        return postsList.get(0).getTitle().equals(postTitle);
    }

    @Override
    public void openPostEditingPage(String titleName) {
        getLogger().debug("Waiting for the view posts editing page to load");
        WaitUtil.waitUntilElementVisible(POSTS_TABLE_ELEMENTS_LIST_LOCATOR);
        WebElement post = Browser.getDriver().findElement(By.xpath(String.format(OPEN_POST_PATTERN, titleName)));
        getLogger().info("Click on the posts title");
        post.click();
    }


    @Override
    public List<Post> getTableElementsList() {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table elements");
        List<WebElement> webElementList = getWebDriver().findElements(POSTS_TABLE_ELEMENTS_LIST_LOCATOR);
        return IntStream.rangeClosed(1, webElementList.size())
                .mapToObj(this::getPost)
                .toList();
    }

    @Override
    public void deletePost() {
        getLogger().debug("Waiting for the move to trash button to load");
        WaitUtil.waitUntilElementVisible(MOVE_TO_TRASH_BUTTON_LOCATOR);
        WebElement moveToTrashButton = Browser.getDriver().findElement(MOVE_TO_TRASH_BUTTON_LOCATOR);
        moveToTrashButton.click();
    }

    @Override
    public boolean isMenuDisplayedOnSideMenu() {
        return sideMenu().isMenuDisplayed(SIDE_MENU_ELEMENT);
    }

    private Post getPost(int position) {
        return Post.builder()
                .title(getPostElement(position, POST_TITLE_PATTERN))
                .author(getPostElement(position, POST_AUTHOR_PATTERN))
                .category(getPostElement(position, POST_CATEGORY_PATTERN))
                .tag(getPostElement(position, POST_TAG_PATTERN))
                .comment(getPostElement(position, POST_COMMENT_PATTERN))
                .date(getPostElement(position, POST_DATE_PATTERN))
                .build();
    }

    private String getPostElement(int position, String field) {
        String value = String.format(field, position);
        return Browser.getDriver().findElement(By.xpath(value)).getText();
    }


}
