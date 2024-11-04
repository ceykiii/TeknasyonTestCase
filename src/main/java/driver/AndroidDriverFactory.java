package driver;

import config.AppSettings;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The {@code AndroidDriverFactory} class is responsible for creating an AndroidDriver instance
 * with dynamic configuration settings retrieved from a JSON configuration file.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class AndroidDriverFactory implements DriverFactory {

    /**
     * Creates and initializes an {@code AndroidDriver} instance based on the configuration settings
     * defined in the JSON configuration file for the Android platform.
     *
     * @return A configured {@code AppiumDriver} instance or {@code null} if an error occurs.
     */
    @Override
    public AppiumDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        JSONObject androidSettings = AppSettings.getPlatformSettings("android");

        // Checks and applies Android-specific capabilities from configuration
        if (androidSettings != null) {
            for (Object key : androidSettings.keySet()) {
                capabilities.setCapability((String) key, androidSettings.get(key));
            }
        }

        try {
            // Retrieves Appium server URL from configuration and initializes AndroidDriver
            return new AndroidDriver(new URL(AppSettings.getValue("appiumUrl")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
