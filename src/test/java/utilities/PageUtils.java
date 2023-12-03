package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

public class PageUtils {

    private static final int WAIT_TIME = 20;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    private static JavascriptExecutor jsExecutor;

    static {
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME));
        actions = new Actions(getDriver());
        jsExecutor = (JavascriptExecutor) getDriver();
    }

    public static void clickElement(WebElement element) {
        waitForClickable(element).click();
    }

    public static void clickElementWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void typeToInput(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public static void hoverOverOnElement(WebElement element) {
        actions.moveToElement(waitForVisibility(element)).perform();
    }

    public static void scrollUpToPage() {
        jsExecutor.executeScript("window.scrollTo(0, 0)");
    }

    public static void scrollToElementWithJs(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebElement waitForVisibility(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilityOfAllElements(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static WebElement waitForClickable(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
