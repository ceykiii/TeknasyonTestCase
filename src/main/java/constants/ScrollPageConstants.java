package constants;

/**
 * The {@code ScrollPageConstants} class provides constants used in the ScrollPage class,
 * including element locators and error messages for verification.
 *
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class ScrollPageConstants {

    // Locator Constants
    public static final String SCROLL_VIEW_CLASS_NAME = "android.widget.HorizontalScrollView";
    public static final String TAB_ELEMENTS_ID = "android:id/title";
    public static final String TAB_DYNAMIC_LOCATOR_XPATH_TEMPLATE = "//android.widget.TextView[@content-desc='%s']";
    public static final String TAB_CONTENT_LOCATOR_XPATH_TEMPLATE = "//android.widget.TextView[contains(@text, '%s')]";

    // Error Messages
    public static final String TAB_NOT_FOUND_ERROR = "The specified tab could not be displayed.";
}
