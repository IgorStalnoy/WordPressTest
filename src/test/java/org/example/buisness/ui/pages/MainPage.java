package org.example.buisness.ui.pages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.buisness.ui.utils.Constants.MAIN_URL;

public class MainPage extends AdminPage {
    public static final By MAIN_PAGE_LOCATOR = By.xpath("//h1[@class='wp-block-site-title']");
    public static final By MAIN_PAGE_PAGES_LIST_LOCATOR = By.xpath("//*[@class='wp-block-page-list']/*");
    public static final String MAIN_PAGE_PAGES_PATTERN = "//*[@class='wp-block-page-list']//*[contains(text(),'%s')]";
    public static final By MAIN_PAGE_POSTS_LIST_LOCATOR = By.xpath("//ul[contains(@class, 'alignwide wp-block')]/*");
    public static final String MAIN_PAGE_POSTS_PATTERN = "//ul[contains(@class, 'alignwide wp-block')]//*[contains(text(),'%s')]";

    public MainPage() {
        super();
        if (isUserLoggedIn()) {
            setHeader(new Header());
            setSideMenu(new SideMenu());
        }
    }

    @Override
    public boolean isDisplayed() {
        WaitUtil.waitUntilElementVisible(MAIN_PAGE_LOCATOR);
        return getWebDriver().findElements(MAIN_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getWebDriver().get(MAIN_URL);
    }

    public List<WebElement> getPageElementsList() {
        return getWebDriver().findElements(MAIN_PAGE_PAGES_LIST_LOCATOR);
    }

    public void openPageByName(String pageName) {
        By elementLocator = By.xpath(String.format(MAIN_PAGE_PAGES_PATTERN, pageName));
        WaitUtil.waitUntilElementVisible(elementLocator);
        WebElement page = getWebDriver().findElement(elementLocator);
        page.click();
    }

    public List<WebElement> getPostsElementsList() {
        return getWebDriver().findElements(MAIN_PAGE_POSTS_LIST_LOCATOR);
    }

    public void openPostByName(String pageName) {
        By elementLocator = By.xpath(String.format(MAIN_PAGE_POSTS_PATTERN, pageName));
        WaitUtil.waitUntilElementVisible(elementLocator);
        WebElement page = getWebDriver().findElement(elementLocator);
        page.click();
    }

}
