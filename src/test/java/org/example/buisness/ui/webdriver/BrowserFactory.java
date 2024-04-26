package org.example.buisness.ui.webdriver;

import org.example.buisness.ui.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    public static WebDriver createDriver(BrowserTypeEnum browserType) {
        WebDriver webDriver;
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Configuration.getProperties().getProperty("device").equals(DevicesEnum.MOBILE.getValue())) {
                    chromeOptions.setExperimentalOption("mobileEmulation", getMobileEmulationPrefs());
                }
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                webDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Can't create webdriver for " + browserType);
        }
        return webDriver;
    }

    private static Map<String, Object> getMobileEmulationPrefs() {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 14 Pro Max");
        return mobileEmulation;
    }
}
