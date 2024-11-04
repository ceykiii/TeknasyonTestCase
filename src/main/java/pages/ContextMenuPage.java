package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.ContextMenuConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@code ContextMenuPage} class provides methods to interact with and validate the
 * elements on a context menu page, including long press actions and visibility checks
 * for specific menu options.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class ContextMenuPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ContextMenuPage.class);

    @FindBy(id = ContextMenuConstants.LONG_PRESS_BUTTON_ID)
    private WebElement longPressMeButton;

    @FindBy(xpath = ContextMenuConstants.MENU_A_XPATH)
    private WebElement menuA;

    @FindBy(xpath = ContextMenuConstants.MENU_B_XPATH)
    private WebElement menuB;

    /**
     * Constructor that initializes the {@code ContextMenuPage} with an {@link AppiumDriver} instance.
     *
     * @param driver the Appium driver instance used for interacting with mobile elements.
     */
    public ContextMenuPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Asserts that the "Long Press Me" button is present, then performs a long press action on it.
     * The press duration is specified in seconds.
     */
    public void theUserLongPressesTheButton() {
        logger.info("Attempting to long press on the 'Long Press Me' button");
        assertElementPresence(longPressMeButton, ContextMenuConstants.LONG_PRESS_BUTTON_NOT_FOUND_ERROR);
        longPressElement(longPressMeButton, 5);
        logger.info("Successfully performed a long press on the 'Long Press Me' button");
    }

    /**
     * Asserts that both "Menu A" and "Menu B" options are visible on the context menu.
     * These elements are validated to ensure they are displayed after a long press.
     */
    public void theAndOptionsShouldBeVisible() {
        logger.info("Verifying visibility of 'Menu A' and 'Menu B' options on the context menu");
        assertElementPresence(menuA, ContextMenuConstants.MENU_A_NOT_FOUND_ERROR);
        assertElementPresence(menuB, ContextMenuConstants.MENU_B_NOT_FOUND_ERROR);
        logger.info("'Menu A' and 'Menu B' options are visible on the context menu");
    }
}
