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

public class CommentsPage extends AdminPage {
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.COMMENTS;
    public CommentsPage() {
        super(new Header(), new SideMenu());
    }
    @Override
    public boolean isDisplayed() {
        WaitUtil.waitUntilElementVisible(COMMENTS_PAGE_LOCATOR);
        return getWebDriver().findElements(COMMENTS_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }

    public boolean isPageEqualsHighlightedOnSideMenu() {
        return sideMenu().isCurrentPageEqualsHighlightedOnSideMenu(SIDE_MENU_ELEMENT);
    }

    public List<WebElement> getTableElementsList() {
        return getWebDriver().findElements(COMMENTS_TABLE_ELEMENTS_LIST_LOCATOR);
    }
    public WebElement getLastTableElement() {
        return getTableElementsList().get(0);
    }
    public List<WebElement> getTableElementsByPostTitle(String titleName) {
        return getWebDriver().findElements(By.xpath(String.format(COMMENTS_TABLE_ELEMENTS_BY_POST_PATTERN,titleName)));
    }
}
