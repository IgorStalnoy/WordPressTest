package org.example.buisness.ui.webdriver;

import lombok.experimental.UtilityClass;
import org.apache.log4j.Logger;
import org.example.buisness.ui.utils.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@UtilityClass
public class Browser {
    private final int DEFAULT_WAIT_IN_SECONDS = 5;
    private WebDriver webDriver;
    private final Logger logger = Logger.getLogger(Browser.class.getName());
    private DevicesEnum deviceType;
    private BrowserTypeEnum browserType;

    private void initDriver() {
        BrowserFactory browserFactory = new BrowserFactory();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        logger.trace("Init browser");
        try {
            webDriver = browserFactory.createDriver(getBrowser());
            webDriver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_IN_SECONDS, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            deviceType = browserFactory.getDevice();
            browserType = browserFactory.getBrowserType();
            logger.info("New " + browserType + " browser with " + deviceType + " mode was successfully created");
        } catch (IllegalStateException ex) {
            logger.error("Driver init error");
            throw ex;
        }
    }

    public WebDriver getDriver() {
        if (webDriver == null) {
            initDriver();
        }
        return webDriver;
    }

    public void close() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public byte[] makeScreenshot() {
        return ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private BrowserTypeEnum getBrowser() {
        if (System.getProperty("browser") == null) {
            return BrowserTypeEnum.valueOf(Configuration.getProperties().getProperty("browser"));
        } else {
            return BrowserTypeEnum.valueOf(System.getProperty("browser").toUpperCase());
        }
    }

    public static DevicesEnum getDeviceType() {
        return deviceType;
    }

    public static BrowserTypeEnum getBrowserType() {
        return browserType;
    }
}
