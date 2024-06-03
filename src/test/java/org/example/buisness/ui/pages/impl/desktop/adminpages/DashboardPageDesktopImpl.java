package org.example.buisness.ui.pages.impl.desktop.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.pages.DashboardPage;
import org.example.buisness.ui.pages.impl.desktop.AdminPageDesktopImpl;
import org.example.buisness.ui.utils.WaitUtil;
import org.openqa.selenium.By;

public class DashboardPageDesktopImpl extends AdminPageDesktopImpl implements DashboardPage {
    public static final By DASHBOARD_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Dashboard')]");
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.DASHBOARD;

    public DashboardPageDesktopImpl() {
        super(new Header(), new SideMenu());
    }

    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(DASHBOARD_PAGE_LOCATOR);
        return getWebDriver().findElements(DASHBOARD_PAGE_LOCATOR).size() == 1;
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
    public boolean isMenuDisplayedOnSideMenu() {
        return sideMenu().isMenuDisplayed(SIDE_MENU_ELEMENT);
    }


}
