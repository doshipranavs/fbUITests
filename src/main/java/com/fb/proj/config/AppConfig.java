package com.fb.proj.config;

import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class AppConfig {
    private static String app_url;
    private static String app_username;
    private static String app_password;
    public static String Version_Number;
    public static Properties properties = null;

    public static void loadAppConfig() {
        String configFileName = "%s-appconfig.properties";
        String EnvironmentName = System.getProperty("TestEnvironment");
        System.out.println("TestEnvironment: " + EnvironmentName);
        configFileName = String.format(configFileName, EnvironmentName);
        properties = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            try (InputStream resourceStream = loader.getResourceAsStream(configFileName)) {
                properties.load(resourceStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        app_url = properties.getProperty("APP_URL");
        app_username = properties.getProperty("APP_USERNAME");
        app_password = properties.getProperty("APP_PASSWORD");
        Version_Number = properties.getProperty("Version_Number");
    }
    public static String getPropertyValueFromPropertyFile(String propertyVal) {
        if (properties == null)
            loadAppConfig();
        return properties.getProperty(propertyVal);
    }
    private static Scanner loadFile(String filename) {

        String configlocation = System.getProperty("user.dir") + File.separator + "com/fb/proj/config/";
        Scanner file_scanner;
        try {
            file_scanner = new Scanner(new File(configlocation + filename));
            return file_scanner;
        } catch (Exception exp) {
            Assert.assertFalse("Exception from reading AppConfig :" + exp, false);
        }
        return null;
    }
    public static String getApp_url() {
        if (app_url == null || app_url.isEmpty()) {
            loadAppConfig();
        }
        return app_url;
    }
    public static void setApp_url(String app_url) {
        AppConfig.app_url = app_url;
    }
    public static String getApp_username() {
        return app_username;
    }
    public static void setApp_username(String app_username) {
        AppConfig.app_username = app_username;
    }
    public static String getApp_password() {
        return app_password;
    }
    public static void setApp_password(String app_password) {
        AppConfig.app_password = app_password;
    }
    public static String getVersion() {
        Version_Number = properties.getProperty("Version_Number");
        return Version_Number;
    }
}//end
