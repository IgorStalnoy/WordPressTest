package org.example.buisness.ui.pages.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.pages.AdminPage;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;

public class DashboardPage extends AdminPage {
    public static final By DASHBOARD_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Dashboard')]");
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.DASHBOARD;

    public DashboardPage() {
        super(new Header(), new SideMenu());
    }

    @Override
    public boolean isDisplayed() {
        WaitUtil.waitUntilElementVisible(DASHBOARD_PAGE_LOCATOR);
        return getWebDriver().findElements(DASHBOARD_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }


    public boolean isPageEqualsHighlightedOnSideMenu() {
        return sideMenu().isCurrentPageEqualsHighlightedOnSideMenu(SIDE_MENU_ELEMENT);
    }


}
