package constants;

import util.StringContext;

/**
 * The {@code DialogPageConstants} class contains constants related to the DialogPage,
 * such as element locators, error messages, and context keys for data storage.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class DialogPageConstants {

    // Locator Constants
    public static final String LIST_DIALOG_TEXT_VIEWS_XPATH = "//android.widget.TextView[@resource-id='android:id/text1']";
    public static final String DIALOG_MESSAGE_ELEMENT_ID = "android:id/message";
    public static final String OPTION_BUTTON_XPATH_TEMPLATE = "//android.widget.Button[@content-desc='%s']";

    // Error Messages
    public static final String DIALOG_MESSAGE_ELEMENT_NOT_FOUND = "Dialog Message Element could not be found on the screen.";
    public static final String SELECTION_MISMATCH_ERROR = "The selected element does not match the content of the message box.";

    // Context Keys
    public static final String DIALOG_MESSAGE_CONTEXT_KEY = "dialogMessage";
}
