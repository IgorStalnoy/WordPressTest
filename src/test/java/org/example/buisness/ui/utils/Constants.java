package org.example.buisness.ui.utils;

import org.openqa.selenium.By;

public class Constants {

    public static final String DOMAIN = "wordpress-test-app-for-selenium.azurewebsites.net";
    public static final String MAIN_URL = "https://" + DOMAIN;
    public static final By HEADER_LOGGED_IN_LOCATOR = By.xpath("//*[contains(text(),'Howdy, ')]");
    public static final By HEADER_LOG_OUT_BUTTON_LOCATOR = By.xpath("//li/a[contains(text(),'Log Out')]");
    public static final String SIDE_MENU_SECTION_PATTERN = "//div[contains(text(),'%s')]";
    public static final String LOGIN_PAGE_URL = MAIN_URL + "/wp-admin";
    public static final String LOGIN_USERNAME = "admin";
    public static final String LOGIN_PASSWORD = "kiyF5Oc#*8iE9DKx8bACg2DR";
    public static final By LOGIN_PAGE_LOCATOR = By.xpath("//*[@id='loginform']");
    public static final By LOGIN_PAGE_USERNAME_FIELD_LOCATOR = By.xpath("//*[@id='user_login']");
    public static final By LOGIN_PAGE_PASSWORD_FIELD_LOCATOR = By.xpath("//*[@id='user_pass']");
    public static final By LOGIN_PAGE_REMEMBER_ME_CHECKBOX_LOCATOR = By.xpath("//*[@id='rememberme']");
    public static final By LOGIN_PAGE_LOG_IN_BUTTON_LOCATOR = By.xpath("//*[@id='wp-submit']");
    public static final By LOGIN_PAGE_INVALID_CREDS_ERROR_LOCATOR = By.xpath("//*[@id='login_error']");
    public static final By DASHBOARD_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Dashboard')]");
    public static final By POSTS_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Posts')]");
    public static final By POSTS_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-list']/*");
    public static final String POSTS_TABLE_ELEMENTS_BY_TITLE_PATTERN = "//*[contains(text(),'%s')]/../../..";
    public static final By MEDIA_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Media')]");
    public static final By MEDIA_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-list']/*");
    public static final String MEDIA_TABLE_ELEMENTS_BY_TITLE_PATTERN = "//*[contains(text(),'%s')]/../../..";
    public static final By PAGES_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Pages')]");
    public static final By PAGES_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-list']/*");
    public static final String PAGES_TABLE_ELEMENTS_BY_TITLE_PATTERN = "//a[contains(text(),'%s')]/../../..";
    public static final By COMMENTS_PAGE_LOCATOR = By.xpath("//h1[contains(text(),'Comments')]");
    public static final By COMMENTS_TABLE_ELEMENTS_LIST_LOCATOR = By.xpath("//*[@id='the-comment-list']/*");
    public static final String COMMENTS_TABLE_ELEMENTS_BY_POST_PATTERN = "//*[contains(text(),'%s')]/../../..";
    public static final By MAIN_PAGE_LOCATOR = By.xpath("//h1[@class='wp-block-site-title']");
    public static final By MAIN_PAGE_PAGES_LIST_LOCATOR = By.xpath("//*[@class='wp-block-page-list']/*");
    public static final String MAIN_PAGE_PAGES_PATTERN = "//*[@class='wp-block-page-list']//*[contains(text(),'%s')]";
    public static final By MAIN_PAGE_POSTS_LIST_LOCATOR =By.xpath("//ul[contains(@class, 'alignwide wp-block')]/*");
    public static final String MAIN_PAGE_POSTS_PATTERN ="//ul[contains(@class, 'alignwide wp-block')]//*[contains(text(),'%s')]";

    private Constants() {
    }
}
