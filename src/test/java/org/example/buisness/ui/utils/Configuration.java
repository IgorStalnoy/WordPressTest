package org.example.buisness.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                properties.load(new FileInputStream("project.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
    public static String getUsername() {
        return properties.getProperty("username");
    }
    public static String getPassword() {
        return properties.getProperty("password");
    }
    public static String getDomain() {
        return properties.getProperty("domain");
    }
}
