package org.example.buisness.ui.webdriver;

import lombok.Getter;
import org.example.buisness.ui.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BrowserFactory {
    private DevicesEnum device;
    private BrowserTypeEnum browserType;

    public WebDriver createDriver(BrowserTypeEnum browserType) {
        WebDriver webDriver;
        Configuration.initProperties();
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (initDevice().equals(DevicesEnum.MOBILE)) {
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

    private Map<String, Object> getMobileEmulationPrefs() {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 14 Pro Max");
        return mobileEmulation;
    }

    private DevicesEnum initDevice() {
        if (System.getProperty("device") == null) {
            device = getDeviceFromConfiguration();
            return getDeviceFromConfiguration();
        } else {
            device = getDeviceFromSystem();
            return getDeviceFromSystem();
        }
    }

    private DevicesEnum getDeviceFromConfiguration() {
        return DevicesEnum.valueOf(Configuration.getProperties().getProperty("device"));
    }

    private DevicesEnum getDeviceFromSystem() {
        return DevicesEnum.valueOf(System.getProperties().getProperty("device"));
    }

}
