package org.example.buisness.ui.pages.impl.desktop;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.pages.MainPage;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.buisness.ui.utils.Constants.MAIN_URL;

public class MainPageDesktopImpl extends AdminPageDesktopImpl implements MainPage {
    public static final By MAIN_PAGE_LOCATOR = By.xpath("//h1[@class='wp-block-site-title']");
    public static final By MAIN_PAGE_PAGES_LIST_LOCATOR = By.xpath("//*[@class='wp-block-page-list']/*");
    public static final String MAIN_PAGE_PAGES_PATTERN = "//*[@class='wp-block-page-list']//*[contains(text(),'%s')]";
    public static final By MAIN_PAGE_POSTS_LIST_LOCATOR = By.xpath("//ul[contains(@class, 'alignwide wp-block')]/*");
    public static final String MAIN_PAGE_POSTS_PATTERN = "//ul[contains(@class, 'alignwide wp-block')]//*[contains(text(),'%s')]";

    public MainPageDesktopImpl() {
        super();
        if (isUserLoggedIn()) {
            setHeader(new Header());
            setSideMenu(new SideMenu());
        }
    }

    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(MAIN_PAGE_LOCATOR);
        return getWebDriver().findElements(MAIN_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getLogger().info("Opening page " + this.getClass().getSimpleName());
        getWebDriver().get(MAIN_URL);
    }

    @Override
    public List<WebElement> getPageElementsList() {
        getLogger().debug("Waiting for the main page pages are displayed");
        return WaitUtil.getWebElementsAfterFluentWait(MAIN_PAGE_PAGES_LIST_LOCATOR);
    }

    @Override
    public void openPageByName(String pageName) {
        By elementLocator = By.xpath(String.format(MAIN_PAGE_PAGES_PATTERN, pageName));
        getLogger().debug("Waiting for the " + pageName + " is displayed");
        WaitUtil.waitUntilElementVisible(elementLocator);
        WebElement page = getWebDriver().findElement(elementLocator);
        getLogger().info("Clicking on the " + pageName + " icon");
        page.click();
    }

    @Override
    public List<WebElement> getPostsElementsList() {
        getLogger().debug("Waiting for the main page posts are displayed");
        return WaitUtil.getWebElementsAfterFluentWait(MAIN_PAGE_POSTS_LIST_LOCATOR);
    }

    @Override
    public void openPostByName(String pageName) {
        By elementLocator = By.xpath(String.format(MAIN_PAGE_POSTS_PATTERN, pageName));
        getLogger().debug("Waiting for the " + pageName + " is displayed");
        WaitUtil.waitUntilElementVisible(elementLocator);
        WebElement page = getWebDriver().findElement(elementLocator);
        getLogger().info("Clicking on the " + pageName + " icon");
        page.click();
    }

}
