package driver;

import config.AppSettings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import static util.ErrorCodes.*;

/**
 * The {@code IOSDriverFactory} class is responsible for creating an {@code AppiumDriver} instance
 * configured specifically for iOS platform tests. It sets up the necessary capabilities and
 * returns an {@code IOSDriver} instance connected to the Appium server.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class IOSDriverFactory implements DriverFactory {

    /**
     * Creates and returns an {@code AppiumDriver} instance configured for iOS platform testing.
     * This method sets up the capabilities for the iOS platform, simulator device, and the specified app
     * based on the configuration settings found in the {@code config.json} file.
     *
     * @return An instance of {@code IOSDriver} configured with iOS-specific capabilities.
     * @throws RuntimeException if the URL for the Appium Server is invalid.
     */
    @Override
    public AppiumDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        JSONObject iosSettings = AppSettings.getPlatformSettings("ios");

        if (iosSettings != null) {
            for (Object key : iosSettings.keySet()) {
                capabilities.setCapability((String) key, iosSettings.get(key));
            }
        }

        try {
            return new IOSDriver(new URL(AppSettings.getValue("appiumUrl")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(INVALID_APPIUM_URL_ERROR, e);
        }
    }
}
