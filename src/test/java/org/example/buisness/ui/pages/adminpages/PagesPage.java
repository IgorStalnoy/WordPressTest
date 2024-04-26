package org.example.buisness.ui.pages.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.pages.AdminPage;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.buisness.ui.utils.Constants.*;

public class PagesPage extends AdminPage {
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.PAGES;
    public PagesPage() {
        super(new Header(), new SideMenu());
    }
    @Override
    public boolean isDisplayed() {
        WaitUtil.waitUntilElementVisible(PAGES_PAGE_LOCATOR);
        return getWebDriver().findElements(PAGES_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }

    public boolean isPageEqualsHighlightedOnSideMenu() {
        return sideMenu().isCurrentPageEqualsHighlightedOnSideMenu(SIDE_MENU_ELEMENT);
    }

    public List<WebElement> getTableElementsList() {
        return getWebDriver().findElements(PAGES_TABLE_ELEMENTS_LIST_LOCATOR);
    }
    public WebElement getLastTableElement() {
        return getTableElementsList().get(0);
    }
    public List<WebElement> getTableElementsByTitle(String titleName) {
        return getWebDriver().findElements(By.xpath(String.format(PAGES_TABLE_ELEMENTS_BY_TITLE_PATTERN,titleName)));
    }
}
