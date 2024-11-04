package pages.constants;

/**
 * The {@code NotificationPageConstants} class contains constants related to NotificationPage,
 * including element locators, error messages, and context keys for data storage.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class NotificationPageConstants {

    // Locator Constants
    public static final String SHOW_NOTIFICATION_BUTTON_ID = "notify_app";
    public static final String NOTIFICATION_HEADER_XPATH = "//android.widget.FrameLayout[@resource-id='android:id/status_bar_latest_event_content']//android.widget.TextView[contains(@text, 'API Demos')]";
    public static final String NOTIFICATION_MESSAGE_XPATH = "(//android.widget.LinearLayout[@resource-id='android:id/line1'])[1]//android.widget.TextView";
    public static final String NOTIFICATION_MESSAGE_CONTENT_XPATH = "(//android.widget.LinearLayout[@resource-id='android:id/line1'])[1]/following-sibling::android.widget.TextView[@resource-id='android:id/text']";
    public static final String NOTIFICATION_DETAIL_MESSAGE_XPATH = "//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/from\"]";
    public static final String NOTIFICATION_DETAIL_CONTENT_ID = "message";
    public static final String NOTIFICATION_DETAIL_IMAGE_CLASS = "android.widget.ImageView";

    // Error Messages
    public static final String NOTIFY_BUTTON_NOT_FOUND = "Notification Button could not be found.";
    public static final String NOTIFICATION_HEADER_NOT_FOUND = "Notification header could not be found in the Notification Bar.";
    public static final String NOTIFICATION_MESSAGE_NOT_FOUND = "Notification message title could not be found in the Notification Bar.";
    public static final String NOTIFICATION_CONTENT_NOT_FOUND = "Notification content could not be found in the Notification Bar.";
    public static final String NOTIFICATION_DETAIL_PAGE_NOT_FOUND = "Notification detail page did not open as expected.";
    public static final String NOTIFICATION_DETAIL_TITLE_MISMATCH = "Notification detail title does not match the notification bar title.";
    public static final String NOTIFICATION_DETAIL_CONTENT_MISMATCH = "Notification detail content does not match the notification bar content.";

    // Context Keys
    public static final String NOTIFY_TITLE_CONTEXT_KEY = "notifyTitle";
    public static final String NOTIFY_CONTENT_CONTEXT_KEY = "notifyContent";
}
