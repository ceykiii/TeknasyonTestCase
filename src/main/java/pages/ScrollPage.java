package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.ScrollPageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The {@code ScrollPage} class provides methods to scroll through a horizontal tab menu
 * and interact with specific tabs in the menu.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class ScrollPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ScrollPage.class);

    @FindBy(className = ScrollPageConstants.SCROLL_VIEW_CLASS_NAME)
    private WebElement scrollViewElement;

    @FindBy(id = ScrollPageConstants.TAB_ELEMENTS_ID)
    private List<WebElement> tabElements;

    /**
     * Initializes the elements with AppiumFieldDecorator.
     *
     * @param driver the Appium driver instance
     */
    public ScrollPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        logger.info("ScrollPage initialized.");
    }

    /**
     * Scrolls to the specified tab menu item by its name and clicks on it.
     *
     * @param tabName The name of the menu item to scroll to and click (content-desc or text value)
     */
    public void scrollToAndClickMenu(String tabName) {
        logger.info("Scrolling to and clicking menu item: {}", tabName);
        By dynamicLocator = By.xpath(String.format(ScrollPageConstants.TAB_DYNAMIC_LOCATOR_XPATH_TEMPLATE, tabName));
        scrollToAndClick(dynamicLocator);
    }

    /**
     * Scrolls to the last tab item in a horizontally scrollable TabWidget and clicks it.
     * Continues scrolling to the left until the last visible tab remains the same after a swipe.
     */
    public void scrollToLastTabAndClick() {
        logger.info("Scrolling to the last tab item and clicking it.");
        String lastVisibleText = "";
        boolean isLastElementVisible = false;

        while (!isLastElementVisible) {
            WebElement lastElement = tabElements.get(tabElements.size() - 1);
            String currentText = lastElement.getText();
            logger.debug("Current text: {}", currentText);

            if (currentText.equals(lastVisibleText)) {
                clickElement(lastElement);
                isLastElementVisible = true;
                logger.info("Last element found and clicked.");
            } else {
                lastVisibleText = currentText;
                swipeLeftOnElement(scrollViewElement);
                logger.debug("Swiping left on the scroll view element.");
            }
        }
    }

    /**
     * Verifies that the opened tab's content matches the expected tab name.
     *
     * @param lastTabName The name of the tab to verify that it is open and its content is displayed.
     */
    public void theOpenedTabInformationShouldBelongTo(String lastTabName) {
        logger.info("Verifying that opened tab information belongs to: {}", lastTabName);
        By tabContentLocator = By.xpath(String.format(ScrollPageConstants.TAB_CONTENT_LOCATOR_XPATH_TEMPLATE, lastTabName));
        assertElementPresence(tabContentLocator, ScrollPageConstants.TAB_NOT_FOUND_ERROR);
    }
}
