package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

public class CommonMethods {


    private static final int WAIT_TIME = 20;
    private static WebDriverWait webDriverWait;
    private static Actions actions;
    private static JavascriptExecutor jsExecutor;

    static {
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(WAIT_TIME));
        actions = new Actions(getDriver());
        jsExecutor = (JavascriptExecutor) getDriver();
    }

    public void clickElement(WebElement element) {
        waitForClickable(element).click();
    }

    public static void clickElementWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void typeToInput(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void hoverOverOnElement(WebElement element) {
        actions.moveToElement(waitForVisibility(element)).perform();
    }

    public void selectByText(WebElement element, String text) {
        waitFor(3);
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollUpToPage() {
        jsExecutor.executeScript("window.scrollTo(0, 0)");
    }


    public void scrollToElementWithJs(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public WebElement waitForVisibility(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitForClickable(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
