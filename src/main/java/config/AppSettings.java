package config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import util.ErrorCodes;
import java.io.FileReader;

/**
 * The {@code AppSettings} class provides a mechanism to load and access
 * configuration settings from a JSON file. It reads the JSON file once and
 * stores it in a static {@code JSONObject} to make it accessible throughout the system.
 * This class offers methods to retrieve specific settings by key or obtain platform-specific settings.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class AppSettings {

    /**
     * Stores the configuration data loaded from the JSON file.
     */
    private static JSONObject config;

    // Static block to initialize configuration
    static {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/config.json")) {
            config = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the value associated with a specified key in the configuration.
     *
     * @param key the key for the desired configuration setting
     * @return the value corresponding to the provided key, as a {@code String}
     * @throws RuntimeException if the configuration failed to load
     */
    public static String getValue(String key) {
        if (config != null) {
            return (String) config.get(key);
        } else {
            throw new RuntimeException(ErrorCodes.CONFIG_LOAD_ERROR);
        }
    }

    /**
     * Retrieves settings for a specific platform (e.g., "android" or "ios").
     *
     * @param platform the platform name ("android" or "ios")
     * @return {@code JSONObject} containing settings for the specified platform
     * @throws RuntimeException if the configuration failed to load
     */
    public static JSONObject getPlatformSettings(String platform) {
        if (config != null) {
            return (JSONObject) config.get(platform);
        } else {
            throw new RuntimeException(ErrorCodes.CONFIG_LOAD_ERROR);
        }
    }
}
