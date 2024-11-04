package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.constants.NotificationPageConstants;
import util.StringContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code NotificationPage} class represents the page where notification functionalities
 * are tested, including displaying and validating notifications.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class NotificationPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(NotificationPage.class);

    @FindBy(id = NotificationPageConstants.SHOW_NOTIFICATION_BUTTON_ID)
    private WebElement showAppNotifyButton;

    @FindBy(xpath = NotificationPageConstants.NOTIFICATION_HEADER_XPATH)
    private WebElement notificationHeader;

    @FindBy(xpath = NotificationPageConstants.NOTIFICATION_MESSAGE_XPATH)
    private WebElement notificationMessage;

    @FindBy(xpath = NotificationPageConstants.NOTIFICATION_MESSAGE_CONTENT_XPATH)
    private WebElement notificationMessageContent;

    @FindBy(xpath = NotificationPageConstants.NOTIFICATION_DETAIL_MESSAGE_XPATH)
    private WebElement notificationDetailMessage;

    @FindBy(id = NotificationPageConstants.NOTIFICATION_DETAIL_CONTENT_ID)
    private WebElement notificationDetailContent;

    @FindBy(className = NotificationPageConstants.NOTIFICATION_DETAIL_IMAGE_CLASS)
    private WebElement notificationDetailImage;

    /**
     * Initializes the elements with AppiumFieldDecorator.
     *
     * @param driver the Appium driver instance
     */
    public NotificationPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        logger.info("NotificationPage initialized.");
    }

    /**
     * Clicks on the 'Show Notification' button.
     */
    public void clickShowNotificationButton() {
        logger.info("Attempting to click the 'Show Notification' button.");
        assertElementPresence(showAppNotifyButton, NotificationPageConstants.NOTIFY_BUTTON_NOT_FOUND);
        clickElement(showAppNotifyButton);
    }

    /**
     * Displays the notification bar and checks for the presence of the notification header.
     */
    public void displayNotificationBar() {
        logger.info("Displaying the notification bar.");
        waitForSeconds(2);
        openNotificationBar();
        assertElementPresence(notificationHeader, NotificationPageConstants.NOTIFICATION_HEADER_NOT_FOUND);
    }

    /**
     * Clicks on the notification in the notification bar and stores the title and content for later comparison.
     */
    public void theUserClicksOnTheNotification() {
        logger.info("Clicking on the notification in the notification bar.");
        assertElementPresence(notificationMessage, NotificationPageConstants.NOTIFICATION_MESSAGE_NOT_FOUND);
        assertElementPresence(notificationMessageContent, NotificationPageConstants.NOTIFICATION_CONTENT_NOT_FOUND);
        StringContext.setData(NotificationPageConstants.NOTIFY_TITLE_CONTEXT_KEY, getText(notificationMessage));
        StringContext.setData(NotificationPageConstants.NOTIFY_CONTENT_CONTEXT_KEY, getText(notificationMessageContent));
        clickElement(notificationMessage);
    }

    /**
     * Verifies that the notification detail page has opened by checking for the presence of the image.
     */
    public void theNotificationDetailShouldOpen() {
        logger.info("Verifying that the notification detail page has opened.");
        assertElementPresence(notificationDetailImage, NotificationPageConstants.NOTIFICATION_DETAIL_PAGE_NOT_FOUND);
    }

    /**
     * Verifies that the title and content in the notification detail page match those in the notification bar.
     */
    public void notificationDetailShouldMatchNotificationBar() {
        logger.info("Verifying that notification details match the notification bar contents.");
        Assert.assertEquals(NotificationPageConstants.NOTIFICATION_DETAIL_TITLE_MISMATCH,
                StringContext.getData(NotificationPageConstants.NOTIFY_TITLE_CONTEXT_KEY), getText(notificationDetailMessage));
        Assert.assertEquals(NotificationPageConstants.NOTIFICATION_DETAIL_CONTENT_MISMATCH,
                StringContext.getData(NotificationPageConstants.NOTIFY_CONTENT_CONTEXT_KEY), getText(notificationDetailContent));
    }
}
