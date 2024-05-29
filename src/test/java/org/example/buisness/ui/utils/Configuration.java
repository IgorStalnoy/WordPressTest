package org.example.buisness.ui.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;
    private final static Logger logger = Logger.getLogger(Configuration.class.getName());

    public static Properties getProperties() {
        if (properties == null) {
            try {
                logger.trace("Init properties");
                properties = new Properties();
                properties.load(new FileInputStream("project.properties"));
            } catch (IOException e) {
                logger.error("Error init properties");
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
    public static String getUsername() {
        try {
            return properties.getProperty("username");
        } catch (NullPointerException ex) {
            logger.error("Property username is not exist");
        }
        return null;
    }
    public static String getPassword() {
        try {
            return properties.getProperty("password");
        } catch (NullPointerException ex) {
            logger.error("Property password is not exist");
        }
        return null;
    }
    public static String getDomain() {
        try {
            return properties.getProperty("domain");
        } catch (NullPointerException ex) {
            logger.error("Property domain is not exist");
        }
        return null;
    }
    public static String getScreenshotFolder() {
        try {
            return properties.getProperty("screenshotFolder");
        } catch (NullPointerException ex) {
            logger.error("Property screenshotFolder is not exist");
        }
        return null;
    }
}
