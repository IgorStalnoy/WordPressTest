package org.example.buisness.ui.pages.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.pages.AdminPage;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentsPage extends AdminPage {
    public static final By COMMENTS_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Comments')]");
    public static final By COMMENTS_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-comment-list']/*");
    public static final String COMMENTS_TABLE_ELEMENTS_BY_POST_PATTERN = "//*[contains(text(),'%s')]/../../..";
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.COMMENTS;
    public CommentsPage() {
        super(new Header(), new SideMenu());
    }
    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(COMMENTS_PAGE_LOCATOR);
        return getWebDriver().findElements(COMMENTS_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getLogger().info("Opening page " + SIDE_MENU_ELEMENT.getValue());
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }

    public boolean isPageEqualsHighlightedOnSideMenu() {
        return sideMenu().isCurrentPageEqualsHighlightedOnSideMenu(SIDE_MENU_ELEMENT);
    }

    public List<WebElement> getTableElementsList() {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table elements");
        return getWebDriver().findElements(COMMENTS_TABLE_ELEMENTS_LIST_LOCATOR);
    }
    public WebElement getLastTableElement() {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table last element");
        return getTableElementsList().get(0);
    }
    public List<WebElement> getTableElementsByPostTitle(String titleName) {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table elements by title");
        return getWebDriver().findElements(By.xpath(String.format(COMMENTS_TABLE_ELEMENTS_BY_POST_PATTERN,titleName)));
    }
}
