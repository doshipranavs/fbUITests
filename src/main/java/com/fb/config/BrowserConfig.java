package com.fb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BrowserConfig {

    static Properties config;
    public static String browser;

    public static void loadConfig() {
        String configFileName = "%s-BrowserConfig.properties";
        String EnvironmentName = System.getProperty("TestEnvironment");
        System.out.println("TestEnvironment: " + EnvironmentName);

        configFileName = String.format(configFileName, EnvironmentName);
        Properties  properties = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            try (InputStream resourceStream = loader.getResourceAsStream(configFileName)) {
                properties.load(resourceStream);
            }
            System.out.println(properties.getProperty("envname"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        config          = properties;
        browser         = properties.getProperty("Browser");
    }
    public static String getBrowser() {
        if(browser == null || browser.isEmpty()){
            loadConfig();
        }
        return browser;
    }

}//end
