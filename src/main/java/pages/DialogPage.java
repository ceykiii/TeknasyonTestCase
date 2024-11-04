package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.DialogPageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.StringContext;

import java.util.List;

/**
 * The {@code DialogPage} class provides interaction methods for handling dialog elements
 * such as selecting list options and verifying alert messages in the dialog.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class DialogPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DialogPage.class);

    @FindBy(xpath = DialogPageConstants.LIST_DIALOG_TEXT_VIEWS_XPATH)
    private List<WebElement> listDialogTextViews;

    @FindBy(id = DialogPageConstants.DIALOG_MESSAGE_ELEMENT_ID)
    private WebElement dialogMessageElement;

    /**
     * Initializes the DialogPage with an {@link AppiumDriver}.
     *
     * @param driver the Appium driver instance used for interacting with mobile elements.
     */
    public DialogPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        logger.info("DialogPage initialized.");
    }

    /**
     * Finds and taps on the specified option in the dialog.
     *
     * @param option the content description of the option to tap.
     */
    public void theUserTapsOnTheOption(String option) {
        logger.info("Attempting to tap on option: {}", option);
        By listLocator = By.xpath(String.format(DialogPageConstants.OPTION_BUTTON_XPATH_TEMPLATE, option));
        assertElementPresence(listLocator, option);
        clickElement(listLocator);
    }

    /**
     * Selects a random element from the list dialog and stores its message content in the context.
     */
    public void theUserSelectsAnElementFromTheListDialog() {
        logger.info("Selecting a random element from the list dialog.");
        if (!listDialogTextViews.isEmpty()) {
            WebElement selectedElement = getRandomElement(listDialogTextViews);
            String dialogMessage = getText(selectedElement);
            clickElement(selectedElement);
            StringContext.setData(DialogPageConstants.DIALOG_MESSAGE_CONTEXT_KEY, dialogMessage);
            logger.info("Selected element's message stored in context: {}", dialogMessage);
        } else {
            logger.warn("List dialog is empty; no element selected.");
        }
    }

    /**
     * Verifies that the alert message contains the correct selection from the list dialog.
     */
    public void verifyAlertDisplaysCorrectSelection() {
        logger.info("Verifying that the alert displays the correct selection.");
        assertElementPresence(dialogMessageElement, DialogPageConstants.DIALOG_MESSAGE_ELEMENT_NOT_FOUND);
        boolean isMatch = getText(dialogMessageElement).contains(StringContext.getData(DialogPageConstants.DIALOG_MESSAGE_CONTEXT_KEY));
        Assert.assertTrue(DialogPageConstants.SELECTION_MISMATCH_ERROR, isMatch);
    }
}
