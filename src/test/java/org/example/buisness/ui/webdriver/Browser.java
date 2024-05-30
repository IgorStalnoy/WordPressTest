package org.example.buisness.ui.webdriver;

import org.apache.log4j.Logger;
import org.example.buisness.ui.utils.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static final int DEFAULT_WAIT_IN_SECONDS = 5;
    private static WebDriver webDriver;
    private final static Logger logger = Logger.getLogger(Browser.class.getName());

    private Browser() {
    }

    private static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        logger.trace("Init browser");
        try {
            webDriver = BrowserFactory.createDriver(getBrowser());
            webDriver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_IN_SECONDS, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        } catch (IllegalStateException ex) {
            logger.error("Driver init error");
            throw ex;
        }
    }

    public static WebDriver getDriver() {
        if (webDriver == null) {
            initDriver();
        }
        return webDriver;
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static BrowserTypeEnum getBrowser() {
        if (System.getProperty("browser") == null) {
            return BrowserTypeEnum.valueOf(Configuration.getProperties().getProperty("browser"));
        } else {
            return BrowserTypeEnum.valueOf(System.getProperty("browser").toUpperCase());
        }
    }
}
