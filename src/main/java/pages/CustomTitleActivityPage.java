package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.CustomTitleActivityConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.StringContext;

/**
 * The {@code CustomTitleActivityPage} class provides methods to interact with
 * and validate elements in a custom title activity. This includes updating and verifying
 * values in text boxes and navigation bar elements.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class CustomTitleActivityPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(CustomTitleActivityPage.class);

    @FindBy(id = CustomTitleActivityConstants.NAV_LEFT_TEXT_ID)
    private WebElement navLeftText;

    @FindBy(id = CustomTitleActivityConstants.NAV_RIGHT_TEXT_ID)
    private WebElement navRightText;

    @FindBy(id = CustomTitleActivityConstants.LEFT_TEXT_EDIT_ID)
    private WebElement leftTextEdit;

    @FindBy(id = CustomTitleActivityConstants.RIGHT_TEXT_EDIT_ID)
    private WebElement rightTextEdit;

    @FindBy(id = CustomTitleActivityConstants.LEFT_TEXT_BUTTON)
    private WebElement leftTextButton;

    @FindBy(id = CustomTitleActivityConstants.RIGHT_TEXT_BUTTON)
    private WebElement rightTextButton;

    /**
     * Constructor that initializes the {@code CustomTitleActivityPage} with an {@link AppiumDriver} instance.
     *
     * @param driver the Appium driver instance used for interacting with mobile elements.
     */
    public CustomTitleActivityPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        logger.info("CustomTitleActivityPage initialized.");
    }

    /**
     * Verifies the presence of default text boxes and navigation bar elements
     * on the custom title activity page.
     */
    public void verifyDefaultTextBoxAndNavBar() {
        logger.info("Verifying default text box and navigation bar elements.");
        assertElementPresence(navLeftText, CustomTitleActivityConstants.LEFT_NAVBAR_NOT_FOUND);
        assertElementPresence(navRightText, CustomTitleActivityConstants.RIGHT_NAVBAR_NOT_FOUND);
        assertElementPresence(leftTextEdit, CustomTitleActivityConstants.LEFT_TEXT_EDIT_NOT_FOUND);
        assertElementPresence(rightTextEdit, CustomTitleActivityConstants.RIGHT_TEXT_EDIT_NOT_FOUND);
    }

    /**
     * Updates the left text box with the specified text and stores the value in the {@link StringContext}.
     *
     * @param text the text to input into the left text box.
     */
    public void theUserUpdatesTheLeftTextBoxTo(String text) {
        logger.info("Updating left text box with text: {}", text);
        sendKeys(leftTextEdit, text);
        clickElement(leftTextButton);
        StringContext.setData(CustomTitleActivityConstants.LEFT_TEXT_KEY, text);
    }

    /**
     * Updates the right text box with the specified text and stores the value in the {@link StringContext}.
     *
     * @param text the text to input into the right text box.
     */
    public void theUserUpdatesTheRightTextBoxTo(String text) {
        logger.info("Updating right text box with text: {}", text);
        sendKeys(rightTextEdit, text);
        clickElement(rightTextButton);
        StringContext.setData(CustomTitleActivityConstants.RIGHT_TEXT_KEY, text);
    }

    /**
     * Verifies that the updated texts in the left and right text boxes match the values
     * stored in the {@link StringContext}. Also ensures these values are displayed
     * correctly in the navigation bar elements.
     */
    public void verifyUpdatedTextsInTextBoxesAndNavBar() {
        logger.info("Verifying updated texts in text boxes and navigation bar.");

        String expectedLeftText = StringContext.getData(CustomTitleActivityConstants.LEFT_TEXT_KEY);
        String expectedRightText = StringContext.getData(CustomTitleActivityConstants.RIGHT_TEXT_KEY);

        Assert.assertEquals(CustomTitleActivityConstants.LEFT_TEXT_MISMATCH, expectedLeftText, getText(leftTextEdit));
        Assert.assertEquals(CustomTitleActivityConstants.RIGHT_TEXT_MISMATCH, expectedRightText, getText(rightTextEdit));
        Assert.assertEquals(CustomTitleActivityConstants.LEFT_NAVBAR_TEXT_MISMATCH, expectedLeftText, getText(navLeftText));
        Assert.assertEquals(CustomTitleActivityConstants.RIGHT_NAVBAR_TEXT_MISMATCH, expectedRightText, getText(navRightText));
    }
}
