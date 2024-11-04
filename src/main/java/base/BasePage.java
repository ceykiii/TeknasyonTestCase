package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.*;
import static util.ErrorCodes.*;

/**
 * The {@code BasePage} class provides essential actions for interacting with elements in an Appium mobile test environment.
 * This includes functions for finding, clicking, swiping, and validating elements on mobile applications.
 * Author: Cem AÇAR
 * Email: cem.acar03@gmail.com
 */
public class BasePage {

    protected AppiumDriver driver;
    protected static final int DEFAULT_TIMEOUT = 10;
    private static final int DEFAULT_IMPLICIT_WAIT = 10;
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    /**
     * Constructs a {@code BasePage} with the provided AppiumDriver.
     *
     * @param driver The AppiumDriver instance.
     */
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Waits for a specific condition within the provided timeout.
     *
     * @param condition The ExpectedCondition to wait for.
     * @param timeout   Duration to wait.
     * @param <T>       Type parameter for the expected condition.
     * @return The condition result once fulfilled.
     */
    private <T> T waitForCondition(ExpectedCondition<T> condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            return wait.until(condition);
        } catch (Exception e) {
            logger.info("Condition not met: " + e.getMessage());
            return null;
        }
    }

    /**
     * Finds an element by its locator and waits for it to be visible within the specified timeout.
     *
     * @param by      Locator for the element.
     * @param timeout Timeout duration.
     * @return The located WebElement.
     */
    public WebElement findElement(By by, int timeout) {
        return waitForCondition(ExpectedConditions.visibilityOfElementLocated(by), timeout);
    }

    public WebElement findElement(By by) {
        return findElement(by, DEFAULT_TIMEOUT);
    }

    /**
     * Clicks on an element located by a given locator within a specified timeout.
     *
     * @param by      Locator for the element.
     * @param timeout Timeout duration.
     */
    public void clickElement(By by, int timeout) {
        WebElement element = waitForCondition(ExpectedConditions.elementToBeClickable(by), timeout);
        if (element != null) element.click();
    }

    public void clickElement(By by) {
        clickElement(by, DEFAULT_TIMEOUT);
    }

    /**
     * Clicks on a WebElement within the specified timeout.
     *
     * @param element The WebElement to click.
     * @param timeout Timeout duration.
     */
    public void clickElement(WebElement element, int timeout) {
        if (waitForCondition(ExpectedConditions.elementToBeClickable(element), timeout) != null) {
            element.click();
        }
    }

    public void clickElement(WebElement element) {
        clickElement(element, DEFAULT_TIMEOUT);
    }

    /**
     * Checks if an element located by a given locator is present within the specified timeout.
     *
     * @param by      Locator for the element.
     * @param seconds Timeout duration.
     * @return True if the element is present; false otherwise.
     */
    public boolean isElementPresent(By by, int seconds) {
        return checkPresence(by, null, seconds);
    }

    public boolean isElementPresent(WebElement element, int seconds) {
        return checkPresence(null, element, seconds);
    }

    /**
     * Verifies the presence of an element either by locator or by WebElement within a specified timeout.
     *
     * @param by      Locator for the element.
     * @param element WebElement to check.
     * @param seconds Timeout duration.
     * @return True if the element is present; false otherwise.
     */
    public boolean checkPresence(By by, WebElement element, int seconds) {
        setImplicitWait();
        boolean flag = false;
        try {
            if (by != null) {
                WebElement locatedElement = waitForCondition(ExpectedConditions.presenceOfElementLocated(by), seconds);
                flag = locatedElement != null && locatedElement.isDisplayed();
            } else if (element != null) {
                flag = waitForCondition(ExpectedConditions.visibilityOf(element), seconds) != null && element.isDisplayed();
            }
        } catch (Exception e) {
            logger.info("Element not found: {}", e.getMessage());
        } finally {
            setImplicitWait();
        }
        return flag;
    }

    /**
     * Asserts the presence of an element located by the specified locator.
     *
     * @param by      Locator for the element.
     * @param message Assertion message.
     */
    public void assertElementPresence(By by, String message) {
        Assert.assertTrue(message, isElementPresent(by, DEFAULT_TIMEOUT));
    }

    public void assertElementPresence(WebElement element, String message) {
        Assert.assertTrue(message, isElementPresent(element, DEFAULT_TIMEOUT));
    }

    /**
     * Sends the specified text to an element located by a given locator.
     *
     * @param by   Locator for the element.
     * @param text Text to send.
     */
    public void sendKeys(By by, String text) {
        WebElement element = findElement(by, DEFAULT_TIMEOUT);
        if (element != null) {
            element.clear();
            element.sendKeys(text);
        }
    }

    /**
     * Returns a random element from a list of WebElements.
     *
     * @param elements List of WebElements.
     * @return A randomly selected WebElement.
     */
    public WebElement getRandomElement(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_OR_NULL_LIST_ERROR);
        }
        Random random = new Random();
        int index = random.nextInt(elements.size());
        return elements.get(index);
    }

    public void sendKeys(WebElement element, String text) {
        if (waitForCondition(ExpectedConditions.visibilityOf(element), DEFAULT_TIMEOUT) != null) {
            element.clear();
            element.sendKeys(text);
        }
    }

    /**
     * Retrieves the text from an element located by the specified locator.
     *
     * @param by Locator for the element.
     * @return Text of the located element.
     */
    public String getText(By by) {
        WebElement element = waitForCondition(ExpectedConditions.visibilityOfElementLocated(by), DEFAULT_TIMEOUT);
        return element != null ? element.getText() : null;
    }

    public String getText(WebElement element) {
        if (waitForCondition(ExpectedConditions.visibilityOf(element), DEFAULT_TIMEOUT) != null) {
            return element.getText();
        }
        return null;
    }

    /**
     * Performs a long press on a WebElement for a specified duration.
     *
     * @param element WebElement to long press.
     * @param seconds Duration in seconds.
     */
    public void longPressElement(WebElement element, int seconds) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence longPress = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        element.getLocation().getX(), element.getLocation().getY()))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(seconds)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(longPress));
    }

    /**
     * Scrolls to an element using UiScrollable and clicks it.
     *
     * @param locator Locator for the element.
     */
    public void scrollToAndClick(By locator) {
        String scrollableCommand = getUiScrollableCommand(locator);

        Map<String, Object> params = new HashMap<>();
        params.put("strategy", "-android uiautomator");
        params.put("selector", scrollableCommand);

        driver.executeScript("mobile: scroll", params);
        driver.findElement(locator).click();
    }

    /**
     * Performs a left swipe on a specified element.
     *
     * @param element Element to swipe on.
     */
    public void swipeLeftOnElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("percent", 0.15);
        js.executeScript("mobile: swipeGesture", params);
    }

    /**
     * Generates a UiScrollable command string for scrolling to an element based on its locator.
     *
     * @param locator Locator for the element.
     * @return UiScrollable command string.
     */
    private String getUiScrollableCommand(By locator) {
        String locatorString = locator.toString();
        String uiSelector;

        if (locatorString.contains("By.id:")) {
            String id = locatorString.split("By.id: ")[1];
            uiSelector = "new UiSelector().resourceId(\"" + id + "\")";
        } else if (locatorString.contains("By.xpath:") && locatorString.contains("@content-desc")) {
            String contentDesc = locatorString.split("By.xpath: ")[1].split("'")[1];
            uiSelector = "new UiSelector().description(\"" + contentDesc + "\")";
        } else if (locatorString.contains("By.xpath:") && locatorString.contains("@text")) {
            String text = locatorString.split("By.xpath: ")[1].split("'")[1];
            uiSelector = "new UiSelector().text(\"" + text + "\")";
        } else {
            throw new IllegalArgumentException(UNSUPPORTED_LOCATOR_ERROR+ locator.toString());
        }

        return "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" + uiSelector + ");";
    }

    private void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(BasePage.DEFAULT_IMPLICIT_WAIT));
    }

    /**
     * Opens the notification bar if the driver is an AndroidDriver.
     */
    public void openNotificationBar() {
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).openNotifications();
            logger.info("Notification bar opened on Android device.");
        } else {
            logger.info("This feature is only available on Android devices.");
        }
    }

    /**
     * Waits for the specified number of seconds.
     *
     * @param seconds Duration in seconds.
     */
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
            logger.info("Waiting for " + seconds + " seconds...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Error during wait: " + e.getMessage());
        }
    }
}
