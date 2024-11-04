package driver;

import config.AppSettings;
import io.appium.java_client.AppiumDriver;
import static util.ErrorCodes.*;

/**
 * The {@code DriverManager} class provides a centralized method to initialize
 * and retrieve an {@code AppiumDriver} instance based on the specified platform
 * in the configuration file. This class uses the factory pattern to support Android
 * and iOS platform drivers.
 *
 * Email: cem.acar03@gmail.com
 */
public class DriverManager {

    private static final String PLATFORM_KEY = "platform";

    /**
     * Retrieves an {@code AppiumDriver} instance based on the platform specified
     * in the configuration file. It selects the appropriate {@code DriverFactory}
     * implementation for driver creation.
     *
     * @return An instance of {@code AppiumDriver} configured for the specified platform.
     * @throws IllegalArgumentException if the platform specified in config.json is invalid.
     */
    public static AppiumDriver getDriver() {
        String platform = AppSettings.getValue(PLATFORM_KEY).toLowerCase();

        DriverFactory factory = selectDriverFactory(platform);
        return factory.createDriver();
    }

    /**
     * Selects the appropriate {@code DriverFactory} implementation based on the platform name.
     *
     * @param platform The platform name ("android" or "ios").
     * @return An instance of the appropriate {@code DriverFactory}.
     * @throws IllegalArgumentException if the platform name is not supported.
     */
    private static DriverFactory selectDriverFactory(String platform) {
        switch (platform) {
            case "android":
                return new AndroidDriverFactory();
            case "ios":
                return new IOSDriverFactory();
            default:
                throw new IllegalArgumentException(UNSUPPORTED_PLATFORM_ERROR + platform);
        }
    }
}
