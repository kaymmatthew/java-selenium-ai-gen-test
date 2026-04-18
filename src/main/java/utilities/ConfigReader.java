// File: /src/test/java/config/ConfigReader.java
package utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found!");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading configuration", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}