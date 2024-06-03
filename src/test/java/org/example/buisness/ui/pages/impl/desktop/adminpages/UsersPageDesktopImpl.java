package org.example.buisness.ui.pages.impl.desktop.adminpages;

import org.example.buisness.ui.elements.Header;
import org.example.buisness.ui.elements.SideMenu;
import org.example.buisness.ui.elements.SideMenuSectionsEnum;
import org.example.buisness.ui.entities.User;
import org.example.buisness.ui.entities.UsersRolesEnum;
import org.example.buisness.ui.pages.UsersPage;
import org.example.buisness.ui.pages.impl.desktop.AdminPageDesktopImpl;
import org.example.buisness.ui.utils.WaitUtil;
import org.example.buisness.ui.webdriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class UsersPageDesktopImpl extends AdminPageDesktopImpl implements UsersPage {

    public static final By USERS_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Users')]");
    public static final By ADD_NEW_USER_BUTTON_LOCATOR = By.xpath("//a[@class='page-title-action']");
    public static final By ADD_NEW_USER_PAGE_LOCATOR = By.xpath("//h1[@id='add-new-user']");
    public static final By RECOMMENDED_PASSWORD_LOCATOR = By.xpath("//input[@id='pass1']");
    public static final By USERNAME_FIELD_LOCATOR = By.xpath("//input[@name='user_login']");
    public static final By EMAIL_FIELD_LOCATOR = By.xpath("//input[@name='email']");
    public static final By FIRST_NAME_FIELD_LOCATOR = By.xpath("//input[@name='first_name']");
    public static final By LAST_NAME_FIELD_LOCATOR = By.xpath("//input[@name='last_name']");
    public static final By WEBSITE_FIELD_LOCATOR = By.xpath("//input[@name='url']");
    public static final By SUBMIT_CREATE_NEW_USER_BUTTON_LOCATOR = By.xpath("//input[@name='createuser']");
    public static final By ROLE_LIST_LOCATOR = By.xpath("//select[@name='role']");
    public static final String ROLE_PATTERN = "//option[@value='%s']";
    public static final String BASE_NEW_USERS_EMAIL_TEXT = "@gmail.com";
    private final SideMenuSectionsEnum SIDE_MENU_ELEMENT = SideMenuSectionsEnum.USERS;

    public UsersPageDesktopImpl() {
        super(new Header(), new SideMenu());
    }

    @Override
    public boolean isDisplayed() {
        getLogger().debug("Waiting for the " + this.getClass().getSimpleName() + " to load");
        WaitUtil.waitUntilElementVisible(USERS_PAGE_LOCATOR);
        return getWebDriver().findElements(USERS_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public void openPage() {
        getLogger().info("Opening page " + SIDE_MENU_ELEMENT.getValue());
        sideMenu().openPage(SIDE_MENU_ELEMENT);
    }

    @Override
    public void openAddNewUserPage() {
        getLogger().debug("Waiting for the add new user button to load");
        WaitUtil.waitUntilElementVisible(ADD_NEW_USER_BUTTON_LOCATOR);
        WebElement addNewUserButton = Browser.getDriver().findElement(ADD_NEW_USER_BUTTON_LOCATOR);
        getLogger().info("Click on the add new user button");
        addNewUserButton.click();
    }

    @Override
    public boolean isAddNewUserPageDisplayed() {
        getLogger().debug("Waiting for the add new user page to load");
        WaitUtil.waitUntilElementVisible(ADD_NEW_USER_PAGE_LOCATOR);
        return getWebDriver().findElements(ADD_NEW_USER_PAGE_LOCATOR).size() == 1;
    }

    @Override
    public String generateNewUserName(String baseName) {
        return baseName + new Random().nextInt(99999999);
    }

    @Override
    public void fillInNewUserFields(User newUser) {
        waitForAllFieldsLoaded();
        WebElement username = Browser.getDriver().findElement(USERNAME_FIELD_LOCATOR);
        username.sendKeys(newUser.getUsername());
        WebElement email = Browser.getDriver().findElement(EMAIL_FIELD_LOCATOR);
        email.sendKeys(newUser.getEmail());
        WebElement firstName = Browser.getDriver().findElement(FIRST_NAME_FIELD_LOCATOR);
        firstName.sendKeys(newUser.getFirstName());
        WebElement lastNAme = Browser.getDriver().findElement(LAST_NAME_FIELD_LOCATOR);
        lastNAme.sendKeys(newUser.getLastName());
        WebElement website = Browser.getDriver().findElement(WEBSITE_FIELD_LOCATOR);
        website.sendKeys(newUser.getWebsite());
        WebElement roleList = Browser.getDriver().findElement(ROLE_LIST_LOCATOR);
        roleList.click();
        WebElement role = Browser.getDriver().findElement(By.xpath(String.format(ROLE_PATTERN, newUser.getRole().getValue().toLowerCase())));
        role.click();
    }

    @Override
    public User getNewUser(String name, String password, UsersRolesEnum role) {
        return User.builder()
                .username(name)
                .email(name.concat(BASE_NEW_USERS_EMAIL_TEXT))
                .firstName(name)
                .lastName(name)
                .website(name)
                .password(password)
                .role(role)
                .build();
    }

    @Override
    public String getRecommendedPassword() {
        getLogger().debug("Waiting for recommended password to load");
        WaitUtil.waitUntilElementVisible(RECOMMENDED_PASSWORD_LOCATOR);
        WebElement passwordField = Browser.getDriver().findElement(RECOMMENDED_PASSWORD_LOCATOR);
        return passwordField.getAttribute("data-pw");
    }

    @Override
    public void createUser() {
        getLogger().debug("Waiting for the submit create new user button to load");
        WaitUtil.waitUntilElementVisible(SUBMIT_CREATE_NEW_USER_BUTTON_LOCATOR);
        WebElement submitButton = Browser.getDriver().findElement(SUBMIT_CREATE_NEW_USER_BUTTON_LOCATOR);
        submitButton.click();
    }


    private void waitForAllFieldsLoaded() {
        getLogger().debug("Waiting for username field to load");
        WaitUtil.waitUntilElementVisible(USERNAME_FIELD_LOCATOR);
        WaitUtil.waitUntilElementVisible(EMAIL_FIELD_LOCATOR);
        getLogger().debug("Waiting for email field to load");
        WaitUtil.waitUntilElementVisible(FIRST_NAME_FIELD_LOCATOR);
        getLogger().debug("Waiting for first name field to load");
        WaitUtil.waitUntilElementVisible(LAST_NAME_FIELD_LOCATOR);
        getLogger().debug("Waiting for last name field to load");
        WaitUtil.waitUntilElementVisible(WEBSITE_FIELD_LOCATOR);
        getLogger().debug("Waiting for website field to load");
        WaitUtil.waitUntilElementVisible(ROLE_LIST_LOCATOR);
        getLogger().debug("Waiting for role select to load");
    }

}
