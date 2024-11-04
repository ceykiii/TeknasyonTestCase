package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import constants.CommonPageConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * The {@code CommonPage} class provides navigation utilities and common interactions
 * within an Appium-based mobile application. The class includes methods for navigating
 * through a given menu structure by interacting with UI elements based on their content descriptions.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class CommonPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(CommonPage.class);

    /**
     * Constructor that initializes the {@code CommonPage} with an {@link AppiumDriver} instance.
     *
     * @param driver the Appium driver instance used for interacting with mobile elements.
     */
    public CommonPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Navigates through a specified menu sequence based on the provided {@link DataTable}.
     * Each menu item is located by its content description and clicked in sequence.
     *
     * @param menuTable a {@link DataTable} containing the menu items to navigate, with each
     *                  item identified by its "MenuItem" key.
     */
    public void navigateToMenu(DataTable menuTable) {
        List<Map<String, String>> rows = menuTable.asMaps();
        for (Map<String, String> row : rows) {
            String menuItem = row.get(CommonPageConstants.MENU_ITEM_KEY).trim();
            By locator = By.xpath(String.format(CommonPageConstants.MENU_ITEM_XPATH_TEMPLATE, menuItem));
            String errorMessage = String.format(CommonPageConstants.MENU_ITEM_NOT_FOUND_ERROR, menuItem);

            logger.info("Navigating to menu item: {}", menuItem);
            assertElementPresence(locator, errorMessage);
            clickElement(locator);
            logger.info("Successfully navigated to menu item: {}", menuItem);
        }
    }
}
