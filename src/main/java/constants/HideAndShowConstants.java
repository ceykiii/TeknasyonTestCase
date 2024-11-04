package constants;

/**
 * The {@code HideAndShowConstants} class contains constants related to the HideAndShowPage,
 * such as element locators and error messages.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class HideAndShowConstants {

    // Locator IDs
    public static final String TOGGLE_BUTTON_1_ID = "frag1hide";
    public static final String TOGGLE_BUTTON_2_ID = "frag2hide";
    public static final String INITIAL_TEXT_1_XPATH = "(//android.widget.EditText[@content-desc='Initial text.'])[1]";
    public static final String INITIAL_TEXT_2_XPATH = "(//android.widget.EditText[@content-desc='Initial text.'])[2]";
    public static final String TEXT_BOX_FRAGMENT_2_ID = "fragment2";

    // Error Messages
    public static final String BUTTON_1_NOT_FOUND = "First toggle button not found on the screen.";
    public static final String BUTTON_2_NOT_FOUND = "Second toggle button not found on the screen.";
    public static final String TEXT_BOX_1_NOT_FOUND = "First text box not found on the screen.";
    public static final String TEXT_BOX_2_NOT_FOUND = "Second text box not found on the screen.";
    public static final String TEXT_BOX_2_NOT_HIDDEN = "The second text box is not hidden as expected.";
    public static final String BUTTON_STATUS_MISMATCH = "The status of the second button does not match the expected value.";
}
