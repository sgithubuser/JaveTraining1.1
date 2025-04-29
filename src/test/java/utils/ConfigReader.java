package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public static void load(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file from path: " + filePath, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
