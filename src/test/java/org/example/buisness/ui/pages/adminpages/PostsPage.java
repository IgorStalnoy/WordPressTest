package org.example.buisness.ui.pages.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.pages.AdminPage;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostsPage extends AdminPage {
    public static final By POSTS_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Posts')]");
    public static final By POSTS_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-list']/*");
    public static final String POSTS_TABLE_ELEMENTS_BY_TITLE_PATTERN = "//*[contains(text(),'%s')]/../../..";
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.POSTS;

    public PostsPage() {
        super(new Header(), new SideMenu());
    }

    @Override
    public boolean isDisplayed() {
        WaitUtil.waitUntilElementVisible(POSTS_PAGE_LOCATOR);
        return getWebDriver().findElements(POSTS_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }

    public boolean isPageEqualsHighlightedOnSideMenu() {
        return sideMenu().isCurrentPageEqualsHighlightedOnSideMenu(SIDE_MENU_ELEMENT);
    }

    public List<WebElement> getTableElementsList() {
        return getWebDriver().findElements(POSTS_TABLE_ELEMENTS_LIST_LOCATOR);
    }

    public WebElement getLastTableElement() {
        return getTableElementsList().get(0);
    }

    public List<WebElement> getTableElementsByTitle(String titleName) {
        return getWebDriver().findElements(By.xpath(String.format(POSTS_TABLE_ELEMENTS_BY_TITLE_PATTERN, titleName)));
    }

}
