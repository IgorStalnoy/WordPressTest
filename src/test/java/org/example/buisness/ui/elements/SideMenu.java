package org.example.buisness.ui.elements;

import org.example.buisness.ui.utils.WaitUtil;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.buisness.ui.utils.Constants.SIDE_MENU_SECTION_PATTERN;

public class SideMenu {
    private final WebDriver webDriver;

    public SideMenu() {
        this.webDriver = Browser.getDriver();
    }

    public boolean isCurrentPageEqualsHighlightedOnSideMenu(SideMenuSectionsEnum section) {
        By highLightedButtonLocator = By.xpath(String.format(SIDE_MENU_SECTION_PATTERN, section.getValue()) + "/..");
        WaitUtil.waitUntilElementVisible(highLightedButtonLocator);
        WebElement sideMenuHighLightedButton = Browser.getDriver().findElement(highLightedButtonLocator);
        return sideMenuHighLightedButton.getCssValue("background").contains("rgb(34, 113, 177)");
    }

    public void openPage(SideMenuSectionsEnum sectionName) {
        By sectionButtonLocator = By.xpath(String.format(SIDE_MENU_SECTION_PATTERN, sectionName.getValue()));
        WaitUtil.waitUntilElementVisible(sectionButtonLocator);
        WebElement sectionOpenButton = webDriver.findElement(sectionButtonLocator);
        sectionOpenButton.click();
    }

}
