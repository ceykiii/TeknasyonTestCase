package constants;

/**
 * The {@code ContextMenuConstants} class holds constants for element identifiers
 * and error messages used within the {@code ContextMenuPage} class.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class ContextMenuConstants {

    // Error messages for element presence validation
    public static final String LONG_PRESS_BUTTON_NOT_FOUND_ERROR = "The 'Long Press Me' button could not be found on the screen.";
    public static final String MENU_A_NOT_FOUND_ERROR = "The 'Menu A' option could not be found on the screen.";
    public static final String MENU_B_NOT_FOUND_ERROR = "The 'Menu B' option could not be found on the screen.";

    // Locator constants (Optional, if needed in other parts of the framework)
    public static final String LONG_PRESS_BUTTON_ID = "io.appium.android.apis:id/long_press";
    public static final String MENU_A_XPATH = "//android.widget.TextView[@text='Menu A']";
    public static final String MENU_B_XPATH = "//android.widget.TextView[@text='Menu B']";
}
