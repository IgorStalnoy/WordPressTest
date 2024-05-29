package org.example.buisness.ui.pages.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.pages.AdminPage;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PagesPage extends AdminPage {
    public static final By PAGES_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Pages')]");
    public static final By PAGES_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-list']/*");
    public static final String PAGES_TABLE_ELEMENTS_BY_TITLE_PATTERN = "//a[contains(text(),'%s')]/../../..";
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.PAGES;

    public PagesPage() {
        super(new Header(), new SideMenu());
    }

    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(PAGES_PAGE_LOCATOR);
        return getWebDriver().findElements(PAGES_PAGE_LOCATOR).size() == 1;
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
        return getWebDriver().findElements(PAGES_TABLE_ELEMENTS_LIST_LOCATOR);
    }

    public WebElement getLastTableElement() {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table last element");
        return getTableElementsList().get(0);
    }

    public List<WebElement> getTableElementsByTitle(String titleName) {
        getLogger().info("Get " + this.getClass().getSimpleName() + " table elements by title");
        return getWebDriver().findElements(By.xpath(String.format(PAGES_TABLE_ELEMENTS_BY_TITLE_PATTERN, titleName)));
    }
}
