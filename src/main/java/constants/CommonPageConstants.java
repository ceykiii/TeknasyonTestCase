package constants;

/**
 * The {@code CommonPageConstants} class defines constants used within the {@code CommonPage} class.
 * These constants typically include locators and keys associated with navigating menus in the application.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class CommonPageConstants {

    // Locator constants
    public static final String MENU_ITEM_XPATH_TEMPLATE = "//android.widget.TextView[@content-desc='%s']";

    // Key for DataTable item in Cucumber
    public static final String MENU_ITEM_KEY = "MenuItem";

    // Error Messages
    public static final String MENU_ITEM_NOT_FOUND_ERROR = "Menu item '%s' could not be found on the screen.";

}
