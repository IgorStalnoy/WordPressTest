package org.example.tests.ui;

import org.example.buisness.ui.utils.AllureScreenshotManager;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;

public class CustomListener implements TestWatcher, TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        AllureScreenshotManager.makeScreenshot();
        throw throwable;
    }
}