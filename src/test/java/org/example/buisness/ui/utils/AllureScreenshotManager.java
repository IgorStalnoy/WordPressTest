package org.example.buisness.ui.utils;

import io.qameta.allure.Attachment;
import org.example.buisness.ui.webdriver.Browser;

public class AllureScreenshotManager {

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] makeScreenshot() {
        return Browser.makeScreenshot();
    }
}
