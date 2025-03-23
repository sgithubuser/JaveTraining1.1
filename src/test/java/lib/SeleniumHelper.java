package lib;

import Exceptions.ElementNotClickableException;
import Exceptions.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;

public class SeleniumHelper {


    private WebDriver _webDriver;
    private WebDriverWait _wait;
    private By _sectionRootLocator;
    private JavascriptExecutor _javascriptExecutor;
    public static final Duration SECONDS_HUNDRED_TWENTY_TIMEOUT = Duration.ofSeconds(120);
    public static final Duration SECONDS_TEN_INTERVAL = Duration.ofSeconds(10);
    private static By SPINNER = By.cssSelector("p-progressspinner");

    static final int RETRY_ATTEMPTS = 5;

    // Constructor
    public SeleniumHelper(WebDriver driver) {
        this._webDriver = driver; // Assign the provided driver
        _wait = new WebDriverWait(_webDriver, getPageLoadTimeoutDuration());
        _javascriptExecutor = (JavascriptExecutor) _webDriver;
        _webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Method to get the page load timeout duration (can be customized)
    private Duration getPageLoadTimeoutDuration() {
        return SECONDS_HUNDRED_TWENTY_TIMEOUT;
    }
    public WebElement waitUntilElementVisible(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(_webDriver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementPresent(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(_webDriver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public void click(By locator) {
        WebElement element;
        try {
            element = _webDriver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new ElementNotFoundException("Element not found: " + locator);
        }

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback: try using JavaScript click if intercepted
            try {
                _javascriptExecutor.executeScript("arguments[0].click();", element);
            } catch (Exception jsException) {
                throw new ElementNotClickableException("Element is not clickable: " + locator);
            }
        } catch (Exception e) {
            throw new ElementNotClickableException("Unexpected error while clicking the element: " + locator);
        }
    }

    public String getText(By locator) {
        WebElement element;
        try {
            element = _webDriver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new ElementNotFoundException("Element not found: " + locator);
        }

        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            // Fallback: try using JavaScript if intercepted
            throw new ElementNotClickableException("Unexpected error while getting text for element: " + locator);
        }

    }

    // Method to send keys to an element
    public void sendKeys(By locator, String text) {
        WebElement element;
        try {
            element = _webDriver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new ElementNotFoundException("Element not found: " + locator);
        }

        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new ElementNotInteractableException("Unable to send keys to element: " + locator);
        }
    }

    public String getPageTitle() {
        try {
            return _webDriver.getTitle();
        }  catch (Exception e) {
            throw new RuntimeException("Unexpected error while retrieving the page title: " + e.getMessage());
        }
    }

    public String getCurrentUrl() {
        try {
            return _webDriver.getCurrentUrl();
        }  catch (Exception e) {
            throw new RuntimeException("Unexpected error while retrieving the page URL: " + e.getMessage());
        }
    }

    public void reloadPage() {
        _webDriver.navigate().refresh();
    }

    public void goBack() {
        _webDriver.navigate().back();
    }
}
