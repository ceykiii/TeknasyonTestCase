package base;

import config.AppSettings;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONObject;

/**
 * The {@code BaseTest} class is the foundation for initializing and managing the lifecycle of
 * the {@link AppiumDriver} instance. It provides utility methods to set up, reinstall, and tear down
 * the application as needed during testing.
 * This class dynamically loads configuration details for Android and iOS platforms from a JSON file
 * through {@link AppSettings}.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class BaseTest {

    public static AppiumDriver driver;

    // Loads platform-specific settings from JSON configuration
    private static final String PLATFORM = "android";
    private static final JSONObject platformSettings = AppSettings.getPlatformSettings(PLATFORM);
    private static final String APP_PACKAGE = (String) platformSettings.get("appPackage");
    private static final String APP_PATH = (String) platformSettings.get("app");

    /**
     * Initializes the Appium driver if it is not already instantiated. This ensures a single
     * driver instance across the test session, managed by {@link DriverManager}.
     */
    public static void initializeDriver() {
        if (driver == null) {
            driver = (AppiumDriver) DriverManager.getDriver();
        }
    }

    /**
     * Reinstalls the application by removing it (if installed) and reinstalling it.
     * After reinstallation, the application is activated. This method checks if the driver
     * is an instance of Android or iOS and performs the respective reinstall operation.
     */
    public static void reinstallApp() {
        if (driver == null) {
            initializeDriver(); // Start the driver if not already started
        }

        // Platform-specific reinstall actions
        if (driver instanceof AndroidDriver) {
            reinstallAppOnAndroid((AndroidDriver) driver);
        } else if (driver instanceof IOSDriver) {
            reinstallAppOnIOS((IOSDriver) driver);
        }
    }

    /**
     * Reinstalls the application on an Android device. If the app is already installed, it is removed,
     * and a new installation is performed. The application is activated after installation.
     *
     * @param androidDriver the Android driver instance to interact with the device
     */
    private static void reinstallAppOnAndroid(AndroidDriver androidDriver) {
        if (androidDriver.isAppInstalled(APP_PACKAGE)) {
            androidDriver.removeApp(APP_PACKAGE);
        }
        androidDriver.installApp(APP_PATH);
        androidDriver.activateApp(APP_PACKAGE);
    }

    /**
     * Reinstalls the application on an iOS device. If the app is already installed, it is removed,
     * and a new installation is performed. The application is activated after installation.
     *
     * @param iosDriver the iOS driver instance to interact with the device
     */
    private static void reinstallAppOnIOS(IOSDriver iosDriver) {
        if (iosDriver.isAppInstalled(APP_PACKAGE)) {
            iosDriver.removeApp(APP_PACKAGE);
        }
        iosDriver.installApp(APP_PATH);
        iosDriver.activateApp(APP_PACKAGE);
    }

    /**
     * Quits the Appium driver if it is active, releasing all associated resources. The driver
     * reference is then set to null to ensure a fresh start for the next test session.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
