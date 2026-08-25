package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found in src/main/resources"
                );
            }

            properties.load(input);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to load config.properties",
                    e
            );
        }
    }

    public static String getBaseUrl() {

        String url = properties.getProperty("baseUrl");

        if (url == null || url.trim().isEmpty()) {

            throw new RuntimeException(
                    "baseUrl is missing in config.properties"
            );
        }

        return url.trim();
    }
}