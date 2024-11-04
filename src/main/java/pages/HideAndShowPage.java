package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.HideAndShowConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code HideAndShowPage} class represents the page where elements can be hidden or shown,
 * with methods to interact with these elements and validate their visibility.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class HideAndShowPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(HideAndShowPage.class);

    @FindBy(id = HideAndShowConstants.TOGGLE_BUTTON_1_ID)
    private WebElement toggleButton1;

    @FindBy(id = HideAndShowConstants.TOGGLE_BUTTON_2_ID)
    private WebElement toggleButton2;

    @FindBy(xpath = HideAndShowConstants.INITIAL_TEXT_1_XPATH)
    private WebElement initialText1;

    @FindBy(xpath = HideAndShowConstants.INITIAL_TEXT_2_XPATH)
    private WebElement initialText2;

    @FindBy(id = HideAndShowConstants.TEXT_BOX_FRAGMENT_2_ID)
    private WebElement textBoxFragment2;

    /**
     * Constructor that initializes the elements with AppiumFieldDecorator.
     *
     * @param driver the Appium driver instance.
     */
    public HideAndShowPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        logger.info("HideAndShowPage initialized.");
    }

    /**
     * Verifies the presence of two 'Hide' buttons and two text boxes on the screen.
     */
    public void verifyTwoHideButtonsAndTwoTextBoxes() {
        logger.info("Verifying the presence of two 'Hide' buttons and two text boxes.");
        assertElementPresence(toggleButton1, HideAndShowConstants.BUTTON_1_NOT_FOUND);
        assertElementPresence(toggleButton2, HideAndShowConstants.BUTTON_2_NOT_FOUND);
        assertElementPresence(initialText1, HideAndShowConstants.TEXT_BOX_1_NOT_FOUND);
        assertElementPresence(initialText2, HideAndShowConstants.TEXT_BOX_2_NOT_FOUND);
    }

    /**
     * Clicks the second 'Hide' button.
     */
    public void clickSecondHideButton() {
        logger.info("Clicking the second 'Hide' button.");
        clickElement(toggleButton2);
    }

    /**
     * Verifies that the second text box is hidden and that the button label has changed to the expected status.
     *
     * @param expectedStatus the expected button text, such as "Show".
     */
    public void verifySecondTextBoxHiddenAndButtonStatus(String expectedStatus) {
        logger.info("Verifying that the second text box is hidden and button status is '{}'.", expectedStatus);
        Assert.assertFalse(HideAndShowConstants.TEXT_BOX_2_NOT_HIDDEN,
                isElementPresent(textBoxFragment2, DEFAULT_TIMEOUT));
        Assert.assertEquals(HideAndShowConstants.BUTTON_STATUS_MISMATCH,
                expectedStatus, toggleButton2.getText());
    }

    /**
     * Clicks the second 'Show' button.
     */
    public void clickSecondShowButton() {
        logger.info("Clicking the second 'Show' button.");
        clickElement(toggleButton2);
    }

    /**
     * Verifies that the second text box is visible and that the button label has changed to the expected status.
     *
     * @param expectedStatus the expected button text, such as "Hide".
     */
    public void verifySecondTextBoxVisibleAndButtonStatus(String expectedStatus) {
        logger.info("Verifying that the second text box is visible and button status is '{}'.", expectedStatus);
        assertElementPresence(textBoxFragment2, HideAndShowConstants.TEXT_BOX_2_NOT_FOUND);
        Assert.assertEquals(HideAndShowConstants.BUTTON_STATUS_MISMATCH,
                expectedStatus, toggleButton2.getText());
    }
}
