package org.example.buisness.ui.elements;

import org.example.buisness.ui.utils.WaitUtil;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends Element {
    public static final String SIDE_MENU_SECTION_PATTERN = "//div[contains(text(),'%s')]";
    private final WebDriver webDriver;

    public SideMenu() {
        this.webDriver = Browser.getDriver();
    }

    public boolean isCurrentPageEqualsHighlightedOnSideMenu(SideMenuSectionsEnum section) {
        By highLightedButtonLocator = By.xpath(String.format(SIDE_MENU_SECTION_PATTERN, section.getValue()) + "/..");
        getLogger().debug("Waiting for the side menu highlighted button to load");
        WaitUtil.waitUntilElementVisible(highLightedButtonLocator);
        WebElement sideMenuHighLightedButton = Browser.getDriver().findElement(highLightedButtonLocator);
        boolean isCurrentPageEqualsHighlightedOnSideMenu = sideMenuHighLightedButton.getCssValue("background").contains("rgb(34, 113, 177)");
        if (isCurrentPageEqualsHighlightedOnSideMenu) {
            return true;
        } else {
            getLogger().warn("Current page is not equals as highlighted on the side menu");
            return false;
        }
    }

    public void openPage(SideMenuSectionsEnum sectionName) {
        By sectionButtonLocator = By.xpath(String.format(SIDE_MENU_SECTION_PATTERN, sectionName.getValue()));
        getLogger().debug("Wait for the " + sectionName.getValue() + " side menu button is displayed");
        WaitUtil.waitUntilElementVisible(sectionButtonLocator);
        WebElement sectionOpenButton = webDriver.findElement(sectionButtonLocator);
        getLogger().info("Clicking on the " + sectionName.getValue() + " button");
        sectionOpenButton.click();
    }

    public boolean isMenuDisplayed(SideMenuSectionsEnum sideMenuSectionsEnum) {
        By locator = By.xpath(String.format(SIDE_MENU_SECTION_PATTERN, sideMenuSectionsEnum.getValue()));
        WaitUtil.waitUntilElementVisible(locator);
        return Browser.getDriver().findElements(locator).size() == 1;
    }
}
